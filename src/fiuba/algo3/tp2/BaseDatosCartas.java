package fiuba.algo3.tp2;

import java.util.ArrayList;

public class BaseDatosCartas {
	
	private ArrayList<Carta> coleccion;
	
	public BaseDatosCartas() {
		coleccion = new ArrayList<Carta>();
		CartaMonstruo huevoMonstruoso = new CartaMonstruo("Huevo Monstruoso", 600, 900);
		coleccion.add(huevoMonstruoso);
		CartaMonstruo insectoComeHombre = new CartaMonstruo("Insecto Come-Hombres", 450, 600);
		coleccion.add(insectoComeHombre);
	}
	
	public Carta buscarCarta(String nombreCarta) {
		for(Carta cartaActual: coleccion ) {
			if(cartaActual.obtenerNombre() == nombreCarta) {
				return cartaActual;
			}
		}
		//falta manejar la excepcion
		return null;
	}
}
