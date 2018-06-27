package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.BaseDatosEfectos.AtacarDirectoALosPuntosDeVidaYGanar;
import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.Nivel;

public abstract class ParteDeExodia extends CartaMonstruo {

    public ParteDeExodia(String unNombre, int unAtaque, int unaDefensa, Nivel nivelDeLaCarta) {
        super(unNombre, unAtaque, unaDefensa, nivelDeLaCarta);
        efecto = new AtacarDirectoALosPuntosDeVidaYGanar();
    }

    public void usarEfectoAlSacarCarta(){
        if(
                duenio.tieneLaCarta("Cabeza De Exodia") &&
                duenio.tieneLaCarta("Brazo Derecho De Exodia") &&
                duenio.tieneLaCarta("Brazo Izquierdo De Exodia") &&
                duenio.tieneLaCarta("Pierna Izquierda De Exodia") &&
                duenio.tieneLaCarta("Pierna Derecha De Exodia"))
        {
            efecto.usar(duenio);
        }
    }
}
