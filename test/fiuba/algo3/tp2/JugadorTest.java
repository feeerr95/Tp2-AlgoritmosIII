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
		
		unJugador.restarPuntosDeVida(7999);
		
        assertEquals(1, unJugador.puntosDeVida());
        
		unJugador.restarPuntosDeVida(1);
		
        assertEquals(0, unJugador.puntosDeVida());
	}

	@Test
	public void agarrarCartasYSumarlasALaMano() {
		
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		
		unJugador.agarrarCarta();
		unJugador.agarrarCarta();
		
        assertEquals(2, unJugador.cantidadDeCartasEnMano());
	}
}