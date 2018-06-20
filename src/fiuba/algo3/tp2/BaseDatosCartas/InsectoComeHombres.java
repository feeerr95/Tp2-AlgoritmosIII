package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.*;

public class InsectoComeHombres extends CartaMonstruo{
	
	
	public InsectoComeHombres() {
		super("InsectoComeHombres", 450, 600, new NivelBasico());
	}
	
	@Override
	public void usarEfecto() {

	}

	@Override
	protected void recibirAtaque(CartaMonstruo otraCarta, Jugador jugadorAtacante, PosicionCarta posicionAtacante, int ataqueAtacante){
		if(this.bocaAbajo && this.modoDefensa()){
			otraCarta.destruir();
		}
	}
}
