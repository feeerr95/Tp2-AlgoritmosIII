package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMagica;

public class Wasteland extends CartaMagica{

	public Wasteland() {
		super("Wasteland");
	}
	
	@Override
	public void usarEfecto() {
		tablero.bonificarCartas(this.duenio, 200, 0 , 0, 300);
	}
}
