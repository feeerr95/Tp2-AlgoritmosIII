package fiuba.algo3.tp2;

public class Mazo {

    private BaseDatosCartas baseDatosCartas;

    public Mazo(){
        this.baseDatosCartas = new BaseDatosCartas();
    }
    //esto es para los tests, en realidad solo tiene que sacar de arriba el mazo


    public Carta agarrarCarta(String nombreDeLaCarta){
        Carta carta = this.baseDatosCartas.buscarCarta(nombreDeLaCarta);

        return carta;
    }
}
