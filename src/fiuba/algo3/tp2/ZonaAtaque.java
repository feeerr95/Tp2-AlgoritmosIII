package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.InsuficienteEspacioEnCampo;
import excepciones.NoHayMonstruosEnCampo;
import excepciones.NoSeEncuentraLaCarta;

public class ZonaAtaque implements ZonaDeJuego {

    private ArrayList<CartaMonstruo> casilleros;
    private HashMap<String, ArrayList<CartaMonstruo>> cartasEnJuego;

    public ZonaAtaque(){
        this.casilleros = new ArrayList<>();
        this.cartasEnJuego = new HashMap<>();
    }

    @Override
    public ArrayList<Carta> mandarAlCementerioCartasDestruidas( ArrayList<Carta> cementerio) {

        ArrayList<Carta> cartasEliminadas = new ArrayList<>();
        for(CartaMonstruo carta: casilleros){
        	carta.mandarAlCementerio(cementerio, cartasEliminadas);
        }
        for(Carta carta: cartasEliminadas){
            this.eliminarUnaCarta(carta.getNombreCarta());
        }
        return cartasEliminadas;
    }

    public void destruirTodasLasCartas() {

        for(Carta carta: casilleros){
            carta.destruir();
        }
    }

    public void agregarCarta(CartaMonstruo unaCarta) throws InsuficienteEspacioEnCampo{

        if(casilleros.size() < 5) {
            if(!cartasEnJuego.containsKey(unaCarta.getNombreCarta())){
                cartasEnJuego.put(unaCarta.getNombreCarta(), new ArrayList<>());
            }
            cartasEnJuego.get(unaCarta.getNombreCarta()).add(unaCarta);
            casilleros.add(unaCarta);
        }
        else{
            throw new InsuficienteEspacioEnCampo("Se puede invocar hasta 5 monstruos");
        }
    }

    public int cantidadDeMonstruos(){
        return casilleros.size();
	}

    public void eliminarCartaMasDebil() {

        if(!casilleros.isEmpty()){
            CartaMonstruo cartaDebil = new CartaMonstruo("Carta de referencia", 9999999, 0, new NivelBasico());
            for(CartaMonstruo carta: casilleros){
                if(!carta.estaBocaAbajo() && carta.esMasDebilQue(cartaDebil)) {
                    cartaDebil = carta;
                }
            }
            cartaDebil.destruir();
        }
    }

	public void bonificarCartas(int bonAtk, int bonDef) {
		for(CartaMonstruo carta: casilleros) {
			carta.cambiarBonificaciones(bonAtk, bonDef);
		}	
	}

	public void destruirCarta(String nombreCarta){
        for(Carta carta: cartasEnJuego.get(nombreCarta)){
            if(!carta.estaDestruida()){
                carta.destruir();
                break;
            }
        }
    }

    public void eliminarUnaCarta(String nombreCarta) throws NoSeEncuentraLaCarta{
        if(!cartasEnJuego.containsKey(nombreCarta)){
            throw new NoSeEncuentraLaCarta("No se encuentra la Carta Monstruo");
        }

        CartaMonstruo cartaEliminada = cartasEnJuego.get(nombreCarta).remove(0);
        if(cartasEnJuego.get(nombreCarta).isEmpty()){
            cartasEnJuego.remove(nombreCarta);
        }
        int index = casilleros.indexOf(cartaEliminada);
        cartaEliminada.destruir();
        casilleros.remove(index);
    }

    public void eliminarCartaAlAzar() throws NoHayMonstruosEnCampo{
        if(casilleros.isEmpty()){
            throw new NoHayMonstruosEnCampo("No hay monstruos en el campo");
        }
        else {
            int index = 0;
            CartaMonstruo cartaEliminada = casilleros.get(index);
            while(cartaEliminada.estaDestruida()){
                index += 1;
                cartaEliminada = casilleros.get(index);
            }
            cartaEliminada.destruir();
        }
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