package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Stack;

public class ZonaAtaque implements ZonaDeJuego {

    private ArrayList<CartaMonstruo> casilleros;

    public ZonaAtaque(){
        this.casilleros = new ArrayList<>();
    }
    @Override

    public void eliminarCartasDestruidas( Stack cementerio) {
        for(CartaMonstruo carta: casilleros){
            carta.cambiarBonificaciones(0, 0);
        	carta.mandarAlCementerio(cementerio);
        }
    }

    public void destruirTodasLasCartas() {

        while(!casilleros.isEmpty()){
            Carta carta = casilleros.remove(0);
            carta.destruir();
        }
    }

    public void agregarCarta(CartaMonstruo unaCarta) {

        if(casilleros.size() < 5) {
            casilleros.add(unaCarta);
        }
        else{
            //EXCEPCION NO SE PUEDE PONER MAS
        }
    }

    public int cantidadDeMonstruos(){
        return casilleros.size();
	}

    public void eliminarCartaMasDebil(Stack cementerio) {

        if(!casilleros.isEmpty()){
            CartaMonstruo cartaDebil = new CartaMonstruo("Carta de referencia", 9999999, 0, new NivelBasico());
            for(CartaMonstruo carta: casilleros){
                if(!carta.estaBocaAbajo() && carta.esMasDebilQue(cartaDebil)) {
                    cartaDebil = carta;
                }
            }
            cartaDebil.cambiarBonificaciones(0,0);
            cartaDebil.destruir();
        }
    }

	public void bonificarCartas(int bonAtk, int bonDef) {
		for(CartaMonstruo carta: casilleros) {
			carta.cambiarBonificaciones(bonAtk, bonDef);
		}	
	}

    public void eliminarUnaCarta(Carta cartaMonstruo){
        if(!casilleros.contains(cartaMonstruo)){
            //excepcion de que no esta la carta
        }
        casilleros.remove(cartaMonstruo);
    }

    public boolean cartasEstanEnJuego(ArrayList<CartaMonstruo> listaDeCartas){
        for(Carta carta: listaDeCartas ){
            if(!casilleros.contains(carta)) return false;
        }
        return true;
    }

    public void eliminarCartaAlAzar(){
        CartaMonstruo cartaEliminada = casilleros.remove(0);
        cartaEliminada.destruir();
    }

}