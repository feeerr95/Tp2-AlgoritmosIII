package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class BrazoIzquierdoDeExodia extends CartaMonstruo{
	
	public BrazoIzquierdoDeExodia() {
		super("Brazo izquierdo del prohibido", 200, 300, new NivelBasico());
		efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
	}
	
	public void usarEfectoAlSacarCarta(){
		
		if(
				duenio.estaEnLaMano("Exodia el prohibido") && 
				duenio.estaEnLaMano("Brazo izquierdo del prohibido") && 
				duenio.estaEnLaMano("Brazo derecho del prohibido") && 
				duenio.estaEnLaMano("Pierna izquierda del prohibido") && 
				duenio.estaEnLaMano("Pierna derecha del prohibido")) {
			efecto.usar(duenio);
		}
	}
}
