package fiuba.algo3.tp2;

public abstract class Efecto {

    public abstract boolean usar(Afectable afectado);
    protected boolean usar(Carta cartaAtacada, Carta cartaAtacante){ //Es para las cartas trampa
        return false;
    }
    protected void aplicarSobreJugador(Jugador jugador){}
    protected void aplicarSobreCarta(Carta carta){}
    protected void aplicarSobreTablero(Tablero tablero){}

}
