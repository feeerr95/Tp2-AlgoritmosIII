package fiuba.algo3.tp2;


import java.util.ArrayList;

public class Campo {
	
	private ZonaAtaque zonaAtaque;
	private ZonaDefensa zonaDefensa;
	private Mazo mazo;
	private ZonaCementerio cementerio;
	private ZonaCampo zonaCampo;
	private ArrayList<ZonaDeJuego> zonas;
	
	public Campo() {
		this.zonaAtaque = new ZonaAtaque();
		this.zonaDefensa = new ZonaDefensa();
		this.mazo = new Mazo();
		this.cementerio = new ZonaCementerio();
		this.zonaCampo = new ZonaCampo();
		this.zonas = new ArrayList<>();
		this.zonas.add(zonaAtaque);
		this.zonas.add(zonaDefensa);
	}

	public void agregarCarta(Carta unaCarta, EstadoCarta unEstado) {
		unaCarta.agregarCarta(this, unEstado);
	}

	public void agregarCarta(CartaMonstruo unaCarta) {
		this.zonaAtaque.agregarCarta(unaCarta);
	}
	
	public void agregarCarta(CartaEfecto unaCarta) {
		this.zonaDefensa.agregarCarta(unaCarta);
	}
	
	public void agregarCarta(CartaCampo unaCarta) {
		this.zonaCampo.agregarCarta(unaCarta);
	}

	public boolean cartaEstaEnJuego(Carta unaCarta, String unEstado){
		boolean resultado = false;
		for(ZonaDeJuego zona : zonas){
			resultado = resultado || zona.cartaEstaEnJuego(unaCarta, unEstado); //es una OR
		}
		return resultado;
	}

	public void agregarCartaAlCementerio(Carta unaCarta){
		unaCarta = zonaAtaque.removerCarta(unaCarta);
		this.cementerio.agregarCarta(unaCarta);
	}

	public boolean cartaEnCementerio(Carta carta) {
		boolean resultado = false;
		resultado = cementerio.cartaEnCementerio(carta); 
		return resultado;
	}
	
	public CartaMonstruo obtenerCartaMonstruo(String nombreCarta) {
		return this.zonaAtaque.obtenerCartaMonstruo(nombreCarta);
	}
}
