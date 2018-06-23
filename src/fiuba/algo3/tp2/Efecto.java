package fiuba.algo3.tp2;

public abstract class Efecto {

    public abstract boolean usar(Afectable afectado);
    protected void aplicarSobreJugador(Jugador jugador){}
    protected void aplicarSobreCarta(Carta carta){}
    protected void aplicarSobreTablero(Tablero tablero){}
}
