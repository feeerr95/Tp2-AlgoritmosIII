package InterfazGrafica.Modelo;

import fiuba.algo3.tp2.Carta;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tablero;
import java.util.ArrayList;

public class Modelo {

    Jugador jugador1;
    Jugador jugador2;
    Tablero tablero;

    public Modelo(Tablero tablero, Jugador jugador1, Jugador jugador2){
        this.tablero = tablero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setNombres(String nombreJugador1, String nombreJugador2){
        jugador1.setNombre(nombreJugador1);
        jugador2.setNombre(nombreJugador2);
    }

    public ArrayList<Carta> obtenerManoJugador1(){
        return jugador1.getMano();
    }

    public ArrayList<Carta> obtenerManoJugador2(){
        return jugador2.getMano();
    }
}
