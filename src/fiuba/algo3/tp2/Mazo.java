package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.BaseDatosCartas.*;

public class Mazo {

	private ArrayList<Carta> mazo;
	
	public Mazo() {
		this.mazo = new ArrayList<>();
		CartaMonstruo carta1 = new AbismoReluciente();
		CartaMonstruo carta2 = new AcechadorDelCraneo();
		CartaMagica carta3 = new AgujeroNegro();
		CartaMonstruo carta4 = new BrazoDerechoDeExodia();
		CartaMonstruo carta5 = new BrazoIzquierdoDeExodia();
		CartaMonstruo carta6 = new CabezaDeExodia();
		CartaMonstruo carta7 = new ChicaMagaOscura();
		CartaTrampa carta8 = new CilindroMagico();
		CartaMonstruo carta9 = new DragonBlancoDeOjosAzules();
		CartaMonstruo carta10 = new DragonDefinitivoDeOjosAzules();
		CartaMonstruo carta11 = new EscudoMilenario();
		CartaMagica carta12 = new Fisura();
		CartaMonstruo carta13 = new HuevoMonstruoso();
		CartaMonstruo carta14 = new InsectoComeHombres();
		CartaMonstruo carta15 = new Jinzo7();
		CartaMagica carta16 = new OllaDeLaCodicia();
		CartaMonstruo carta17 = new PiernaDerechaDeExodia();
		CartaMonstruo carta18 = new PiernaIzquierdaDeExodia();
		CartaTrampa carta19 = new Reinforcements();
		CartaTerreno carta20 = new Sogen();
		CartaTerreno carta21 = new Wasteland();
		mazo.add(carta1);
		mazo.add(carta2);
		mazo.add(carta3);
		mazo.add(carta4);
		mazo.add(carta5);
		mazo.add(carta6);
		mazo.add(carta7);
		mazo.add(carta8);
		mazo.add(carta9);
		mazo.add(carta10);
		mazo.add(carta11);
		mazo.add(carta12);
		mazo.add(carta13);
		mazo.add(carta14);
		mazo.add(carta15);
		mazo.add(carta16);
		mazo.add(carta17);
		mazo.add(carta18);
		mazo.add(carta19);
		mazo.add(carta20);
		mazo.add(carta21);
	}

	public int cantidadDeCartasEnElMazo(){
		return mazo.size();
	}

	public Carta obtenerCartaDeMazo() { 
		int numero = (int) (Math.random() * mazo.size());
		return mazo.remove(numero);
	}
}
