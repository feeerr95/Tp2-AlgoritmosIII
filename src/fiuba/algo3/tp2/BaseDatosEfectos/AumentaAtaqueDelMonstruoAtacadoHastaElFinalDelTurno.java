package fiuba.algo3.tp2.BaseDatosEfectos;

import fiuba.algo3.tp2.Afectable;
import fiuba.algo3.tp2.Carta;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.Efecto;

public class AumentaAtaqueDelMonstruoAtacadoHastaElFinalDelTurno extends Efecto {

    private int bonificacionDefAtacado;
    private int bonificacionAtkAtacado;

    public AumentaAtaqueDelMonstruoAtacadoHastaElFinalDelTurno(int bonAtkAtacado, int bonDefAtacado){
        bonificacionAtkAtacado = bonAtkAtacado;
        bonificacionDefAtacado = bonDefAtacado;
    }

    @Override
    public boolean usar(Afectable afectado) {
        afectado.recibirEfecto(this);
        return false;
    }

    @Override
    public void aplicarSobreCarta(Carta unaCarta){
        CartaMonstruo carta = (CartaMonstruo) unaCarta;
        carta.cambiarBonificaciones(bonificacionAtkAtacado, bonificacionDefAtacado);
    }
}
