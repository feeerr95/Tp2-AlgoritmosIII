package fiuba.algo3.tp2;

import java.util.Stack;

public abstract class Carta{
	
	protected String nombreCarta;
	protected PosicionCarta posicion;
	protected Jugador duenio;
	protected Jugador enemigo;
	protected String estado;
	protected boolean bocaAbajo;
	

	public Carta() {
		posicion = new PosicionVertical();
		estado = "En juego";
		bocaAbajo = true;

	}

	public void asignarDuenio(Jugador duenioNuevo){
		this.duenio = duenioNuevo;
	}

	public void destruir(){
		this.estado = "Destruido";
	}

	public boolean estaDestruida(){
		return this.estado.equals("Destruido");
	}
	
	public void cambiarEstado(PosicionCarta unEstado) {
		this.posicion = unEstado;
	}

	protected void mandarAlCementerio(Stack cementerio){
		if(this.estaDestruida()) cementerio.push(this);
	}

	public void darVuelta() {
		this.bocaAbajo = !this.bocaAbajo;
	}
	
	protected abstract void colocarEnCampo(Campo campo);

	public boolean estaBocaAbajo(){
		return bocaAbajo;
	}


	// REVISAR ESTO.

	public void asignarEnemigo(Jugador unEnemigo){
		this.enemigo = unEnemigo;
	}

	public abstract void usarEfecto();
}
