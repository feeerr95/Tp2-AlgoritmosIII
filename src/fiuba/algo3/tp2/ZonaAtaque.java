package fiuba.algo3.tp2;

import java.util.ArrayList;
import excepciones.InsuficienteEspacioEnCampo;
import excepciones.NoHayMonstruosEnCampo;
import excepciones.NoSeEncuentraLaCarta;

public class ZonaAtaque implements ZonaDeJuego {

    private ArrayList<CartaMonstruo> casilleros;

    public ZonaAtaque(){
        this.casilleros = new ArrayList<>();
    }

    @Override
    public ArrayList<Carta> mandarAlCementerioCartasDestruidas( ArrayList<Carta> cementerio) {

        ArrayList<Carta> cartasEliminadas = new ArrayList<>();
        for(CartaMonstruo carta: casilleros){
        	carta.mandarAlCementerio(cementerio, cartasEliminadas);
        }
        for(Carta carta: cartasEliminadas){
            casilleros.remove(carta);
        }
        return cartasEliminadas;
    }

    public void destruirTodasLasCartas() {

        while(!casilleros.isEmpty()){
            Carta carta = casilleros.get(0);
            carta.destruir();
        }
    }

    public void agregarCarta(CartaMonstruo unaCarta) throws InsuficienteEspacioEnCampo{

        if(casilleros.size() < 5) {
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
            cartaDebil.cambiarBonificaciones(0,0);
            cartaDebil.destruir();
        }
    }

	public void bonificarCartas(int bonAtk, int bonDef) {
		for(CartaMonstruo carta: casilleros) {
			carta.cambiarBonificaciones(bonAtk, bonDef);
		}	
	}

    public void eliminarUnaCarta(Carta carta) throws NoSeEncuentraLaCarta{
        if(!casilleros.contains(carta)){
            throw new NoSeEncuentraLaCarta("No se encuentra la Carta Monstruo");
        }
        int index = casilleros.indexOf(carta);
        casilleros.remove(index).destruir();
    }

    public boolean cartasEstanEnJuego(ArrayList<CartaMonstruo> listaDeCartas){
        for(Carta carta: listaDeCartas ){
            if(!casilleros.contains(carta)) return false;
        }
        return true;
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

    public boolean estaEnElCampo(Carta carta){
        return casilleros.contains(carta);
    }

    public boolean estaEnElCampo(String nombreCarta){
        for(Carta unaCarta: casilleros) {
            if(unaCarta.es(nombreCarta)) {
                return true;
            }
        }
        return false;
    }
}