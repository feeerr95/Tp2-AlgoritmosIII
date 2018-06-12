package fiuba.algo3.tp2;

public class Campo {
	
	private CartaMonstruo monstruosCampo[];
	private CartaEfecto efectosCampo[];
	private Carta mazo[];
	private Carta cementerio[];
	private CartaCampo efectoDeCampo;
	
	public void campo() {
		monstruosCampo = new CartaMonstruo[4];
		efectosCampo = new CartaEfecto[4];
		mazo = new Carta[49];
		cementerio = new Carta[49];
		efectoDeCampo = new CartaCampo();
	}
}
