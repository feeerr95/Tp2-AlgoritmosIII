package fiuba.algo3.tp2;

public class CartaTrampa extends CartaEfecto{

	public CartaTrampa(String nombre) {
		nombreCarta = nombre;
	}

	@Override
	public void agregarCarta(Campo campo, EstadoCarta unEstado) {
		this.cambiarEstado(unEstado);
		campo.agregarCarta(this);
	}
}
