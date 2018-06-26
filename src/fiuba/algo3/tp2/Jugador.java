package fiuba.algo3.tp2;

import fiuba.algo3.tp2.BaseDatosCartas.ParteDeExodia;

import java.util.ArrayList;

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

	}

	public void agarrarCartasIniciales(){
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

	public void restarPuntosDeVida(Integer cantidad){
		if(cantidad != null){
			this.puntosDeVida -= cantidad;
		}
		else{
			this.puntosDeVida -= this.puntosDeVida;
		}
	}

	public int puntosDeVida(){
		return this.puntosDeVida;
	}
	
	public void agarrarCarta() {

		Carta cartaAgarrada = this.campoDeJuego.agarrarCarta();
		cartaAgarrada.asignarDuenio(this);
		mano.add(cartaAgarrada);
		if(cartaAgarrada instanceof ParteDeExodia){
			cartaAgarrada.usarEfectoAlSacarCarta();
		}


	}

	public boolean tieneLaCarta(String nombreCarta){
		return (this.estaEnLaMano(nombreCarta) || this.estaEnElCampo(nombreCarta));
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

	public boolean estaEnElCampo(String nombreCarta){
		return this.campoDeJuego.estaEnElCampo(nombreCarta);
	}

	public boolean cartasTrampaEnJuego(Carta cartaAtacada, Carta cartaAtacante){
		return campoDeJuego.cartasTrampaEnJuego(cartaAtacada, cartaAtacante);
	}
	
	public boolean estaEnLaMano(String nombreCarta) {
		for(Carta unaCarta: mano) {
			if(unaCarta.es(nombreCarta)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Carta> getMano(){
		return mano;
	}

	public void ganarJuego() {
		this.enemigo.restarPuntosDeVida(null);
	}
	
	public int cantidadDeCartasEnMano() {
		return mano.size();
	}

}
