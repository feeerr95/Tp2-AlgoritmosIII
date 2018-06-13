package fiuba.algo3.tp2;


public class Campo {
	
	private Zona zonaAtaque;
	private Zona zonaDefensa;
	private Mazo mazo;
	private Zona cementerio;
	private Zona zonaCampo;
	
	public void campo() {
		this.zonaAtaque = new ZonaAtaque();
		this.zonaDefensa = new ZonaDefensa();
		this.mazo = new Mazo();
		this.cementerio = new ZonaCementerio();
		this.zonaCampo = new ZonaCampo();
	}

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


	public boolean cartaEnJuego(Carta unaCarta, EstadoCarta unEstado) {
		// TODO Auto-generated method stub
		return false;
	}

	public void agregarCartaAlCementerio(Carta unaCarta){
		unaCarta = zonaAtaque.removerCarta(unaCarta);
		this.cementerio.agregarCarta(unaCarta);
	}
}
