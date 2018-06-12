package fiuba.algo3.tp2;

import java.util.ArrayList;

public class Campo {
	
	private ArrayList<CartaMonstruo> monstruos;
	private ArrayList<CartaEfecto> efectos;
	private ArrayList<Carta> mazo;
	private ArrayList<Carta> cementerio;
	private CartaCampo cartaDeCampo;
	
	public void campo() {
		monstruos = new ArrayList<CartaMonstruo>();
		efectos = new ArrayList<CartaEfecto>();
		mazo = new ArrayList<Carta>();
		cementerio = new ArrayList<Carta>();
		cartaDeCampo = new CartaCampo();
	}
	
	
	public void agregarCarta(CartaEfecto unaCarta, String modoCarta) {
		this.efectos.add(unaCarta);		
	}
}
