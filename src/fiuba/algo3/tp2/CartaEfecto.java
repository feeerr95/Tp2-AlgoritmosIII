package fiuba.algo3.tp2;

public abstract class CartaEfecto extends Carta {


    @Override
    public void agregarseAlCampo(Campo campo){
        campo.agregarCartaEnZonaDeDefensa(this);
    }

    @Override
    public void usarEfectoContra(Afectable afectado){
        efecto.usar(afectado);
        this.destruir();
    }

}