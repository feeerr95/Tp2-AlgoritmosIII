package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMagica;

public class OllaDeLaCodicia extends CartaMagica{

	public OllaDeLaCodicia() {
		super("Olla de la codicia");
	}

	@Override
	public void usarEfecto(){
		duenio.agarrarCarta();
		duenio.agarrarCarta();
		this.destruir();
	}
}
