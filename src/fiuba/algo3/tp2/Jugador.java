package fiuba.algo3.tp2;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	
	public void Jugador() {
		puntosDeVida = 8000;
		campoDeJuego = new Campo();
	}
}
