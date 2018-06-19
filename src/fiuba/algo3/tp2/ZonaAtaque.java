package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Stack;

public class ZonaAtaque implements ZonaDeJuego {

    private ArrayList<CartaMonstruo> casilleros;

    public ZonaAtaque(){
        this.casilleros = new ArrayList<>();
    }
    @Override

    public void eliminarCartasDestruidas(  Stack cementerio) {
        for(CartaMonstruo carta: casilleros){
            carta.cambiarBonificaciones(0, 0);
        	carta.mandarAlCementerio(cementerio);
        }
    }

    public void destruirTodasLasCartas(Stack cementerio) {
        for(CartaMonstruo carta: casilleros){
            carta.destruir();
        }
        this.eliminarCartasDestruidas(cementerio);
    }

    public void agregarCarta(CartaMonstruo unaCarta) {
        if(casilleros.size() < 5) {
            casilleros.add(unaCarta);
        }
        else{
            //EXCEPCION NO SE PUEDE PONER MAS
        }
    }

    //Hay que hacer que se mande por parametro la carta y la elimine (esto es para que pase la prueba) creo que hay que hacer eso
    public boolean eliminarUnaCarta(){
        if(casilleros.isEmpty()) return false;
        Carta cartaEliminada = casilleros.remove( casilleros.size() - 1 );
        cartaEliminada.destruir();
        return true;
    }

    public int cantidadDeMonstruos(){
        return casilleros.size();
	}









	//REVISAR ESTO.

	public void bonificarCartas(int atkDuenio, int defDuenio) {
		for(CartaMonstruo carta: casilleros) {
			carta.cambiarBonificaciones(atkDuenio, defDuenio);
		}	
	}
	
	public void eliminarCartaMasDebil(Stack cementerio) {
		CartaMonstruo cartaDebil = new CartaMonstruo("BorrarDebil", 10000, 0, new NivelBasico());
		
		for(CartaMonstruo cartaActual: casilleros) { //ESTO ESTA MAL. ROMPE EL ENCAPSULAMIENTO, HAY QUE PREGUNTARLE A LA CARTA SI ES MAS DEBIL QUE OTRA CARTA
			if(!cartaActual.bocaAbajo && cartaActual.atk < cartaDebil.atk) {
				cartaDebil = cartaActual;
			}
		}
		cartaDebil.cambiarBonificaciones(0, 0);
		cartaDebil.destruir();
		cartaDebil.mandarAlCementerio(cementerio);
	}

    public boolean eliminarUnaCarta(String nombreSacrificio) { //ESTO ESTA MAL.
        if(casilleros.isEmpty()) return false;

        for(CartaMonstruo cartaActual: casilleros) {
            if(cartaActual.obtenerNombre() == nombreSacrificio) {
                casilleros.remove( casilleros.size() - 1 );
                cartaActual.destruir();
                return true;
            }

        }
        return false;
    }

}
