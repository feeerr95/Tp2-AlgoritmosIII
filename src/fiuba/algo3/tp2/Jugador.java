package fiuba.algo3.tp2;

import java.util.HashMap;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private Map<String, EstadoCarta> estados;
	
	public Jugador() {
		puntosDeVida = 8000;
		campoDeJuego = new Campo();
		estados = new HashMap<String, EstadoCarta>;
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
		EstadoCarta unEstado;
		
        for (Entry<String, EstadoCarta> entry : testMap.entrySet()) {
            if (entry.getValue().equals(modoCarta)) {
                unEstado = entry.getKey();
            }
        }
		campoDeJuego.agregarCarta(unaCarta, unEstado);
	}
}
