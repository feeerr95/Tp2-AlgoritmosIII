package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMagica;

public class Fisura extends CartaMagica{

	public Fisura() {
		super("Fisura");
	}
	
	@Override
	public void usarEfecto() {
		this.enemigo.eliminarCartaMasDebil();
		this.destruir();
	}

}
