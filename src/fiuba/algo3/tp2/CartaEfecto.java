package fiuba.algo3.tp2;

public abstract class CartaEfecto extends Carta {


    @Override
    public void agregarseAlCampo(Campo campo){
        campo.agregarCartaEnZonaDeDefensa(this);
    }

    @Override
    public boolean usarEfectoContra(Afectable afectado){
        this.destruir();
        return efecto.usar(afectado);

    }

}