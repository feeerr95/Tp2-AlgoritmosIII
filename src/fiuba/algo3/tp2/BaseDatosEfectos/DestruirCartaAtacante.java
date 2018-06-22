package fiuba.algo3.tp2.BaseDatosEfectos;

import fiuba.algo3.tp2.Afectable;
import fiuba.algo3.tp2.Carta;
import fiuba.algo3.tp2.Efecto;

public class DestruirCartaAtacante extends Efecto {

    @Override
    public void usar(Afectable afectado) {
        afectado.recibirEfecto(this);
    }

    @Override
    public void aplicarSobreCarta(Carta carta){
        carta.destruir();
    }


}
