package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Collection;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private Jugador enemigo;
	private Collection<Carta> mano;

	public Jugador(Campo campo) {
		this.nombreJugador = "Indefinido";
		this.campoDeJuego = campo;
		this.puntosDeVida = 8000;
		this.mano = new ArrayList<>();
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
	
	public void agarrarCarta() {
		mano.add(this.campoDeJuego.agarrarCarta());
	}

	
//funciones de tablero	

	public void eliminarCartaMasDebil() {
		this.campoDeJuego.eliminarCartaMasDebil();
	}

	public void agregarEnemigo(Jugador unEnemigo) {
		this.enemigo = unEnemigo;
	}
}
