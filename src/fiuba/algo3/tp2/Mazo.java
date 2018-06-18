package fiuba.algo3.tp2;

import java.util.Stack;
import java.util.Vector;

import fiuba.algo3.tp2.BaseDatosCartas.*;

public class Mazo {

	private Vector<Carta> mazo;
	
	public Mazo() {
		this.mazo = new  Vector<>(); 
		CartaMonstruo carta1 = new AbismoReluciente(); 
		CartaMonstruo carta2 = new AcechadorDelCraneo(); 
		CartaMagica carta3 = new AgujeroNegro(); 
		CartaMonstruo carta4 = new BrazoDerechoDeExodia(); 
		CartaMonstruo carta5 = new BrazoIzquierdoDeExodia(); 
		CartaMonstruo carta6 = new CabezaDeExodia(); 
		CartaMonstruo carta7 = new ChicaMagaOscura(); 
		CartaMonstruo carta8 = new DragonBlancoDeOjosAzules(); 
		CartaMonstruo carta9 = new EscudoMilenario();
		CartaMagica carta10 = new Fisura();
		CartaMonstruo carta11 = new HuevoMonstruoso(); 
		CartaMonstruo carta12 = new InsectoComeHombres(); 
		CartaMonstruo carta13 = new Jinzo7();
		CartaMagica carta14 = new OllaDeLaCodicia();
		CartaMonstruo carta15 = new PiernaDerechaDeExodia(); 
		CartaMonstruo carta16 = new PiernaIzquierdaDeExodia(); 
		CartaMagica carta17 = new Sogen(); 
		CartaMagica carta18 = new Wasteland(); 
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
	}
	
	public Carta obtenerCartaDeMazo() { 
		int numero = (int) (Math.random() * mazo.size());

		return mazo.get(numero);
	}
}
