package fiuba.algo3.tp2;

public class BocaAbajo extends CaraCarta {

    @Override
    public boolean estaBocaAbajo() {
        return true;
    }

    @Override
    public void darseVuelta(CaraCarta cara) {
        cara = new BocaArriba();
    }
}
