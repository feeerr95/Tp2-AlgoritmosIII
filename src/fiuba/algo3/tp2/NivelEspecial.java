package fiuba.algo3.tp2;

import java.util.Collection;

public class NivelEspecial extends Nivel{

	private Collection<String> sacrificios;
	
	public void agregarSacrificio(String unSacrificio){
		sacrificios.add(unSacrificio);
	}
	
	@Override
	public void colocarEnCampo(Campo campo, CartaMonstruo unaCarta) {
		boolean estanSacrificios = true;
		
		for(String sacrificioActual: sacrificios) {
			estanSacrificios = campo.eliminarUnaCarta(sacrificioActual);
		}
		
		if(estanSacrificios) {
			campo.agregarCartaMonstruo(unaCarta);
		}
	}
}
