package fiuba.algo3.tp2;

public class Tablero {

    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero(){
    }

    public void cargarJugadores(Jugador unJugador, Jugador otroJugador){
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }


    public void eliminarTodasLasCartas(){
        this.jugador1.destruirTodasLasCartas();
        this.jugador2.destruirTodasLasCartas();
    }
}
