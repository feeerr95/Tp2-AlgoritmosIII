package fiuba.algo3.tp2;

import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;
import fiuba.algo3.tp2.BaseDatosEfectos.*;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

	@Test
	public void restarPuntosDeVida() {
		
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		
		unJugador.restarPuntosDeVida(400);
		
        assertEquals(7600, unJugador.puntosDeVida());
	}

	@Test
	public void agarrarCartasYAumentarLaCantidadEnLaMano() {
		
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		
		unJugador.agarrarCarta();
		unJugador.agarrarCarta();
        assertEquals(2, unJugador.cantidadDeCartasEnMano());
	}

	@Test
	public void agarrarCartasIniciales(){
		Campo campo = new Campo();
		Jugador jugador = new Jugador(campo);

		jugador.agarrarCartasIniciales();

		assertEquals(5, jugador.cantidadDeCartasEnMano());
	}

	@Test
	public void agarrarCartasInicialesYQueSeHayanDescontadoDelMazo(){
		Campo campo = new Campo();
		Jugador jugador = new Jugador(campo);

		jugador.agarrarCartasIniciales();

		assertEquals(5, jugador.cantidadDeCartasEnMano());
		assertEquals(45,jugador.cantidadDeCartasEnElMazo());
	}

	@Test
	public void colocarCartaEnElCampo(){
		Campo campo = new Campo();
		Jugador jugador = new Jugador(campo);
		CartaMonstruo insectoComeHombres = new InsectoComeHombres();

		jugador.colocarEnElCampo(insectoComeHombres, new PosicionVertical(), new BocaArriba());
		assertEquals(true, campo.estaEnElCampo(insectoComeHombres));
	}


}
