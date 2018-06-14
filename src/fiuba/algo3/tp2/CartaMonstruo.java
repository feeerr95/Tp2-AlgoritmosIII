package fiuba.algo3.tp2;

public class CartaMonstruo extends Carta{

	private int atk;
	private int def;

	public CartaMonstruo(String unNombre, int unAtaque, int unaDefensa) {
		nombreCarta = unNombre;
		atk = unAtaque;
		def = unaDefensa;
	}

	@Override
	public void agregarCarta(Campo campo, EstadoCarta unEstado) {
		this.cambiarEstado(unEstado);
		campo.agregarCarta(this);
	}

	public void recibirAtaque(CartaMonstruo cartaEnemigo) {
		// TODO Auto-generated method stub
		
	}
}
