package InterfazGrafica.Controlador;

import InterfazGrafica.Vista.ContenedorInicial;
import InterfazGrafica.Vista.ContenedorPrincipal;
import fiuba.algo3.tp2.Carta;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tablero;

import java.util.ArrayList;

public class Controlador{

    ContenedorPrincipal contenedorPrincipal;
    ContenedorInicial contenedorInicial;
    Jugador jugador1;
    Jugador jugador2;
    Tablero tablero;
    int puntosDeVidaJugador1;
    int puntosDeVidaJugador2;
    int turno;

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

    public void terminarTurno(){
        this.turno += 1;
        if( this.turno%2 == 0) jugador2.agarrarCarta();
        else jugador1.agarrarCarta();
        this.actualizarCantMazos();
        this.actualizarManos();
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
}
