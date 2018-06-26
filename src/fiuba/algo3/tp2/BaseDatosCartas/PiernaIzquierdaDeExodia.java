package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class PiernaIzquierdaDeExodia extends CartaMonstruo{

	public PiernaIzquierdaDeExodia() {
		super("Pierna Izquierda De Exodia", 200, 300, new NivelBasico());
		efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
	}
	
	public void usarEfectoAlSacarCarta(){
		
		if(		duenio.estaEnLaMano("Cabeza De Exodia") &&
				duenio.estaEnLaMano("Brazo Derecho De Exodia") &&
				duenio.estaEnLaMano("Brazo Izquierdo De Exodia") &&
				duenio.estaEnLaMano("Pierna Izquierda De Exodia") &&
				duenio.estaEnLaMano("Pierna Derecha De Exodia")) {
			efecto.usar(duenio);
		}
	}
}
