package fiuba.algo3.tp2;

import java.util.ArrayList;

import fiuba.algo3.tp2.BaseDatosCartas.*;

public class Mazo {

	private ArrayList<Carta> mazo;
	
	public Mazo() {
		this.mazo = new ArrayList<>();
		CartaMonstruo carta1 = new AbismoReluciente();
		CartaMonstruo carta2 = new AcechadorDelCraneo();
		CartaMonstruo carta3 = new AgujaAsesina();
		CartaMagica carta4 = new AgujeroNegro();
		CartaMonstruo carta5 = new AveDeCraneoRojo();
		CartaMonstruo carta6 = new BrazoDerechoDeExodia();
		CartaMonstruo carta7 = new BrazoIzquierdoDeExodia();
		CartaMonstruo carta8 = new BueyDeBatalla();
		CartaMonstruo carta9 = new CaballeroGemaLapis();
		CartaMonstruo carta10 = new CaballeroSinCabeza();
		CartaMonstruo carta11 = new CabezaDeExodia();
		CartaMonstruo carta12 = new ChicaMagaOscura();
		CartaTrampa carta13 = new CilindroMagico();
		CartaMonstruo carta14 = new DamaArpia();
		CartaMonstruo carta15 = new DragonBlancoDeOjosAzules();
		CartaMonstruo carta16 = new DragonDefinitivoDeOjosAzules();
		CartaMonstruo carta17 = new DragonDeFuegoDeLaTierraNegra();
		CartaMonstruo carta18 = new EscudoMilenario();
		CartaMonstruo carta19 = new EspadachinDeLandstar();
		CartaMonstruo carta20 = new FantasmaMagico();
		CartaMagica carta21 = new Fisura();
		CartaMonstruo carta22 = new GaiaElCaballeroFeroz();
		CartaMonstruo carta23 = new GelatinaHumanoide();
		CartaMonstruo carta24 = new GuardianCelta();
		CartaMonstruo carta25 = new GuerreroCastor();
		CartaMonstruo carta26 = new GyakutennoMegami();
		CartaMonstruo carta27 = new HachaDelTigre();
		CartaMonstruo carta28 = new HuevoMonstruoso();
		CartaMonstruo carta29 = new InsectoComeHombres();
		CartaMonstruo carta30 = new Jinzo7();
		CartaMonstruo carta31 = new Juez();
		CartaMonstruo carta32 = new KaiserRudo();
		CartaMonstruo carta33 = new Mikazukinoyaiba();
		CartaMagica carta34 = new OllaDeLaCodicia();
		CartaMonstruo carta35 = new PezDe7Colores();
		CartaMonstruo carta36 = new PezDeMetal();
		CartaMonstruo carta37 = new PiernaDerechaDeExodia();
		CartaMonstruo carta38 = new PiernaIzquierdaDeExodia();
		CartaTrampa carta39 = new Reinforcements();
		CartaMonstruo carta40 = new Sablesaurio();
		CartaMonstruo carta41 = new SaggiElPayasoOscuro();
		CartaMonstruo carta42 = new DragonBlancoDeOjosAzules();
		CartaMonstruo carta43 = new Seiyaryu();
		CartaMonstruo carta44 = new DragonBlancoDeOjosAzules();
		CartaMonstruo carta45 = new SerpienteMarinaRojaGigante();
		CartaTerreno carta46 = new Sogen();
		CartaTerreno carta47 = new Wasteland();
		CartaMonstruo carta48 = new Yamadron();
		CartaMonstruo carta49 = new Zoa();
		CartaMonstruo carta50 = new ZombiDragon();
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
		mazo.add(carta22);
		mazo.add(carta23);
		mazo.add(carta24);
		mazo.add(carta25);
		mazo.add(carta26);
		mazo.add(carta27);
		mazo.add(carta28);
		mazo.add(carta29);
		mazo.add(carta30);
		mazo.add(carta31);
		mazo.add(carta32);
		mazo.add(carta33);
		mazo.add(carta34);
		mazo.add(carta35);
		mazo.add(carta36);
		mazo.add(carta37);
		mazo.add(carta38);
		mazo.add(carta39);
		mazo.add(carta40);
		mazo.add(carta41);
		mazo.add(carta42);
		mazo.add(carta43);
		mazo.add(carta44);
		mazo.add(carta45);
		mazo.add(carta46);
		mazo.add(carta47);
		mazo.add(carta48);
		mazo.add(carta49);
		mazo.add(carta50);
	}

	public int cantidadDeCartasEnElMazo(){
		return mazo.size();
	}

	public Carta obtenerCartaDeMazo() { 
		int numero = (int) (Math.random() * mazo.size());
		return mazo.remove(numero);
	}
}
