package fiuba.algo3.tp2;

import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;

import static org.junit.Assert.assertEquals;

public class CampoTest {

	@Test
	public void agregarCartasAlCampo() {

		Campo campo1 = new Campo();
		Campo campo2 = new Campo();
		Tablero tablero = new Tablero(campo1, campo2);

		campo1.setTablero(tablero);
		campo2.setTablero(tablero);

		CartaMonstruo insectoComeHombres = new InsectoComeHombres();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		CartaMagica fisura = new Fisura();
		CartaTerreno sogen = new Sogen();

		campo1.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaArriba());
		campo1.agregarCarta(huevoMonstruoso, new PosicionVertical(), new BocaArriba());
		campo1.agregarCarta(fisura, new PosicionVertical(), new BocaAbajo());
		campo1.agregarCarta(sogen, new PosicionVertical(), new BocaArriba());

		assertEquals(true, campo1.estaEnElCampo(insectoComeHombres));
		assertEquals(true, campo1.estaEnElCampo(huevoMonstruoso));
		assertEquals(true, campo1.estaEnElCampo(fisura));
		assertEquals(true, campo1.estaEnElCampo(sogen));
	}

	@Test
	public void mandarAlCementerioLasCartasDestruidas() {

		Campo campo = new Campo();

		CartaMonstruo insectoComeHombres = new InsectoComeHombres();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		CartaMagica fisura = new Fisura();

		campo.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaArriba());
		campo.agregarCarta(huevoMonstruoso, new PosicionVertical(), new BocaArriba());
		campo.agregarCarta(fisura, new PosicionVertical(), new BocaAbajo());

		assertEquals(true, campo.estaEnElCampo(insectoComeHombres));
		assertEquals(true, campo.estaEnElCampo(huevoMonstruoso));
		assertEquals(true, campo.estaEnElCampo(fisura));

		insectoComeHombres.destruir();
		huevoMonstruoso.destruir();

		campo.mandarAlCementerioCartasDestruidas();

		assertEquals(false, campo.estaEnElCampo(insectoComeHombres));
		assertEquals(false, campo.estaEnElCampo(huevoMonstruoso));

		//Fisura tiene que seguir en el campo debido a que no fue destruida
		assertEquals(true, campo.estaEnElCampo(fisura));

	}

	@Test
	public void agregarCartaALaZonaDeAtaque() {

		Campo campo = new Campo();
		CartaMonstruo insectoComeHombres = new InsectoComeHombres();
		campo.agregarCartaEnZonaDeAtaque(insectoComeHombres);

		assertEquals(true, campo.estaEnElCampo(insectoComeHombres));
	}

	@Test
	public void agregarCartaALaZonaDeDefensa() {

		Campo campo = new Campo();
		CartaMagica fisura = new Fisura();
		campo.agregarCartaEnZonaDeDefensa(fisura);

		assertEquals(true, campo.estaEnElCampo(fisura));
	}
}



