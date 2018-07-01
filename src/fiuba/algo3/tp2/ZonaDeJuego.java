package fiuba.algo3.tp2;


import java.util.ArrayList;
public interface ZonaDeJuego {

    ArrayList<Carta> mandarAlCementerioCartasDestruidas (ArrayList<Carta> cementerio);
    boolean estaEnElCampo(String nombreCarta);
}
