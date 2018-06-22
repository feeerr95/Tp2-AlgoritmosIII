package fiuba.algo3.tp2;

public class CartaTerreno extends Carta{
	
	public CartaTerreno(String unNombre){
		this.nombreCarta = unNombre;
	}

	@Override
	public void agregarseAlCampo(Campo campo){
		campo.agregarCartaDeTerreno(this);
	}
}
