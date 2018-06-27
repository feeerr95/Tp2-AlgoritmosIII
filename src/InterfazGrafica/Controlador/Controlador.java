package InterfazGrafica.Controlador;

import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.ContenedorInicial;
import InterfazGrafica.Vista.ContenedorPrincipal;
import fiuba.algo3.tp2.*;

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

        if( jugador1.puntosDeVida() == 0 && jugador2.puntosDeVida() == 0){
            System.out.println("Hubo un empate");
            return true;
        }
        else if(jugador1.cantidadDeCartasEnElMazo() == 0 || jugador1.puntosDeVida() == 0){
            //ventana de que gano el jugador 2 y terminar juego
            System.out.println("Gano el jugador 2");
            return true;
        }
        else if(jugador1.cantidadDeCartasEnElMazo() == 0 || jugador1.puntosDeVida() == 0){
            System.out.println("Gano el jugador 1");
            return true;
            //ventana de que gano el jugador 2 y terminar juego
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

    public void colocarCartaEnCampo(Carta carta, PosicionCarta posicion, CaraCarta cara){
        if(jugador1.tieneLaCarta(carta.getNombreCarta())){
            jugador1.colocarEnElCampo(carta, posicion, cara);
        }
    }

    public void colocarMonstruo(CartaBoton carta, String posicionCarta, String caraCarta){
        contenedorPrincipal.colocarMonstruo(carta, posicionCarta, caraCarta);
    }


}
