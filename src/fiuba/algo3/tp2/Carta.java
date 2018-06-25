package fiuba.algo3.tp2;

import java.util.Stack;

public abstract class Carta implements Afectable{
	protected String nombreCarta;
	protected PosicionCarta posicion;
	protected Jugador duenio;
	protected String estado;
	protected CaraCarta cara;
	protected Efecto efecto;


	public Carta() {
		posicion = new PosicionVertical();
		estado = "En juego";

	}

	@Override
	public void recibirEfecto(Efecto efecto){
		efecto.aplicarSobreCarta(this);
	}

	//Es para chequear si las cartas de exodia están en la mano del jugador.
	public boolean buscarCarta(String unNombre) {
		if(this.nombreCarta == unNombre) {
			return true;
		}
		return false;
	}
	
	public void asignarDuenio(Jugador duenioNuevo){
		this.duenio = duenioNuevo;
	}

	protected void agregarseAlCampo(Campo campo, PosicionCarta unaPosicion, CaraCarta unaCara){
		this.cara = unaCara;
		this.posicion = unaPosicion;
		this.agregarseAlCampo(campo);
	}

	protected abstract void agregarseAlCampo(Campo campo);

	public void destruir(){
		this.estado = "Destruido";
		this.duenio.mandarAlCementerio(this);
	}

	public boolean estaDestruida(){
		return this.estado.equals("Destruido");
	}
	
	public void cambiarPosicion(PosicionCarta unaPosicion) {
		this.posicion = unaPosicion;
	}

	protected void mandarAlCementerio(Stack cementerio){
		if(this.estaDestruida()) cementerio.push(this);
	}

	public void darVuelta() {
		if(this.cara.estaBocaAbajo() && this.estaEnElCampo()){
			this.cara.darseVuelta(this.cara);
		}
	}

	public boolean estaBocaAbajo(){
		return this.cara.estaBocaAbajo();
	}

	public boolean usarEfectoContra(Afectable afectado){
		return efecto.usar(afectado);
	}

	public void cambiarBonificaciones(int bonAtk, int bonDef){
	}
	
	public boolean estaEnElCampo(){
		return this.duenio.estaEnElCampo(this);
	}

	public void usarEfectoAlSacarCarta() {}

}
