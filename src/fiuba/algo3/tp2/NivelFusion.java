package fiuba.algo3.tp2;

import java.util.ArrayList;

public class NivelFusion extends Nivel{

	private ArrayList<CartaMonstruo> sacrificios;

	@Override
	public void agregarSacrificio(CartaMonstruo carta){
		sacrificios.add(carta);
	}
	
	@Override
	public void agregarseAlCampo(Campo campo, CartaMonstruo unaCarta) {
		boolean estanEnJuego = campo.cartasEstanEnJuego(sacrificios);
		if(estanEnJuego){
			for(CartaMonstruo sacrificio: sacrificios){
				campo.eliminarUnaCarta(sacrificio);
			}
		}
		else{
			//excepcion de que no se puede colocar la carta por falta de sacrificios
		}
		campo.agregarCarta(unaCarta);
	}
}
