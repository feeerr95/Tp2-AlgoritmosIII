package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMagica;

public class Sogen extends CartaMagica{

	public Sogen() {
		super("Sogen");
	}
	
	@Override
	public void usarEfecto() {
		tablero.bonificarCartas(this.duenio, 0, 500 , 200, 0);
	}
}
