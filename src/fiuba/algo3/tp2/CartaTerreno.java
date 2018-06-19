package fiuba.algo3.tp2;

public class CartaTerreno extends Carta{
	
	protected int aumentoAtkDuenio = 0; 
	protected int aumentoDefDuenio = 0;
	protected int aumentoAtkEnemigo = 0;
	protected int aumentoDefEnemigo = 0;
	
	public CartaTerreno(String unNombre){
		this.nombreCarta = unNombre;
	}

	@Override
	protected void colocarEnCampo(Campo campo) {
		campo.agregarCartaCampo(this);
	}
	
	public int obtenerAumentoAtkDuenio() {
		return this.aumentoAtkDuenio;
	}
	
	public int obtenerAumentoDefDuenio() {
		return this.aumentoDefDuenio;
	}
	
	public int obtenerAumentoAtkEnemigo() {
		return this.aumentoAtkEnemigo;
	}
	
	public int obtenerAumentoDefEnemigo() {
		return this.aumentoDefEnemigo;
	}	
}
