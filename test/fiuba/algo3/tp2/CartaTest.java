package fiuba.algo3.tp2;

import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosEfectos.AumentaAtaqueDelMonstruoAtacadoHastaElFinalDelTurno;

import static org.junit.Assert.assertEquals;

public class CartaTest {

	@Test
	public void agregarseAlCampo() {
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		Carta unaCarta = new CartaMonstruo("carta", 0, 0, new NivelBasico());
		unaCarta.asignarDuenio(unJugador);
		unaCarta.agregarseAlCampo(unCampo, new PosicionVertical(), new BocaAbajo());
		
		assertEquals(true, unaCarta.estaEnElCampo());
	}
	
	@Test
	public void modificarBonificaciones() {
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		CartaMonstruo unaCarta = new CartaMonstruo("carta", 0, 0, new NivelBasico());
		unaCarta.asignarDuenio(unJugador);
		unaCarta.cambiarBonificaciones(1, 1);
		
		Campo unCampo2 = new Campo();
		Jugador unJugador2 = new Jugador(unCampo2);
		CartaMonstruo unaCarta2 = new CartaMonstruo("carta2", 0, 0, new NivelBasico());
		unaCarta2.asignarDuenio(unJugador2);
		
		unaCarta.agregarseAlCampo(unCampo, new PosicionVertical(), new BocaArriba());
		unaCarta2.agregarseAlCampo(unCampo2, new PosicionVertical(), new BocaArriba());
		
		unaCarta.atacarOtraCarta(unaCarta2);
		
		assertEquals(false, unaCarta.estaDestruida());
		assertEquals(true, unaCarta2.estaDestruida());
		
	}
	
	@Test
	public void usarEfecto() {
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		Efecto unEfecto = new AumentaAtaqueDelMonstruoAtacadoHastaElFinalDelTurno(100, 100);
		CartaMonstruo unaCarta = new CartaMonstruo("carta", 0, 0, new NivelBasico());
		unaCarta.asignarDuenio(unJugador);
		
		Campo unCampo2 = new Campo();
		Jugador unJugador2 = new Jugador(unCampo2);
		CartaMonstruo unaCarta2 = new CartaMonstruo("carta2", 0, 0, new NivelBasico());
		unaCarta2.asignarDuenio(unJugador2);
		
		unaCarta.agregarseAlCampo(unCampo, new PosicionVertical(), new BocaArriba());
		unaCarta2.agregarseAlCampo(unCampo2, new PosicionVertical(), new BocaArriba());
		
		unaCarta2.recibirEfecto(unEfecto);
		unaCarta.atacarOtraCarta(unaCarta2);
		
		assertEquals(true, unaCarta.estaDestruida());
		assertEquals(false, unaCarta2.estaDestruida());
		
	}
}
