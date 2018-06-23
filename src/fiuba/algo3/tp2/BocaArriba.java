package fiuba.algo3.tp2;

public class BocaArriba extends CaraCarta {

    @Override
    public boolean estaBocaAbajo() {
        return false;
    }

    @Override
    public void darseVuelta(CaraCarta cara) {
        cara = new BocaAbajo();
    }
}
