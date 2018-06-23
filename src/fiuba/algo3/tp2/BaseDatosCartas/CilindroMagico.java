package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.Afectable;
import fiuba.algo3.tp2.BaseDatosEfectos.NegarYReflejarAtaqueDelEnemigo;
import fiuba.algo3.tp2.CartaEfecto;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.CartaTrampa;

public class CilindroMagico extends CartaTrampa {

    public CilindroMagico() {
        super("Cilindro magico");
        efecto = new NegarYReflejarAtaqueDelEnemigo();
    }


}
