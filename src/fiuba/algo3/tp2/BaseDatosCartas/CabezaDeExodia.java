package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVida;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class CabezaDeExodia extends CartaMonstruo{
	
	public CabezaDeExodia() {
		super("Cabeza De Exodia", 1000, 1000, new NivelBasico());
		//efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
	}

}
