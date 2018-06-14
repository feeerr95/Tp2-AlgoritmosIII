package fiuba.algo3.tp2;

import java.util.ArrayList;

public abstract class ZonaDeJuego implements Zona {

    protected ArrayList<Carta> casilleros;


    public boolean enJuego(Carta unaCarta) {
        return casilleros.contains(unaCarta);
    }

    public Carta removerCarta(Carta unaCarta) {
        int posCarta = casilleros.indexOf(unaCarta);
        return casilleros.remove(posCarta);
    }

	public void agregarCarta(CartaMonstruo unaCarta) {
		
	}
	
	public void agregarCarta(CartaEfecto unaCarta) {
		
	}
}
