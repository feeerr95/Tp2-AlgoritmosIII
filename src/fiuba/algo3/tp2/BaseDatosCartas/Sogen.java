package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMagica;

public class Sogen extends CartaMagica{

	public Sogen() {
		super("Sogen");
	}
	
	@Override
	public void usarEfecto() {
		this.duenio.bonificarCartas(0, 500);
		this.enemigo.bonificarCartas(200, 0);
	}
}
