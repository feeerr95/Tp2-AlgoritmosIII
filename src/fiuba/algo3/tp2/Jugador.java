package fiuba.algo3.tp2;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;

	public Jugador(Campo campo) {
		this.nombreJugador = "Indefinido";
		this.campoDeJuego = campo;
		this.puntosDeVida = 8000;
	}
	
	public Jugador(String nombre, Campo campo) {
		this.nombreJugador = nombre;
		this.campoDeJuego = campo;
		this.puntosDeVida = 8000;
	}
	
	public void restarPuntosDeVida(int cantidad){
		this.puntosDeVida -= cantidad;
	}

	public int puntosDeVida(){
		return this.puntosDeVida;
	}

	public void destruirTodasLasCartasMonstruo(){
		this.campoDeJuego.destruirTodasLasCartasMonstruo();
	}

	public String obtenerNombre() {
		return this.nombreJugador;
	}

	public void bonificarCartas(int atkDuenio, int defDuenio) {
		this.campoDeJuego.bonificarCartas(atkDuenio, defDuenio);
	}
}
