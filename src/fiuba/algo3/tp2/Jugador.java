package fiuba.algo3.tp2;

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
	
	public void jugarCarta(String nombreCarta , String modoCarta) {
		EstadoCarta estado = detectarEstadoCarta(modoCarta);
		Carta carta = this.mazo.agarrarCarta(nombreCarta);
		this.campoDeJuego.agregarCarta(carta, estado); 
	}

	public boolean cartaEstaEnJuego(String nombreCarta, String modoCarta) {
		Carta carta = this.mazo.agarrarCarta(nombreCarta);
		return this.campoDeJuego.cartaEstaEnJuego(carta, modoCarta);
	}

	public void destruirCarta(String nombreCarta){
		Carta carta = this.mazo.agarrarCarta(nombreCarta);
		this.campoDeJuego.agregarCartaAlCementerio(carta);
	}

	public boolean cartaEnCementerio(String nombreCarta) {
		Carta carta = this.mazo.agarrarCarta(nombreCarta);
		return this.campoDeJuego.cartaEnCementerio(carta);
	}

	public void atacar(String string, String string2) {
		
	}
}
