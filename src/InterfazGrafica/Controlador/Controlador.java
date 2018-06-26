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

    public Controlador(Tablero tablero, Jugador jugador1, Jugador jugador2){
        this.tablero = tablero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        jugador1.agregarEnemigo(jugador2);
        jugador2.agregarEnemigo(jugador1);
        jugador1.agarrarCartasIniciales();
        jugador2.agarrarCartasIniciales();

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
        contenedorPrincipal.setManos(manoJugador1,manoJugador2);

    }

    public void actualizarPuntosDeVida(){
        puntosDeVidaJugador1 = jugador1.puntosDeVida();
        puntosDeVidaJugador2 = jugador2.puntosDeVida();
        contenedorPrincipal.actualizarPuntosDeVida(puntosDeVidaJugador1, puntosDeVidaJugador2);
    }
}
