package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMagica;

public class Wasteland extends CartaMagica{

	public Wasteland() {
		super("Wasteland");
	}
	
	@Override
	public void usarEfecto() {
		this.duenio.bonificarCartas(200, 0);
		this.enemigo.bonificarCartas(0, 300);
	}
}
