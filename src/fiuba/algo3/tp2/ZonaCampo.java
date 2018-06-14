package fiuba.algo3.tp2;


public class ZonaCampo implements Zona {

   private Carta campo;

    public ZonaCampo(){
    }

    public void agregarCarta(CartaCampo unaCarta) {
        campo = unaCarta;
    }

    @Override
    public Carta removerCarta(Carta unaCarta) {
        return null;
    }
}
