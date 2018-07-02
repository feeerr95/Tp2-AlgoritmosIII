package InterfazGrafica.Controlador;

import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.ContenedorInicial;
import InterfazGrafica.Vista.ContenedorPrincipal;
import excepciones.InsuficienteEspacioEnCampo;
import excepciones.NoHayMonstruosEnCampo;
import fiuba.algo3.tp2.*;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Controlador{

    private ContenedorPrincipal contenedorPrincipal;
    private ContenedorInicial contenedorInicial;
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private int puntosDeVidaJugador1;
    private int puntosDeVidaJugador2;
    private int turno;

    public Controlador(Tablero tablero, Jugador jugador1, Jugador jugador2){

        this.tablero = tablero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugador1.agregarEnemigo(jugador2);
        jugador2.agregarEnemigo(jugador1);
        jugador1.agarrarCartasIniciales();
        jugador2.agarrarCartasIniciales();
        turno = 1;
    }

    private boolean turnoEsPar(){
        return(this.turno%2 == 0);
    }

    public void terminarTurno(){
        this.turno += 1;
        if(turnoEsPar()){                         //Turnos pares son del jugador2
            jugador2.agarrarCarta();
            this.actualizarManos();
            contenedorPrincipal.cancelarManoJ1();
        }
        else{                                      //Turnos impares son del jugador 1
            jugador1.agarrarCarta();
            this.actualizarManos();
            contenedorPrincipal.cancelarManoJ2();
        }
        this.actualizarCantMazos();
    }

    private void actualizarManos(){
        contenedorPrincipal.actualizarManos(jugador1.getMano(), jugador2.getMano());
    }

    public void setContenedorInicial(ContenedorInicial contenedorInicial) {
        this.contenedorInicial = contenedorInicial;
    }

    public void setContenedorPrincipal(ContenedorPrincipal contenedorPrincipal) {
        this.contenedorPrincipal = contenedorPrincipal;
    }

    public ContenedorInicial getContenedorInicial() {
        return contenedorInicial;
    }

    public ContenedorPrincipal getContenedorPrincipal() {
        return contenedorPrincipal;
    }


    public void setManosIniciales(){
        ArrayList<Carta> manoJugador1 = jugador1.getMano();
        ArrayList<Carta> manoJugador2 = jugador2.getMano();
        this.actualizarPuntosDeVida();
        contenedorPrincipal.actualizarManos(manoJugador1,manoJugador2);
    }

    public boolean revisarSiSeGano(){

        if( jugador1.puntosDeVida() <= 0 && jugador2.puntosDeVida() <= 0){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("HUBO UN EMPATE");
            alerta.showAndWait();
            return true;
        }
        else if(jugador1.cantidadDeCartasEnElMazo() == 0 || jugador1.puntosDeVida() <= 0){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("GANO EL JUGADOR 2");
            alerta.showAndWait();
            return true;
        }
        else if(jugador2.cantidadDeCartasEnElMazo() == 0 || jugador2.puntosDeVida() <= 0){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("GANO EL JUGADOR 1");
            alerta.showAndWait();
            return true;
        }
        return false;
    }


    public void actualizarPuntosDeVida(){
        puntosDeVidaJugador1 = jugador1.puntosDeVida();
        puntosDeVidaJugador2 = jugador2.puntosDeVida();
        contenedorPrincipal.actualizarPuntosDeVida(puntosDeVidaJugador1, puntosDeVidaJugador2);
        this.revisarSiSeGano();
    }

    public void actualizarCantMazos(){
        contenedorPrincipal.actualizarLabelsMazo(jugador1.cantidadDeCartasEnElMazo(),jugador2.cantidadDeCartasEnElMazo());
    }

    public void colocarCartaEnCampo(CartaBoton carta, PosicionCarta posicion, CaraCarta cara){
        Carta cartaSelecionada = carta.getCarta();

        if(jugador1.tieneLaCarta(cartaSelecionada)){
            jugador1.colocarEnElCampo(cartaSelecionada, posicion, cara);
        }
        else{
            jugador2.colocarEnElCampo(cartaSelecionada,posicion,cara);
        }
    }

    public void colocarMonstruo(CartaBoton carta, String posicionCarta, String caraCarta){
        contenedorPrincipal.colocarMonstruo(carta, posicionCarta, caraCarta);
    }

    public void colocarTerreno(CartaBoton carta){

        Carta cartaSelecionada = carta.getCarta();

        PosicionCarta posicion = new PosicionVertical();
        CaraCarta cara = new BocaArriba();

        if(jugador1.tieneLaCarta(cartaSelecionada)){
            cartaSelecionada.usarEfectoContra(tablero);
            jugador1.colocarEnElCampo(cartaSelecionada, posicion, cara);
        }
        else{
            jugador2.colocarEnElCampo(cartaSelecionada, posicion,cara);
        }

        contenedorPrincipal.colocarTerreno(carta,"Vertical", "Arriba");
    }

    public void colocarCartaEfecto(CartaBoton carta){

        PosicionCarta posicion = new PosicionVertical();
        CaraCarta cara = new BocaAbajo();
        Carta cartaSelecionada = carta.getCarta();

        try{
            if(jugador1.tieneLaCarta(cartaSelecionada)){
                jugador1.colocarEnElCampo(cartaSelecionada, posicion, cara);
            }
            else{
                jugador2.colocarEnElCampo(cartaSelecionada,posicion,cara);
            }
            contenedorPrincipal.colocarCartaEfecto(carta,"Vertical", "Abajo");

        }catch(InsuficienteEspacioEnCampo excepcion){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("No se pueden colocar mas cartas");
            alerta.showAndWait();
        }

    }

    public void eliminarCartasDestruidas(){
        ArrayList<Carta> cartasJ1 = tablero.eliminarCartasDestruidasJ1();
        ArrayList<Carta> cartasJ2 = tablero.eliminarCartasDestruidasJ2();
        contenedorPrincipal.eliminarCartasDestruidas(cartasJ1, cartasJ2);
    }

    public ArrayList<CartaBoton> obtenerEnemigos(){
        if(turnoEsPar()){
            return contenedorPrincipal.obtenerMonstruosJ1();
        }
        return contenedorPrincipal.obtenerMonstruosJ2();
    }

    public void realizarAtaque(CartaMonstruo cartaAtacada, CartaMonstruo cartaAtacante){
        cartaAtacante.atacarOtraCarta(cartaAtacada);
    }

    public boolean estaEnJuego(Carta carta){
        return !(jugador1.estaEnLaMano(carta) || jugador2.estaEnLaMano(carta));
    }

    public boolean esElPrimerTurno(){
        return turno == 1;
    }

    public void atacarPuntosDeVidaEnemigo(CartaMonstruo carta){
        carta.restarPuntosDeVidaDelEnemigo();
    }
}
