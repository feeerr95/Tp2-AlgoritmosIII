package fiuba.algo3.tp2;

import java.util.HashMap;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private BaseDatosCartas coleccionCartas;
	
	public Jugador() {

		
		puntosDeVida = 8000;
		campoDeJuego = new Campo();
		coleccionCartas = new BaseDatosCartas();

	}
	
	public Jugador(Campo unCampo) {
		puntosDeVida = 8000;
		campoDeJuego = unCampo;
	}
	
	public void agregarCarta(String nombreCarta , String modoCarta) {
		
		//hay que decidir si pasar el estado por argumento o convertirlo aca
		
		EstadoCarta unEstado = new EstadoVerticalBocaAbajo();
		Carta unaCarta = coleccionCartas.buscarCarta(nombreCarta);
		campoDeJuego.agregarCarta(unaCarta, unEstado);
	}

	public boolean cartaEnJuego(String nombreCarta, String modoCarta) {
		EstadoCarta unEstado = new EstadoVerticalBocaAbajo();
		Carta unaCarta = coleccionCartas.buscarCarta(nombreCarta);
		//hay que decidir si pasar el estado por argumento o convertirlo aca
		return campoDeJuego.cartaEnJuego(unaCarta, unEstado);
	}

	public void destruirCarta(String nombreCarta){
		Carta unaCarta = coleccionCartas.buscarCarta(nombreCarta);
		campoDeJuego.agregarCartaAlCementerio(unaCarta);
	}
}
