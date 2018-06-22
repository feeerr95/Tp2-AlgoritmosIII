package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.EliminarATodosLosMonstruos;
import fiuba.algo3.tp2.CartaMagica;

public class AgujeroNegro extends CartaMagica{
	
	public AgujeroNegro() {
		super("Agujero Negro");
		efecto = new EliminarATodosLosMonstruos(this.duenio);
	}
}
