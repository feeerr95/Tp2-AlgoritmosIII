package fiuba.algo3.tp2;


public class CartaMagica extends CartaEfecto {
	
	
	public CartaMagica(String nombre) {
		nombreCarta = nombre;
	}

	@Override
	public void agregarCarta(Campo campo, EstadoCarta unEstado) {
		this.cambiarEstado(unEstado);
		campo.agregarCarta(this);
	}
}

