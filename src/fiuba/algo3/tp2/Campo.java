package fiuba.algo3.tp2;

import java.util.ArrayList;

public class Campo {
	
	private ArrayList<CartaMonstruo> monstruos;
	private ArrayList<CartaEfecto> efectos;
	private ArrayList<Carta> mazo;
	private ArrayList<Carta> cementerio;
	private CartaCampo cartaDeCampo;
	
	public void campo() {
<<<<<<< HEAD
		monstruos = new ArrayList<>();
		efectos = new ArrayList<>();
		mazo = new ArrayList<>();
		cementerio = new ArrayList<>();
=======
		monstruos = new ArrayList<CartaMonstruo>();
		efectos = new ArrayList<CartaEfecto>();
		mazo = new ArrayList<Carta>();
		cementerio = new ArrayList<Carta>();
>>>>>>> b3e3e47d996d27934cba74131d5b2853a8f0796a
		cartaDeCampo = new CartaCampo();
	}
	
	
	public void agregarCarta(CartaMonstruo unaCarta, EstadoCarta unEstado) {
		unaCarta.cambiarEstado(unEstado);
<<<<<<< HEAD
		this.monstruos.add(unaCarta);
=======
		this.monstruos.add(unaCarta);		
>>>>>>> b3e3e47d996d27934cba74131d5b2853a8f0796a
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
<<<<<<< HEAD

	public void agregarCartaAlCementerio(Carta unaCarta){
		//Hasta ahora solo estamos destruyendo monstruos pero habria que adaptarlo.
		monstruos.remove(monstruos.indexOf(unaCarta));
		this.cementerio.add(unaCarta);
	}
=======
>>>>>>> b3e3e47d996d27934cba74131d5b2853a8f0796a
}
