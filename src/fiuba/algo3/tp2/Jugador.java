package fiuba.algo3.tp2;

import java.util.HashMap;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private BaseDatosCartas coleccionCartas; //Mazo va a tener que tener esto, y jugador solo tener un atributo mazo
	
	public Jugador() {

		this.puntosDeVida = 8000;
		this.campoDeJuego = new Campo();
		this.coleccionCartas = new BaseDatosCartas();
	}
	
	public Jugador(Campo unCampo) {
		this.puntosDeVida = 8000;
		this.campoDeJuego = unCampo;
		this.coleccionCartas = new BaseDatosCartas();
	}

	private EstadoCarta detectarEstadoCarta(String estadoDeLaCarta){
		if(estadoDeLaCarta.equals("HBAR")) return new EstadoHorizontalBocaArriba();
		if(estadoDeLaCarta.equals("HBAB")) return new EstadoVerticalBocaAbajo();
		if(estadoDeLaCarta.equals("VBAR")) return new EstadoVerticalBocaArriba();
		if(estadoDeLaCarta.equals("VBAB")) return new EstadoVerticalBocaAbajo();
		return null;//hay que manejar la excepción
	} //REFACTORIZAR
	
	public void agregarCarta(String nombreCarta , String modoCarta) {
		EstadoCarta estado = detectarEstadoCarta(modoCarta);
		Carta carta = this.coleccionCartas.buscarCarta(nombreCarta);
		this.campoDeJuego.agregarCarta(carta, estado); //HAY QUE VER EL EJERCICIO DE PIEDRA PAPEL O TIJERA
	}

	public boolean cartaEnJuego(String nombreCarta, String modoCarta) {
		EstadoCarta estado = detectarEstadoCarta(modoCarta);
		Carta carta = this.coleccionCartas.buscarCarta(nombreCarta);
		return this.campoDeJuego.cartaEnJuego(carta, estado);
	}

	public void destruirCarta(String nombreCarta){
		Carta unaCarta = this.coleccionCartas.buscarCarta(nombreCarta);
		this.campoDeJuego.agregarCartaAlCementerio(unaCarta);
	}
}
