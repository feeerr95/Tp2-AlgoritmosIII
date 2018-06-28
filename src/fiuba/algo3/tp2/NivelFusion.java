package fiuba.algo3.tp2;

import java.util.ArrayList;

import excepciones.NoHayMonstruosEnCampo;

public class NivelFusion extends Nivel{

	private ArrayList<String> sacrificios = new ArrayList<>();

	@Override
	public void agregarSacrificio(String nombreCarta){
		sacrificios.add(nombreCarta);
	}
	
	@Override
	public void agregarseAlCampo(Campo campo, CartaMonstruo unaCarta) throws NoHayMonstruosEnCampo {

		boolean estanEnJuego = false;

		for (String nombreCarta : sacrificios) {
			if (!campo.estaEnElCampo(nombreCarta)) {
				estanEnJuego = false;
				break;
			}
			estanEnJuego = true;
		}
		if (estanEnJuego) {
			for(String nombreCarta: sacrificios){
				campo.destruirCarta(nombreCarta);
			}
			campo.agregarCartaEnZonaDeAtaque(unaCarta);
		} else {
			throw new NoHayMonstruosEnCampo(("No se encuentran los sacrificios necesarios"));
		}
	}
}
