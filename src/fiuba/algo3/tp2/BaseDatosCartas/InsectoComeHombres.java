package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.BaseDatosEfectos.DestruirCartaAtacante;

public class InsectoComeHombres extends CartaMonstruo{
	
	
	public InsectoComeHombres() {
		super("InsectoComeHombres", 450, 600, new NivelBasico());
		efecto = new DestruirCartaAtacante();
	}


	@Override
	protected void recibirAtaque(CartaMonstruo otraCarta, Jugador jugadorAtacante, PosicionCarta posicionAtacante, int ataqueAtacante){
		if(this.bocaAbajo){
			efecto.usar(otraCarta);
		}
	}
}
