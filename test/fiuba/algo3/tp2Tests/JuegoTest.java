package fiuba.algo3.tp2Tests;

import org.junit.Test;

public class JuegoTest {
	
	@Test
	public void test01AgregarCartaMonstruoEnPA() {
		Juego nuevoJuego = new Juego();
	
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo");
	
		assertEquals(true, nuevoJuego.estaCartaEnTablero("cartaMonstruo", "PA"));
		//no verifica si esta en posición de ataque
		//hace falta que el tablero tenga nombre?
	}
	
	@Test
	public void test02AgregarCartaMonstruoEnPD() {
		Juego nuevoJuego = new Juego();
		
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPD("nuevoTablero", "jugador1", "cartaMonstruo");
	
		assertEquals(true, nuevoJuego.estaCartaEnTablero("cartaMonstruo", "PD"));
		
	}
	
	@Test
	public void test03AgregarCartaMagica(){
		Juego nuevoJuego = new Juego();
		
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMagica("nuevoTablero", "jugador1", "cartaMagica");
	
		assertEquals(true, nuevoJuego.estaCartaEnTablero("cartaMagica"));
	}
	
	@Test
	public void test04AgregarCartaTrampa(){
		Juego nuevoJuego = new Juego();
		
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMagica("nuevoTablero", "jugador1", "cartaTrampa");
	
		assertEquals(true, nuevoJuego.estaCartaEnTablero("cartaTrampa"));
	}
	
	@Test
	public void test05DestruirCarta(){
		Juego nuevoJuego = new Juego();
		
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo");
		nuevoJuego.destruirCarta("juegador1", "cartaMonstruo")
	
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo"));
	}
	
	@Test
	public void test06AtaqueCartaMonstruoConDerrota() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador2", "cartaMonstruo2");
		nuevoJuego.atacar("monstruo1", "monstruo2");
		
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo1"));	
		assertEquals(7500, nuevoJuego.obtenerPuntosDeVida("jugador1"));
	}
		
	@Test
	public void test07AtaqueCartaMonstruoConVictoria() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador2", "cartaMonstruo2");
		nuevoJuego.atacar("monstruo1", "monstruo2");
		
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo2"));	
		assertEquals(7800, nuevoJuego.obtenerPuntosDeVida("jugador2"));
	}
	
	@Test
	public void test08AtaqueCartaMonstruoConEmpate() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador2", "cartaMonstruo2");
		nuevoJuego.atacar("monstruo1", "monstruo2");
		
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo1"));	
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo2"));	
		assertEquals(8000, nuevoJuego.obtenerPuntosDeVida("jugador1"));
		assertEquals(8000, nuevoJuego.obtenerPuntosDeVida("jugador2"));
	}
	
	@Test
	public void test09AtaqueCartaMonstruoEnPDConVictoria() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPD("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador2", "cartaMonstruo2");
		nuevoJuego.atacar("monstruo2", "monstruo1");
		
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo1"));	
		assertEquals(8000, nuevoJuego.obtenerPuntosDeVida("jugador1"));
	}
	
	@Test
	public void test10AtaqueCartaMonstruoEnPDConDerrota() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPD("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador2", "cartaMonstruo2");
		nuevoJuego.atacar("monstruo2", "monstruo1");
		
		assertEquals(false, nuevoJuego.estaCartaEnCementerio("cartaMonstruo1"));	
		assertEquals(8000, nuevoJuego.obtenerPuntosDeVida("jugador1"));
	}
	
	@Test
	public void test11ColocarAgujeroNegro() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador2", "cartaMonstruo2");
		nuevoJuego.agregarCartaMagica("nuevoTablero", "jugador1", "Agujero Negro");
		
		assertEquals(false, nuevoJuego.hayCartasEnElTablero());	
		assertEquals(8000, nuevoJuego.obtenerPuntosDeVida("jugador1"));
		assertEquals(8000, nuevoJuego.obtenerPuntosDeVida("jugador2"));
	}
	
	@Test
	public void test12ColocarMonstruoConSacrificio() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo2");
		//monstruo 2 de 5 estrellas

		
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo1"));
		assertEquals(true, nuevoJuego.estaCartaEnTablero("cartaMonstruo2"));
	}
	
	@Test
	public void test13ColocarMonstruoConDosSacrificios() {
		Juego nuevoJuego = new Juego();
			
		nuevoJuego.inicializarTablero("nuevoTablero");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo1");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo2");
		nuevoJuego.agregarCartaMonstruoPA("nuevoTablero", "jugador1", "cartaMonstruo3");
		//monstruo 3 de 7 estrellas
		
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo1"));
		assertEquals(true, nuevoJuego.estaCartaEnCementerio("cartaMonstruo2"));
		assertEquals(true, nuevoJuego.estaCartaEnTablero("cartaMonstruo3"));
	}
}