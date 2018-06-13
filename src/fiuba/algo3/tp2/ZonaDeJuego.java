package fiuba.algo3.tp2;

import java.util.ArrayList;

public abstract class ZonaDeJuego implements Zona {

    protected ArrayList<Carta> casilleros;


    public boolean enJuego(Carta unaCarta) {
        return casilleros.contains(unaCarta);
    }

    @Override
    public void agregarCarta(Carta unaCarta) {
        casilleros.add(unaCarta);
    }

    public Carta removerCarta(Carta unaCarta) {
        int posCarta = casilleros.indexOf(unaCarta);
        return casilleros.remove(posCarta);
    }
}
