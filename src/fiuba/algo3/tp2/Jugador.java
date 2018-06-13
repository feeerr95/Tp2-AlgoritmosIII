package fiuba.algo3.tp2;

import java.util.HashMap;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private Mazo mazo;
	
	public Jugador() {

		this.puntosDeVida = 8000;
		this.campoDeJuego = new Campo();
		this.mazo = new Mazo();
	}

	private EstadoCarta detectarEstadoCarta(String estadoDeLaCarta){
		if(estadoDeLaCarta.equals("HBAR")) return new EstadoHorizontalBocaArriba();
		if(estadoDeLaCarta.equals("HBAB")) return new EstadoVerticalBocaAbajo();
		if(estadoDeLaCarta.equals("VBAR")) return new EstadoVerticalBocaArriba();
		if(estadoDeLaCarta.equals("VBAB")) return new EstadoVerticalBocaAbajo();
		return null;
	} //REFACTORIZAR
	
	public void agregarCarta(String nombreCarta , String modoCarta) {
		EstadoCarta estado = detectarEstadoCarta(modoCarta);
		Carta carta = this.mazo.agarrarCarta(nombreCarta);
		
		this.campoDeJuego.agregarCarta(carta, estado); 
	}

	public boolean cartaEnJuego(String nombreCarta, String modoCarta) {
		EstadoCarta estado = detectarEstadoCarta(modoCarta);
		Carta carta = this.mazo.agarrarCarta(nombreCarta);
		return this.campoDeJuego.cartaEnJuego(carta, estado);
	}

	public void destruirCarta(String nombreCarta){
		Carta carta = this.mazo.agarrarCarta(nombreCarta);
		this.campoDeJuego.agregarCartaAlCementerio(carta);
	}
}
