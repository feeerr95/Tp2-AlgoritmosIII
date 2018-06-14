package fiuba.algo3.tp2;

import java.util.ArrayList;

public class ZonaDefensa extends ZonaDeJuego {

    private ArrayList<CartaEfecto> casilleros;

    public ZonaDefensa(){
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

    public void agregarCarta(CartaEfecto unaCarta) {
        casilleros.add(unaCarta);
	}
}
