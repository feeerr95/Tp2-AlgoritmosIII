package fiuba.algo3.tp2;

import java.util.ArrayList;

public class Campo {
	
	private ArrayList<CartaMonstruo> monstruos;
	private ArrayList<CartaEfecto> efectos;
	private ArrayList<Carta> mazo;
	private ArrayList<Carta> cementerio;
	private CartaCampo cartaDeCampo;
	
	public void campo() {
		monstruos = new ArrayList<>();
		efectos = new ArrayList<>();
		mazo = new ArrayList<>();
		cementerio = new ArrayList<>();
		cartaDeCampo = new CartaCampo();
	}
	
	
	public void agregarCarta(CartaMonstruo unaCarta, EstadoCarta unEstado) {
		unaCarta.cambiarEstado(unEstado);
		this.monstruos.add(unaCarta);
	}
	
	public void agregarCarta(CartaEfecto unaCarta, EstadoCarta unEstado) {
		unaCarta.cambiarEstado(unEstado);
		this.efectos.add(unaCarta);		
	}
	
	public void agregarCarta(CartaCampo unaCarta, EstadoCarta unEstado) {
		unaCarta.cambiarEstado(unEstado);
		this.cartaDeCampo = unaCarta;	
	}


	public boolean cartaEnJuego(Carta unaCarta, EstadoCarta unEstado) {
		// TODO Auto-generated method stub
		return false;
	}

	public void agregarCartaAlCementerio(Carta unaCarta){
		//Hasta ahora solo estamos destruyendo monstruos pero habria que adaptarlo.
		monstruos.remove(monstruos.indexOf(unaCarta));
		this.cementerio.add(unaCarta);
	}
}
