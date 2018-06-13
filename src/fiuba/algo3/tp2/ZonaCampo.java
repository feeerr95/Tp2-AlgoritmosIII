package fiuba.algo3.tp2;

import java.util.Stack;

public class ZonaCampo implements Zona {

   private Carta campo;

    public ZonaCampo(){
    }

    @Override
    public void agregarCarta(Carta unaCarta) {
        campo = unaCarta;
    }

    @Override
    public Carta removerCarta(Carta unaCarta) {
        return null;
    }
}
