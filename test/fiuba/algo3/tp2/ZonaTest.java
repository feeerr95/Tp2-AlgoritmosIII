package fiuba.algo3.tp2;

import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class ZonaTest {

	@Test
	public void agregarMonstruos() {

		ZonaAtaque zonaAtaque = new ZonaAtaque();

		CartaMonstruo insectoComeHombres = new InsectoComeHombres();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();

		zonaAtaque.agregarCarta(insectoComeHombres);
		zonaAtaque.agregarCarta(huevoMonstruoso);

		assertEquals(true, zonaAtaque.estaEnElCampo(insectoComeHombres));
		assertEquals(true, zonaAtaque.estaEnElCampo(huevoMonstruoso));
		assertEquals(2, zonaAtaque.cantidadDeMonstruos());
	}

	@Test
	public void agregarCartasEfecto(){

		ZonaDefensa zonaDefensa = new ZonaDefensa();

		CartaEfecto fisura = new Fisura();
		CartaEfecto reinforcements = new Reinforcements();

		zonaDefensa.agregarCarta(fisura);
		zonaDefensa.agregarCarta(reinforcements);

		assertEquals(true, zonaDefensa.estaEnElCampo(fisura));
		assertEquals(true, zonaDefensa.estaEnElCampo(reinforcements));

	}

	@Test
	public void eliminarCartasDestruidas(){
		ZonaAtaque zona = new ZonaAtaque();
		ArrayList<Carta> cementerio = new ArrayList<>();

		CartaMonstruo insectoComeHombres = new InsectoComeHombres();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		CartaMonstruo abismoReluciente = new AbismoReluciente();

		zona.agregarCarta(insectoComeHombres);
		zona.agregarCarta(huevoMonstruoso);
		zona.agregarCarta(abismoReluciente);

		insectoComeHombres.destruir();
		abismoReluciente.destruir();
		zona.mandarAlCementerioCartasDestruidas(cementerio);

		assertEquals(true, zona.estaEnElCampo(huevoMonstruoso));
		assertEquals(false, zona.estaEnElCampo(insectoComeHombres));
		assertEquals(false, zona.estaEnElCampo(abismoReluciente));
		assertEquals(2, cementerio.size());
	}

	@Test 
	public void eliminarMonstruoAlAzar() {
		
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		ZonaAtaque zona = new ZonaAtaque();
		ArrayList<Carta> cementerio = new ArrayList<>();
		
		CartaMonstruo dragon = new DragonBlancoDeOjosAzules();
		CartaMonstruo magaOscura = new ChicaMagaOscura();
		CartaMonstruo escudo = new EscudoMilenario();
		CartaMonstruo acechador = new AcechadorDelCraneo();

		dragon.asignarDuenio(unJugador);
		magaOscura.asignarDuenio(unJugador);
		escudo.asignarDuenio(unJugador);
		acechador.asignarDuenio(unJugador);
		
		zona.agregarCarta(dragon);
		zona.agregarCarta(magaOscura);
		zona.agregarCarta(escudo);
		zona.agregarCarta(acechador);
		
		zona.eliminarCartaAlAzar();
		zona.mandarAlCementerioCartasDestruidas(cementerio);
		assertEquals(3, zona.cantidadDeMonstruos());

		zona.eliminarCartaAlAzar();
		zona.mandarAlCementerioCartasDestruidas(cementerio);
		assertEquals(2, zona.cantidadDeMonstruos());
		
		zona.eliminarCartaAlAzar();
		zona.mandarAlCementerioCartasDestruidas(cementerio);
		assertEquals(1, zona.cantidadDeMonstruos());
		
		zona.eliminarCartaAlAzar();
		zona.mandarAlCementerioCartasDestruidas(cementerio);
		assertEquals(0, zona.cantidadDeMonstruos());
	}

	@Test
	public void saberQueNoHayTrampasColocadas(){
		ZonaDefensa zonaDefensa = new ZonaDefensa();

		CartaMonstruo insectoComeHombres = new InsectoComeHombres();

		CartaEfecto ollaDeLaCodicia = new OllaDeLaCodicia();
		CartaEfecto fisura = new Fisura();

		zonaDefensa.agregarCarta(fisura);
		zonaDefensa.agregarCarta(ollaDeLaCodicia);

		assertEquals(false, zonaDefensa.cartasTrampaEnJuego(insectoComeHombres, insectoComeHombres));

	}

}
