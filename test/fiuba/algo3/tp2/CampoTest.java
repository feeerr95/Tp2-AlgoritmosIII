package fiuba.algo3.tp2;

import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;

import static org.junit.Assert.assertEquals;

public class CampoTest {

	@Test
	public void agregarCartaAlCampo() {
		
		Campo unCampo = new Campo();
		
		CartaMonstruo dragon = new DragonBlancoDeOjosAzules();
		CartaMonstruo magaOscura = new ChicaMagaOscura();
		CartaMagica fisura = new Fisura();
		CartaTerreno sogen = new Sogen();
		
		unCampo.agregarCartaEnZonaDeAtaque(magaOscura);
		unCampo.agregarCartaEnZonaDeAtaque(dragon);
		unCampo.agregarCarta(fisura, new PosicionVertical(), new BocaAbajo());
		unCampo.agregarCartaDeTerreno(sogen);
		
		assertEquals(true , unCampo.estaEnElCampo(dragon));
		assertEquals(true , unCampo.estaEnElCampo(magaOscura));
		//Es false ya que no son jugadas en la zona de ataque
		assertEquals(false , unCampo.estaEnElCampo(fisura));
		assertEquals(false , unCampo.estaEnElCampo(sogen));
	}
	
	@Test
	public void jugarMonstruosYDestruirlos() {
		
		Campo unCampo = new Campo();
		Jugador unJugador = new Jugador(unCampo);
		CartaMonstruo dragon = new DragonBlancoDeOjosAzules();
		CartaMonstruo magaOscura = new ChicaMagaOscura();
		CartaMonstruo escudo = new EscudoMilenario();
		dragon.asignarDuenio(unJugador);
		magaOscura.asignarDuenio(unJugador);
		escudo.asignarDuenio(unJugador);
		
		unCampo.agregarCartaEnZonaDeAtaque(magaOscura);
		unCampo.agregarCartaEnZonaDeAtaque(dragon);
		unCampo.agregarCartaEnZonaDeAtaque(escudo);
		
		assertEquals(true , unCampo.estaEnElCampo(dragon));
		assertEquals(true , unCampo.estaEnElCampo(magaOscura));
		assertEquals(true , unCampo.estaEnElCampo(escudo));
		
		unCampo.destruirTodasLasCartasMonstruo();
		
		assertEquals(false , unCampo.estaEnElCampo(dragon));
		assertEquals(false , unCampo.estaEnElCampo(magaOscura));
		assertEquals(false , unCampo.estaEnElCampo(escudo));
		
	}

}
