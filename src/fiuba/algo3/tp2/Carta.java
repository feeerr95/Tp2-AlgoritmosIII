package fiuba.algo3.tp2;

public abstract class Carta {
	
	protected String nombreCarta;
	protected EstadoCarta estado;
	
	public Carta() {
		nombreCarta = "Indefinido";
		estado = new EstadoVerticalBocaAbajo();
	}
	
	public void cambiarEstado(EstadoCarta unEstado) {
		this.estado = unEstado;
	}

	public String obtenerNombre() {
		return nombreCarta;
	}

	public abstract void agregarCarta(Campo campo, EstadoCarta unEstado);
	
}
