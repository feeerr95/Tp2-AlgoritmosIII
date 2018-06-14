package fiuba.algo3.tp2;

public class CartaMagica extends CartaEfecto{
		
	public CartaMagica(String unNombre) {	
		this.nombreCarta = unNombre;
	}
	
	public void ejecutarEfecto() {
		
	}

	@Override
	public void agregarCarta(Campo campo, EstadoCarta unEstado) {
		this.cambiarEstado(unEstado);
		campo.agregarAZonaDefensa(this);
	}
}
