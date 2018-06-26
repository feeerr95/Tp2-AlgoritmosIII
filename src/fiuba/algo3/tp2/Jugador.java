package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Afectable{
	
	private String nombreJugador;
	private int puntosDeVida;
	private Campo campoDeJuego;
	private Jugador enemigo;
	private ArrayList<Carta> mano;

	public Jugador(Campo campo) {
		this.campoDeJuego = campo;
		this.puntosDeVida = 8000;
		this.mano = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			this.agarrarCarta();
		}
	}

	public void recibirEfecto(Efecto efecto){
		efecto.aplicarSobreJugador(this);
	}

	public String getNombre(){
		return nombreJugador;
	}

	public void setNombre(String nombre){
		nombreJugador = nombre;
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
		Carta cartaAgarrada = this.campoDeJuego.agarrarCarta();
		mano.add(cartaAgarrada);
	}

	public void agregarCartaAMano(Carta unaCarta) {
		mano.add(unaCarta);
	}
	
	public void mandarAlCementerio(Carta carta){
		this.campoDeJuego.mandarAlCementerio(carta);
	}

	public int cantidadDeCartasEnElMazo(){
		return this.campoDeJuego.cantidadDeCartasEnElMazo();
	}

	public void eliminarCartaMasDebil() {
		this.campoDeJuego.eliminarCartaMasDebil();
	}

	public void agregarEnemigo(Jugador unEnemigo) {
		this.enemigo = unEnemigo;
	}

	public void eliminarMonstruoEnemigo(){
		this.enemigo.elminarMonstruo();
	}

	private void elminarMonstruo(){
		campoDeJuego.eliminarCartaAlAzar();
	}

	public boolean estaEnElCampo(Carta carta){
		return this.campoDeJuego.estaEnElCampo(carta);
	}

	public boolean cartasTrampaEnJuego(Carta cartaAtacada, Carta cartaAtacante){
		return campoDeJuego.cartasTrampaEnJuego(cartaAtacada, cartaAtacante);
	}
	
	public boolean estaEnLaMano(String nombreCarta) {
		for(Carta unaCarta: mano) {
			if(unaCarta.buscarCarta(nombreCarta)) {
				return true;
			}
		}
		return false;
	}
	
	//Se usa cuando se gana por un medio inusual o por medio de efectos especiales: Exodia, sin cartas en el mazo
	public void perderJuego() {
		this.restarPuntosDeVida(this.puntosDeVida);
	}
	public ArrayList<Carta> getMano(){
		return mano;
	}
	public void ganarJuego() {
		this.enemigo.perderJuego();	
	}

}
