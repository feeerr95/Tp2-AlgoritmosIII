package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaTerreno;

public class Sogen extends CartaTerreno{
	
	private final int aumentoAtkDuenio = 0; 
	private final int aumentoDefDuenio = 500;
	private final int aumentoAtkEnemigo = 200;
	private final int aumentoDefEnemigo = 0 ;
	
	public Sogen() {
		super("Sogen");
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
	
	@Override
	public void usarEfecto() {
		this.duenio.bonificarCartas(0, 500);
		this.enemigo.bonificarCartas(200, 0);
	}
}
