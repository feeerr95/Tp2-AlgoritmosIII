package fiuba.algo3.tp2;

public class Jugador {

	private int puntosDeVida;
	private Campo campoDeJuego;

	public Jugador(Campo campo) {

		this.campoDeJuego = campo;
		this.puntosDeVida = 8000;
		this.campoDeJuego = new Campo();
	}

	public void restarPuntosDeVida(int cantidad){
		this.puntosDeVida -= cantidad;
	}

	public int puntosDeVida(){
		return this.puntosDeVida;
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
