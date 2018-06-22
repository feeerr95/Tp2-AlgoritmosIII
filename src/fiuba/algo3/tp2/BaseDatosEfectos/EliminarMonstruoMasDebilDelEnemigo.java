package fiuba.algo3.tp2.BaseDatosEfectos;

import fiuba.algo3.tp2.Afectable;
import fiuba.algo3.tp2.Efecto;
import fiuba.algo3.tp2.Jugador;

public class EliminarMonstruoMasDebilDelEnemigo extends Efecto {

    @Override
    public void usar(Afectable afectado) {
        afectado.recibirEfecto(this);
    }

    @Override
    public void aplicarSobreJugador(Jugador jugador){
        jugador.eliminarCartaMasDebil();
    }
}
