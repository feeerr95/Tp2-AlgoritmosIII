package fiuba.algo3.tp2;

public class BocaArriba extends CaraCarta {

    public BocaArriba() {
        super("Arriba");
    }

    @Override
    public boolean estaBocaAbajo() {
        return false;
    }

    @Override
    public void darseVuelta(CaraCarta cara) {
        cara = new BocaAbajo();
    }
}
