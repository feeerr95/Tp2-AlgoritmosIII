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
		
		assertEquals(true , unCampo.estaEnElCampo("Dragon Blanco De Ojos Azules"));
		assertEquals(true , unCampo.estaEnElCampo("Chica Maga Oscura"));
		//Es false ya que no son jugadas en la zona de ataque
		assertEquals(false , unCampo.estaEnElCampo("Fisura"));
		assertEquals(false , unCampo.estaEnElCampo("Sogen"));
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
		
		assertEquals(true , unCampo.estaEnElCampo("Dragon Blanco De Ojos Azules"));
		assertEquals(true , unCampo.estaEnElCampo("Chica Maga Oscura"));
		assertEquals(true , unCampo.estaEnElCampo("Escudo Milenario"));
		
		unCampo.destruirTodasLasCartasMonstruo();
		
		assertEquals(false , unCampo.estaEnElCampo("Dragon Blanco De Ojos Azules"));
		assertEquals(false , unCampo.estaEnElCampo("Chica Maga Oscura"));
		assertEquals(false , unCampo.estaEnElCampo("Escudo Milenario"));
		
	}

}
