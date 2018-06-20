package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaTerreno;

public class Wasteland extends CartaTerreno{

	private final int aumentoAtkDuenio = 200; 
	private final int aumentoDefDuenio = 0;
	private final int aumentoAtkEnemigo = 0;
	private final int aumentoDefEnemigo = 300;
		
	public Wasteland() {
		super("Wasteland");
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
		this.duenio.bonificarCartas(200, 0);
		this.enemigo.bonificarCartas(0, 300);
	}
}
