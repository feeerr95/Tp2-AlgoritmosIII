package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.BonificarPuntos;
import fiuba.algo3.tp2.CartaTerreno;

public class Wasteland extends CartaTerreno{
		
	public Wasteland() {
		super("Wasteland");
		efecto = new BonificarPuntos(0,200,300,0);
	}
}
