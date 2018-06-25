package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;
import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;

public class PiernaDerechaDeExodia extends CartaMonstruo{

	public PiernaDerechaDeExodia() {
		super("Pierna derecha del prohibido", 200, 300, new NivelBasico());
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
