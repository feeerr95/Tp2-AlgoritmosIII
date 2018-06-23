package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Stack;

public class ZonaDefensa implements ZonaDeJuego {

    private ArrayList<CartaEfecto> casilleros;

    public ZonaDefensa(){
        this.casilleros = new ArrayList<>();
    }

    @Override
    public void eliminarCartasDestruidas(Stack cementerio) {
        for(CartaEfecto carta: casilleros){
            carta.mandarAlCementerio(cementerio);
        }
    }

    public void agregarCarta(CartaEfecto unaCarta) {
        if(casilleros.size() < 5) {
            casilleros.add(unaCarta);
        }
        else{
            //EXCEPCION NO SE PUEDE PONER MAS
        }
	}

    public boolean cartasTrampaEnJuego(Afectable afectable){
        if(!casilleros.isEmpty()){
            return casilleros.get(0).usarEfectoContra(afectable);
        }
        return false;
    }
}
