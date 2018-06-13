package fiuba.algo3.tp2;

import java.util.Stack;

public class ZonaCampo implements Zona {

   private Carta campo;

   	public ZonaCampo() {
   		campo = null;
   	}
   
    public ZonaCampo(CartaCampo unCampo){
       campo = unCampo;
    }

    @Override
    public void agregarCarta(Carta unaCarta) {
        campo = unaCarta;
    }
}
