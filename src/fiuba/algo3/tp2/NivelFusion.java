package fiuba.algo3.tp2;

import java.util.ArrayList;

import excepciones.NoHayMonstruosEnCampo;

public class NivelFusion extends Nivel{

	private ArrayList<CartaMonstruo> sacrificios = new ArrayList<>();

	@Override
	public void agregarSacrificio(CartaMonstruo carta){
		sacrificios.add(carta);
	}
	
	@Override
	public void agregarseAlCampo(Campo campo, CartaMonstruo unaCarta) throws NoHayMonstruosEnCampo{
		boolean estanEnJuego = campo.cartasEstanEnJuego(sacrificios);
		if(estanEnJuego){
			for(CartaMonstruo sacrificio: sacrificios){
				campo.eliminarUnaCarta(sacrificio);
			}
		}
		else{
			throw new NoHayMonstruosEnCampo("No se encuentran los sacrificios necesarios");
		}
		campo.agregarCarta(unaCarta, new PosicionHorizontal(), new BocaArriba());
	}
}
