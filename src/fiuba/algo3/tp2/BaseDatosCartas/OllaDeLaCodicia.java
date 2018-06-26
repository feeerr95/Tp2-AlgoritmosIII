package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AgarrarCartasDelMazo;
import fiuba.algo3.tp2.CartaMagica;

public class OllaDeLaCodicia extends CartaMagica{

	public OllaDeLaCodicia() {
		super("Olla De La Codicia");
		efecto = new AgarrarCartasDelMazo(2);
	}
}
