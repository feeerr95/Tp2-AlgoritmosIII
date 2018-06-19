package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class Campo {
	
	private ZonaAtaque zonaAtaque;
	private ZonaDefensa  zonaDefensa;
	private Stack<Carta> cementerio;
	private Mazo mazo;
	private Collection<Carta> mano;
	private CartaTerreno terreno;
	private CartaTerreno terrenoEnemigo;

	
	public Campo() {
		this.zonaDefensa = new ZonaDefensa();
		this.zonaAtaque = new ZonaAtaque();
		this.mazo = new Mazo();
		this.mano = new ArrayList<Carta>();
		this.cementerio = new Stack<>();
		this.terreno = new CartaTerreno("Carta campo neutro");
		this.terrenoEnemigo = new CartaTerreno("Carta campo neutro");
	}

	public void agregarCartaMonstruo(CartaMonstruo unaCarta){
		//Se comprueba si hay algún bonificador de poder
		int aumentoAtkDuenio = this.terreno.obtenerAumentoAtkDuenio();
		int aumentoDefDuenio = this.terreno.obtenerAumentoDefDuenio();
		int aumentoAtkEnemigo = this.terrenoEnemigo.obtenerAumentoAtkDuenio();
		int aumentoDefEnemigo = this.terrenoEnemigo.obtenerAumentoDefEnemigo();
		unaCarta.modificarBonificadorAtaque(aumentoAtkDuenio + aumentoAtkEnemigo);
		unaCarta.modificarBonificadorDefensa(aumentoDefDuenio + aumentoDefEnemigo);
		
		this.zonaAtaque.agregarCarta(unaCarta);
	}

	public void agregarCartaEfecto(CartaEfecto unaCarta){
		this.zonaDefensa.agregarCarta(unaCarta);
	}

	public void agregarCartaCampo(CartaTerreno unTerreno){
		this.terreno = unTerreno;
	}
	
	public void agregarCartaCampoEnemigo(CartaTerreno unTerreno) {
		this.terrenoEnemigo = unTerreno;
	}

	public boolean eliminarUnaCarta(){
		return this.zonaAtaque.eliminarUnaCarta();
	}
	
	public boolean eliminarUnaCarta(String sacrificio) {
		return this.zonaAtaque.eliminarUnaCarta(sacrificio);
	}

	public int cantidadDeMonstruos(){
		return zonaAtaque.cantidadDeMonstruos();
	}

	public void eliminarCartasDestruidas(){
		this.zonaAtaque.eliminarCartasDestruidas(cementerio);
	}

	public void destruirTodasLasCartasMonstruo(){
		this.zonaAtaque.destruirTodasLasCartas(cementerio);
	}

	public void bonificarCartas(int atkDuenio, int defDuenio) {
		this.zonaAtaque.bonificarCartas(atkDuenio, defDuenio);		
	}

	public Carta agarrarCarta() {
		return mazo.obtenerCartaDeMazo();
	}

	public void eliminarCartaMasDebil() {
		this.zonaAtaque.eliminarCartaMasDebil(cementerio);		
	}

}
