package fiuba.algo3.tp2;


public class Campo {
	
	private ZonaAtaque zonaAtaque;
	private ZonaDefensa zonaDefensa;
	private Mazo mazo;
	private ZonaCementerio cementerio;
	private ZonaCampo zonaCampo;
	
	public Campo() {
		this.zonaAtaque = new ZonaAtaque();
		this.zonaDefensa = new ZonaDefensa();
		this.mazo = new Mazo();
		this.cementerio = new ZonaCementerio();
		this.zonaCampo = new ZonaCampo();
	}
	
	public void agregarAZonaAtaque(CartaMonstruo unaCarta){
		this.zonaAtaque.agregarCarta(unaCarta);
	}
	
	public void agregarAZonaDefensa(CartaEfecto unaCarta){
		this.zonaDefensa.agregarCarta(unaCarta);
	}
	
	public void agregarACementerio(Carta unaCarta){
		this.cementerio.agregarCarta(unaCarta);
	}
	
	public void agregarAZonaCampo(CartaCampo unaCarta){
		this.zonaCampo.agregarCarta(unaCarta);
	}
	
	
	public void agregarCarta(Carta unaCarta, EstadoCarta unEstado) {
		unaCarta.agregarCarta(this, unEstado);
	}
	
/*
	public void agregarCarta(CartaMonstruo unaCarta, EstadoCarta unEstado) {
		unaCarta.cambiarEstado(unEstado);
		this.zonaAtaque.agregarCarta(unaCarta);
	}
	
	public void agregarCarta(CartaEfecto unaCarta, EstadoCarta unEstado) {
		unaCarta.cambiarEstado(unEstado);
		this.zonaDefensa.agregarCarta(unaCarta);
	}
	
	public void agregarCarta(CartaCampo unaCarta, EstadoCarta unEstado) {
		unaCarta.cambiarEstado(unEstado);
		this.zonaCampo.agregarCarta(unaCarta);
	}
*/

	public boolean cartaEnJuego(Carta unaCarta, EstadoCarta unEstado) {
		return true;
	}

	public void agregarCartaAlCementerio(Carta unaCarta){
		unaCarta = zonaAtaque.removerCarta(unaCarta);
		this.cementerio.agregarCarta(unaCarta);
	}
}
