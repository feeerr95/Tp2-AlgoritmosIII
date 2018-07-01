package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Stack;

import excepciones.InsuficienteEspacioEnCampo;

public class ZonaDefensa implements ZonaDeJuego {

    private ArrayList<CartaEfecto> casilleros;

    public ZonaDefensa(){
        this.casilleros = new ArrayList<>();
    }

    @Override
    public ArrayList<Carta> mandarAlCementerioCartasDestruidas(ArrayList<Carta> cementerio) {

        ArrayList<Carta> cartasEliminadas = new ArrayList<>();
        for(CartaEfecto carta: casilleros){
            carta.mandarAlCementerio(cementerio, cartasEliminadas);
        }
        for(Carta carta: cartasEliminadas){
            casilleros.remove(carta);
        }
        return cartasEliminadas;
    }

    public void agregarCarta(CartaEfecto unaCarta) throws InsuficienteEspacioEnCampo{
        if(casilleros.size() < 5) {
            casilleros.add(unaCarta);
        }
        else{
        	throw new InsuficienteEspacioEnCampo("Se puede colocar hasta 5 cartas magicas o de trampa");
        }
	}

    public boolean cartasTrampaEnJuego(Carta cartaAtacada, Carta cartaAtacante){
        int index = 0;
        while(!casilleros.isEmpty() && index < casilleros.size()){
            if(casilleros.get(index) instanceof CartaTrampa){
                return casilleros.get(index).usarEfectoContra(cartaAtacada,cartaAtacante);
            }
            index = index+1;
        }
        return false;
    }

    public boolean estaEnElCampo(String nombreCarta){
        for(Carta unaCarta: casilleros) {
            if(unaCarta.es(nombreCarta)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaEnElCampo(Carta carta){
        return casilleros.contains(carta);
    }
}
