package fiuba.algo3.tp2;

import java.util.Stack;

public abstract class Carta implements Afectable{
	protected String nombreCarta;
	protected PosicionCarta posicion;
	protected Jugador duenio;
	protected String estado;
	protected boolean bocaAbajo;
	protected Efecto efecto;
	

	public Carta() {
		posicion = new PosicionVertical();
		estado = "En juego";
		bocaAbajo = true;

	}

	@Override
	public void recibirEfecto(Efecto efecto){
		efecto.aplicarSobreCarta(this);
	}

	public void asignarDuenio(Jugador duenioNuevo){
		this.duenio = duenioNuevo;
	}

	public abstract void agregarseAlCampo(Campo campo);

	public void destruir(){
		this.estado = "Destruido";
		this.duenio.mandarAlCementerio(this);
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

	public boolean estaBocaAbajo(){
		return bocaAbajo;
	}

	public void usarEfectoContra(Afectable afectado){
		efecto.usar(afectado);
	}

	public void cambiarBonificaciones(int bonAtk, int bonDef){}
}
