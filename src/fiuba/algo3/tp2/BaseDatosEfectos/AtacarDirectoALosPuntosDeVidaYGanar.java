package fiuba.algo3.tp2.BaseDatosEfectos;

import fiuba.algo3.tp2.Afectable;
import fiuba.algo3.tp2.BaseDatosCartas.CabezaDeExodia;
import fiuba.algo3.tp2.Efecto;
import fiuba.algo3.tp2.Jugador;

public class AtacarDirectoALosPuntosDeVidaYGanar extends Efecto {

    @Override
    public boolean usar(Afectable afectado) {
        afectado.recibirEfecto(this);
        return false;
    }

    @Override
    public void aplicarSobreJugador(Jugador jugador){
        jugador.ganarJuego();
    }

}
