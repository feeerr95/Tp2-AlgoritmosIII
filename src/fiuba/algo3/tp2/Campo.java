package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Campo {
	
	private ZonaAtaque zonaAtaque;
	private ZonaDefensa  zonaDefensa;
	private ArrayList<Carta> cementerio;
	private Mazo mazo;
	private List<Carta> mano;
	private CartaTerreno terreno;
	private int bonificacionAtaque,
				bonificacionDefensa;
	private Tablero tablero;

	
	public Campo() {
		this.zonaDefensa = new ZonaDefensa();
		this.zonaAtaque = new ZonaAtaque();
		this.mazo = new Mazo();
		this.mano = new ArrayList<Carta>();
		this.cementerio = new ArrayList<Carta>();
		this.terreno = new CartaTerreno("Carta campo neutro");
		this.bonificacionAtaque = 0;
		this.bonificacionDefensa = 0;
	}

	public void setTablero(Tablero tablero){
		this.tablero = tablero;
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
		carta.usarEfectoContra(tablero);
	}

	public int cantidadDeCartasEnElMazo(){
		return mazo.cantidadDeCartasEnElMazo();
	}

	public void destruirCarta(String carta){
		this.zonaAtaque.destruirCarta(carta);
	}

	public int cantidadDeMonstruos(){
		return zonaAtaque.cantidadDeMonstruos();
	}

	public ArrayList<Carta> mandarAlCementerioCartasDestruidas(){

		ArrayList<Carta> cartasAtaque = zonaAtaque.mandarAlCementerioCartasDestruidas(cementerio);
		ArrayList<Carta> cartaDefensa = zonaDefensa.mandarAlCementerioCartasDestruidas(cementerio);
		cartasAtaque.addAll(cartaDefensa);
		return cartasAtaque;
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
		this.zonaAtaque.eliminarCartaMasDebil();
	}

    public void eliminarCartaAlAzar(){
	    zonaAtaque.eliminarCartaAlAzar();
    }

	public boolean estaEnElCampo(String nombreCarta){
		return zonaAtaque.estaEnElCampo(nombreCarta);
	}

	public boolean estaEnElCampo(Carta carta){
		return zonaAtaque.estaEnElCampo(carta);
	}

	public boolean cartasTrampaEnJuego(Carta cartaAtacada, Carta cartaAtacante){
		return zonaDefensa.cartasTrampaEnJuego(cartaAtacada, cartaAtacante);
	}

}
