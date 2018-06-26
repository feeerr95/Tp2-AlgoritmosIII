package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class BrazoIzquierdoDeExodia extends CartaMonstruo{
	
	public BrazoIzquierdoDeExodia() {
		super("Brazo Izquierdo De Exodia", 200, 300, new NivelBasico());
		efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
	}
	
	public void usarEfectoAlSacarCarta(){
		
		if(		duenio.estaEnLaMano("Exodia el prohibido") &&
				duenio.estaEnLaMano("Brazo Izquierdo De Exodia") &&
				duenio.estaEnLaMano("Brazo Derecho De Exodia") &&
				duenio.estaEnLaMano("Pierna izquierda del prohibido") && 
				duenio.estaEnLaMano("Pierna derecha del prohibido")) {
			efecto.usar(duenio);
		}
	}
}
