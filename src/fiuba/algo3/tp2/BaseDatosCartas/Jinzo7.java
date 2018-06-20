package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class Jinzo7 extends CartaMonstruo{

	public Jinzo7() {
		super("Jinzo 7", 500, 400, new NivelBasico());
	}

	@Override
	public void usarEfecto(){ //poner restricciones de que si se usa el efecto se da vuelta la carta.
		this.enemigo.restarPuntosDeVida(500);
	}
}
