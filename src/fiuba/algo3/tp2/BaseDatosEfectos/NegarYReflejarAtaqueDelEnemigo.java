package fiuba.algo3.tp2.BaseDatosEfectos;

import fiuba.algo3.tp2.*;

public class NegarYReflejarAtaqueDelEnemigo extends Efecto {

    @Override
    public boolean usar(Afectable afectado){
        return false;
    }
    @Override
    public boolean usar(Carta cartaAtacada, Carta cartaAtacante){
        cartaAtacante.recibirEfecto(this);
        return true;
    }
    @Override
    public void aplicarSobreCarta(Carta unaCarta){
        CartaMonstruo carta = (CartaMonstruo) unaCarta;
        carta.restarPuntosDeVida(carta.getPuntosDeAtaque());
    }
}
