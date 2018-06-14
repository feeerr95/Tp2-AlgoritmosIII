package fiuba.algo3.tp2;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private Mazo mazo;
	private Jugador enemigo;
	
	public Jugador() {

		this.puntosDeVida = 8000;
		this.campoDeJuego = new Campo();
		this.mazo = new Mazo();
		this.enemigo = null;
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

	public void atacar(String nombreCartaJugador, String nombreCartaEnemigo) {
		CartaMonstruo cartaJugador = this.campoDeJuego.obtenerCartaMonstruo(nombreCartaJugador);
		this.enemigo.recibirAtaque(cartaJugador , nombreCartaEnemigo);
		
	}

//	private void recibirAtaque(CartaMonstruo cartaEnemigo, String nombreCartaJugador) {
//		CartaMonstruo cartaAtacada = this.campoDeJuego.obtenerCartaMonstruo(nombreCartaJugador);
//		this.campoDeJuego.agregarCartaAlCementerio(cartaAtacada.recibirAtaque(cartaEnemigo));
//	} HAY QUE RESOLVER ESTE METODO

	public void agregarEnemigo(Jugador unEnemigo){
		this.enemigo = unEnemigo;
	}
}
