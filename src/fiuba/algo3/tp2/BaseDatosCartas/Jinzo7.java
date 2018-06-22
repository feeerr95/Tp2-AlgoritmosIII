package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVida;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class Jinzo7 extends CartaMonstruo{

	public Jinzo7() {
		super("Jinzo 7", 500, 400, new NivelBasico());
		efecto = new AtacarDirectoALosPuntosDeVida(500);
	}
}
