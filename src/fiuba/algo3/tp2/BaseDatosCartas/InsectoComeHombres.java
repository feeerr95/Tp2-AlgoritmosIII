package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.*;
import fiuba.algo3.tp2.BaseDatosEfectos.DestruirCartaMonstruoEnemigo;

public class InsectoComeHombres extends CartaMonstruo{
	
	
	public InsectoComeHombres() {
		super("InsectoComeHombres", 450, 600, new NivelBasico());
		efecto = new DestruirCartaMonstruoEnemigo();
	}

	@Override
	public void darVuelta(){
		if(this.cara.estaBocaAbajo() && this.estaEnElCampo()){
			this.cara.darseVuelta(this.cara);
			efecto.usar(this.duenio);
		}
	}
}
