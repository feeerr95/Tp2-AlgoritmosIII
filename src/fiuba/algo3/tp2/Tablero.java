package fiuba.algo3.tp2;

public class Tablero implements Afectable {

    private Campo campo1;
    private Campo campo2;

    public Tablero(Campo unCampo, Campo otroCampo){
        campo1 = unCampo;
        campo2 = otroCampo;
    }
    public void recibirEfecto(Efecto efecto){
        efecto.aplicarSobreTablero(this);
    }

    public void eliminarMonstruos(){
        campo1.destruirTodasLasCartasMonstruo();
        campo2.destruirTodasLasCartasMonstruo();
    }

    public void bonificarPuntos(int bonDefAtacante, int bonAtkAtacante, int bonDefAtacado, int bonAtkAtacado){
        campo1.bonificarCartas(bonAtkAtacante,bonDefAtacante);
        campo2.bonificarCartas(bonAtkAtacado,bonDefAtacado);
    }

    public void eliminarCartasDestruidasJ1(){
        campo1.mandarAlCementerioCartasDestruidas();
    }

    public void eliminarCartasDestruidasJ2(){
        campo2.mandarAlCementerioCartasDestruidas();
    }
}
