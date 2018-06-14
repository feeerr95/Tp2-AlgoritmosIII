package fiuba.algo3.tp2;


public abstract class ZonaDeJuego implements Zona {

    public abstract boolean cartaEstaEnJuego(Carta unaCarta, String unEstado);

    public abstract Carta removerCarta(Carta unaCarta);
    
}
