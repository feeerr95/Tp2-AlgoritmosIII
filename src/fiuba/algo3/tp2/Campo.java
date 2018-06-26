package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Campo {
	
	private ZonaAtaque zonaAtaque;
	private ZonaDefensa  zonaDefensa;
	private Stack<Carta> cementerio;
	private Mazo mazo;
	private List<Carta> mano;
	private CartaTerreno terreno;
	private int bonificacionAtaque,
				bonificacionDefensa;

	
	public Campo() {
		this.zonaDefensa = new ZonaDefensa();
		this.zonaAtaque = new ZonaAtaque();
		this.mazo = new Mazo();
		this.mano = new ArrayList<Carta>();
		this.cementerio = new Stack<>();
		this.terreno = new CartaTerreno("Carta campo neutro");
		this.bonificacionAtaque = 0;
		this.bonificacionDefensa = 0;
	}

	public void agregarCarta(Carta carta, PosicionCarta posicion, CaraCarta cara){
		carta.agregarseAlCampo(this, posicion, cara);
		carta.cambiarBonificaciones(bonificacionAtaque,bonificacionDefensa);
	}

	public void agregarCartaEnZonaDeAtaque(CartaMonstruo carta){
		this.zonaAtaque.agregarCarta(carta);
	}

	public void agregarCartaEnZonaDeDefensa(CartaEfecto carta){
		this.zonaDefensa.agregarCarta(carta);
	}

	public void agregarCartaDeTerreno(CartaTerreno carta){
		this.terreno = carta;
	}

	public int cantidadDeCartasEnElMazo(){
		return mazo.cantidadDeCartasEnElMazo();
	}

	public void eliminarUnaCarta(CartaMonstruo carta){
		this.zonaAtaque.eliminarUnaCarta(carta);
	}

	public int cantidadDeMonstruos(){
		return zonaAtaque.cantidadDeMonstruos();
	}

	public void mandarAlCementerio(Carta carta){
		zonaAtaque.eliminarUnaCarta(carta);
		cementerio.add(carta);
	}

	public void destruirTodasLasCartasMonstruo(){
		this.zonaAtaque.destruirTodasLasCartas();
	}

	public void bonificarCartas(int bonAtk, int bonDef) {
		bonificacionAtaque = bonAtk;
		bonificacionDefensa = bonDef;
		this.zonaAtaque.bonificarCartas(bonAtk, bonDef);
	}

	public Carta agarrarCarta() {
		return mazo.obtenerCartaDeMazo();
	}

	public void eliminarCartaMasDebil() {
		this.zonaAtaque.eliminarCartaMasDebil(cementerio);		
	}

    public boolean cartasEstanEnJuego(ArrayList<CartaMonstruo> listaDeCartas){
        return zonaAtaque.cartasEstanEnJuego( listaDeCartas );
    }

    public void eliminarCartaAlAzar(){
	    zonaAtaque.eliminarCartaAlAzar();
    }

	public boolean estaEnElCampo(String nombreCarta){

		return zonaAtaque.estaEnElCampo(nombreCarta);
	}

	public boolean cartasTrampaEnJuego(Carta cartaAtacada, Carta cartaAtacante){
		return zonaDefensa.cartasTrampaEnJuego(cartaAtacada, cartaAtacante);
	}

}
