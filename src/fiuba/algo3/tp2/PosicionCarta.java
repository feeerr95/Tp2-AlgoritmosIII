package fiuba.algo3.tp2;

public abstract class PosicionCarta {

    private String posicion;

    public PosicionCarta(String posicion){
        this.posicion = posicion;
    }
    public abstract void recibirAtaque(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, PosicionCarta otraPosicion, int atkAtacante,
                        int atkAtacado, int defAtacado);

    public String getPosicion() {
        return posicion;
    }
}