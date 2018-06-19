package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private Jugador enemigo;
	private List<Carta> mano;

	public Jugador(String nombre, Campo campo) {
		this.nombreJugador = nombre;
		this.campoDeJuego = campo;
		this.puntosDeVida = 8000;
		this.mano = new ArrayList<>();
	}
	
	public void restarPuntosDeVida(int cantidad){
		this.puntosDeVida = this.puntosDeVida - cantidad;
	}

	public int puntosDeVida(){
		return this.puntosDeVida;
	}

	public void destruirTodasLasCartasMonstruo(){
		this.campoDeJuego.destruirTodasLasCartasMonstruo();
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
