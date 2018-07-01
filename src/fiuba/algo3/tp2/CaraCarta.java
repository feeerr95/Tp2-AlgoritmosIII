package fiuba.algo3.tp2;

public abstract class CaraCarta {

    private String cara;

    public CaraCarta(String cara){
        this.cara = cara;
    }

    public abstract boolean estaBocaAbajo();

    public String getCara() {
        return cara;
    }
}
