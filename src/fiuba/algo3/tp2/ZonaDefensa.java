package fiuba.algo3.tp2;

import java.util.ArrayList;

public class ZonaDefensa extends ZonaDeJuego {

    private ArrayList<CartaEfecto> casilleros;

    public ZonaDefensa(){
        this.casilleros = new ArrayList<>(5);
    }
    
    @Override
	public void agregarCarta(CartaEfecto unaCarta) {
		casilleros.add(unaCarta);
	}
}
