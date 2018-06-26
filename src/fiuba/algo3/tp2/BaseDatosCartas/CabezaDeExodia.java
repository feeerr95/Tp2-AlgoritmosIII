package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelBasico;

public class CabezaDeExodia extends CartaMonstruo{
	
	public CabezaDeExodia() {
		super("Cabeza De Exodia", 1000, 1000, new NivelBasico());
		//efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
		efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
	}
	
	@Override
	public void usarEfectoAlSacarCarta(){
		
		if(		duenio.estaEnLaMano("Cabeza De Exodia") &&
				duenio.estaEnLaMano("Brazo Derecho De Exodia") &&
				duenio.estaEnLaMano("Brazo Izquierdo De Exodia") &&
				duenio.estaEnLaMano("Pierna Izquierda De Exodia") &&
				duenio.estaEnLaMano("Pierna Derecha De Exodia")){
			efecto.usar(duenio);
		}
	}	

}
