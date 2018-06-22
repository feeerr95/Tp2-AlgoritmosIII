package fiuba.algo3.tp2.BaseDatosEfectos;

import fiuba.algo3.tp2.Afectable;
import fiuba.algo3.tp2.Efecto;
import fiuba.algo3.tp2.Tablero;

public class BonificarPuntos extends Efecto {

    private int bonificacionDefAtacante,
                bonificacionAtkAtacante,
                bonificacionDefAtacado,
                bonificacionAtkAtacado;

    public BonificarPuntos(int bonDefAtacante, int bonAtkAtacante, int bonDefAtacado, int bonAtkAtacado){
        bonificacionAtkAtacado = bonAtkAtacado;
        bonificacionAtkAtacante = bonAtkAtacante;
        bonificacionDefAtacado = bonDefAtacado;
        bonificacionDefAtacante = bonDefAtacante;
    }

    @Override
    public void usar(Afectable afectado) {
        afectado.recibirEfecto(this);
    }

    @Override
    public void aplicarSobreTablero(Tablero tablero){
        tablero.bonificarPuntos(bonificacionDefAtacante, bonificacionAtkAtacante, bonificacionDefAtacado, bonificacionAtkAtacado);
    }
}
