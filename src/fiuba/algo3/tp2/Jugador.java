package fiuba.algo3.tp2;

import java.util.HashMap;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private HashMap<String, EstadoCarta> estados;
	
	public Jugador() {
		EstadoCarta VERTICAL = null;
		EstadoCarta VERTICAL_OCULTA = null;
		EstadoCarta HORIZONTAL = null;
		EstadoCarta HORIZONTAL_OCULTA = null;
		
		puntosDeVida = 8000;
		campoDeJuego = new Campo();
		estados.put("PA", VERTICAL);
		estados.put("PAO", VERTICAL_OCULTA);
		estados.put("PD", HORIZONTAL);
		estados.put("PDO", HORIZONTAL_OCULTA);
	}
	
	public Jugador(Campo unCampo) {
		puntosDeVida = 8000;
		campoDeJuego = unCampo;
	}
	
	public void agregarCarta(Carta unaCarta , String modoCarta) {
		campoDeJuego.agregarCarta(unaCarta, modoCarta);
	}
}
