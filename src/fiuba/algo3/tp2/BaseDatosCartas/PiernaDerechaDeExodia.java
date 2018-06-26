package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.NivelBasico;
import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;

public class PiernaDerechaDeExodia extends ParteDeExodia{

	public PiernaDerechaDeExodia() {
		super("Pierna Derecha De Exodia", 200, 300, new NivelBasico());
		efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
	}

}
