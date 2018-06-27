package fiuba.algo3.tp2;

import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

public class ZonaTest {

	@Test
	public void agregarMonstruosAZonaAtaqueYDestruirlos() {
		
		Campo unCampo = new Campo();
		ZonaAtaque zona = new ZonaAtaque();
		Jugador unJugador = new Jugador(unCampo);
		
		CartaMonstruo dragon = new DragonBlancoDeOjosAzules();
		CartaMonstruo magaOscura = new ChicaMagaOscura();
		CartaMonstruo acechador = new AcechadorDelCraneo();
		dragon.asignarDuenio(unJugador);
		magaOscura.asignarDuenio(unJugador);
		acechador.asignarDuenio(unJugador);
		zona.agregarCarta(dragon);
		zona.agregarCarta(magaOscura);
		zona.agregarCarta(acechador);
		
		assertEquals(true, zona.estaEnElCampo("Dragon Blanco De Ojos Azules"));
		assertEquals(true, zona.estaEnElCampo("Chica Maga Oscura"));
		assertEquals(true, zona.estaEnElCampo("Acechador Del Craneo"));
		
		zona.destruirTodasLasCartas();
		
		assertEquals(false, zona.estaEnElCampo("Dragon Blanco De Ojos Azules"));
		assertEquals(false, zona.estaEnElCampo("Chica Maga Oscura"));
		assertEquals(false, zona.estaEnElCampo("Acechador Del Craneo"));
	}
	
	@Test 
	public void eliminarCartaAlAzar() {
		
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		ZonaAtaque zona = new ZonaAtaque();
		Stack<Carta> cementerio = new Stack<>();
		
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
		
		assertEquals(3, zona.cantidadDeMonstruos());
		
		zona.eliminarCartaAlAzar();
		
		assertEquals(2, zona.cantidadDeMonstruos());
		
		zona.eliminarCartaAlAzar();
		
		assertEquals(1, zona.cantidadDeMonstruos());
		
		zona.eliminarCartaAlAzar();
		
		assertEquals(0, zona.cantidadDeMonstruos());
	}

}
