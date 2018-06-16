package fiuba.algo3.tp2;

public abstract class CartaEfecto extends Carta {
	
    protected void colocarEnCampo(Tablero unTablero, Campo campo){
        campo.agregarCartaEfecto(this);
        this.tablero = unTablero;
    }
}