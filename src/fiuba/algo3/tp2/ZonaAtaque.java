package fiuba.algo3.tp2;

import java.util.ArrayList;

public class ZonaAtaque extends ZonaDeJuego {

    private ArrayList<CartaMonstruo> casilleros;

    public ZonaAtaque(){
        this.casilleros = new ArrayList<>(5);
    }

    @Override
    public boolean cartaEstaEnJuego(Carta unaCarta, String unEstado) {
        return (this.casilleros.contains(unaCarta) && unaCarta.tieneEstado(unEstado));
    }

    @Override
    public Carta removerCarta(Carta unaCarta) {
        int posCarta = casilleros.indexOf(unaCarta);
        return casilleros.remove(posCarta);
    }

    public void agregarCarta(CartaMonstruo unaCarta) {
        casilleros.add(unaCarta);
    }

	public CartaMonstruo obtenerCartaMonstruo(String nombreCarta) {
		for (int i = 0; i < casilleros.size(); i++) {
			CartaMonstruo cartaActual = casilleros.get(i);
			if(cartaActual.obtenerNombre() == nombreCarta) {
				return cartaActual;
			}
		}
		return null;//manejar excepcion
	}


    
    

}
