package fiuba.algo3.tp2;

public class NivelBasico extends Nivel {

    @Override
    public void agregarseAlCampo(Campo campo, CartaMonstruo carta) {
        campo.agregarCartaEnZonaDeAtaque(carta);
    }
}
