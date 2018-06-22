package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.BonificarPuntos;
import fiuba.algo3.tp2.CartaTerreno;

public class Sogen extends CartaTerreno{
	
	public Sogen() {
		super("Sogen");
		efecto = new BonificarPuntos(500,0,0,200);
	}
}
