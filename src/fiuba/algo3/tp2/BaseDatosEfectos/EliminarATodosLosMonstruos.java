package fiuba.algo3.tp2.BaseDatosEfectos;

import fiuba.algo3.tp2.Afectable;
import fiuba.algo3.tp2.Efecto;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tablero;

public class EliminarATodosLosMonstruos extends Efecto {

    private Jugador jugador;

    public EliminarATodosLosMonstruos(Jugador unJugador){
        this.jugador = unJugador;
    }

    @Override
    public void usar(Afectable afectado) {
        afectado.recibirEfecto(this);
    }

    @Override
    public void aplicarSobreTablero(Tablero tablero){
        tablero.eliminarMonstruos();
    }
}
