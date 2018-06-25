package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class CabezaDeExodia extends CartaMonstruo{
	
	public CabezaDeExodia() {
		super("Exodia el prohibido", 1000, 1000, new NivelBasico());
		efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
	}
	
	@Override
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
