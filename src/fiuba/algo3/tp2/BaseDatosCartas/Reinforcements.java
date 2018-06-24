package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaTrampa;
import fiuba.algo3.tp2.BaseDatosEfectos.AumentaAtaqueDelMonstruoAtacadoHastaElFinalDelTurno;

public class Reinforcements extends CartaTrampa {

    public Reinforcements(){
        super("Reinforcements");
        efecto = new AumentaAtaqueDelMonstruoAtacadoHastaElFinalDelTurno(500, 0);
    }
}
