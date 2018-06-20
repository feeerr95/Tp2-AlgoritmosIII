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

		//VER SI SE PUEDE CAMBIAR ESTO. DE NO PODERSE, HACER UNA FUNCION PRIVADA QUE HAGA ESTO.
		//Se comprueba si hay algun bonificador de poder


		int aumentoAtkDuenio = this.terreno.obtenerAumentoAtkDuenio();
		int aumentoDefDuenio = this.terreno.obtenerAumentoDefDuenio();
		int aumentoAtkEnemigo = this.terrenoEnemigo.obtenerAumentoAtkDuenio();
		int aumentoDefEnemigo = this.terrenoEnemigo.obtenerAumentoDefEnemigo();
		unaCarta.modificarBonificadorAtaque(aumentoAtkDuenio + aumentoAtkEnemigo);
		unaCarta.modificarBonificadorDefensa(aumentoDefDuenio + aumentoDefEnemigo);
		
		this.zonaAtaque.agregarCarta(unaCarta);
	}

	public int cantidadDeCartasEnElMazo(){
		return mazo.cantidadDeCartasEnElMazo();
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

	public void bonificarCartas(int atkDuenio, int defDuenio) {
		this.zonaAtaque.bonificarCartas(atkDuenio, defDuenio);		
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

}
