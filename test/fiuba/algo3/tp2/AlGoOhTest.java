package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlGoOhTest {

    @Test
    public void test01AgregarCartaMonstruoEnPA() {
        Campo campo1 = new Campo();
        Jugador jugador1 = new Jugador();
        jugador1.agregarCarta("Huevo Monstruoso", "VBAR");
        assertEquals(true, jugador1.cartaEnJuego("Huevo Monstruoso", "VBAR"));

    }
//
//    @Test
//    public void test02AgregarCartaMonstruoEnPD() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Huevo Monstruoso", "HBAR");
//
//        assertEquals(true, jugador1.cartaEnJuego("Huevo Monstruoso", "HBAR"));
//
//    }
//
//    @Test
//    public void test03AgregarCartaMagica() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Agujero Negro", "VBAR");
//        assertEquals(true, jugador1.cartaEnJuego("Agujero Negro", "VBAR"));
//
//    }
//
//    @Test
//    public void test04AgregarCartaTrampa() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Cilindro Magico", "VBAB");
//        assertEquals(true, jugador1.cartaEnJuego("Cilindro Magico", "VBAB"));
//
//    }
//
//
//    @Test
//    public void test05AgregarCartaAlCementerio(){
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Huevo Monstruoso", "PA");
//        jugador1.destriurCarta("Huevo Monstruoso");
//
//        assertEquals(true, jugador1.cartaEnCementerio("Huevo Monstruoso"));
//    }
//
//    @Test
//    public void test06AtaqueCartaMonstruoConDerrota() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Insecto Come-Hombres", "PA");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Huevo Monstruoso", "PA");
//        jugador1.atacar("Insecto Come-Hombres", "Huevo Monstruoso");
//        jugador1.destruirCarta("Insecto Come-Hombres");
//
//        assertEquals(true, jugador1.cartaEnCementerio("Insecto Come-Hombres"));
//    }
//
//    @Test
//    public void test06AtaqueCartaMonstruoConDerrotaPuntosDeVidaCorrectos() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Insecto Come-Hombres", "PA");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Huevo Monstruoso", "PA");
//        jugador1.atacar("Insecto Come-Hombres", "Huevo Monstruoso");
//        jugador1.destruirCarta("Insecto Come-Hombres");
//
//        assertEquals(7500, jugador1.obtenerPuntosDeVida());
//    }
//
//    @Test
//    public void test07AtaqueCartaMonstruoConVictoria() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Insecto Come-Hombres", "PA");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Huevo Monstruoso", "PA");
//        jugador2.atacar("Huevo Monstruoso","Insecto Come-Hombres");
//        jugador1.destruirCarta("Insecto Come-Hombres");
//
//        assertEquals(true, jugador1.cartaEnCementerio("Insecto Come-Hombres"));
//        assertEquals(false, jugador1.cartaEnJuego("Insecto Come-Hombres"));
//    }
//
//    @Test
//    public void test07AtaqueCartaMonstruoConVictoriaConPuntosDeVidaCorrectos() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Insecto Come-Hombres", "PA");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Huevo Monstruoso", "PA");
//        jugador2.atacar("Huevo Monstruoso","Insecto Come-Hombres");
//        jugador1.destruirCarta("Insecto Come-Hombres");
//
//        assertEquals(7500, jugador1.obtenerPuntosDeVida());
//    }
//
//
//
//    @Test
//    public void test08AtaqueCartaMonstruoConEmpate() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Insecto Come-Hombres", "PA");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Insecto Come-Hombres", "PA");
//        jugador2.atacar("Insecto Come-Hombres","Insecto Come-Hombres");
//
//
//        assertEquals(true, jugador1.cartaEnCementerio("Insecto Come-Hombres"));
//        assertEquals(true, jugador2.cartaEnCementerio("Insecto Come-Hombres"));
//        assertEquals(8000, jugador1.obtenerPuntosDeVida());
//        assertEquals(8000, jugador2.obtenerPuntosDeVida());
//    }
//
//    @Test
//    public void test09AtaqueCartaMonstruoEnPDConVictoria() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Insecto Come-Hombres", "PD");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Huevo Monstruoso", "PA");
//        jugador2.atacar("Huevo Monstruoso","Insecto Come-Hombres");
//        jugador1.destruirCarta("Insecto Come-Hombres");
//
//
//        assertEquals(true, jugador1.cartaEnCementerio("Insecto Come-Hombres"));
//        assertEquals(8000, jugador1.obtenerPuntosDeVida());
//    }
//
//    @Test
//    public void test10AtaqueCartaMonstruoEnPDConDerrota() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Huevo Monstruoso", "PD");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Insecto Come-Hombres", "PA");
//        jugador2.atacar("Insecto Come-Hombres", "Huevo Monstruoso");
//        jugador2.destruirCarta("Insecto Come-Hombres");
//
//
//        assertEquals(true, jugador1.cartaEnJuego("Huevo Monstruoso"));
//        assertEquals(8000, jugador1.obtenerPuntosDeVida());
//    }
//
//    @Test
//    public void test11ColocarAgujeroNegro() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Huevo Monstruoso", "PA");
//        Campo campo2 = new Campo();
//        Jugador jugador2 = new Jugador(campo2);
//        jugador2.agregarCarta("Insecto Come-Hombres", "PA");
//
//        jugador1.agregarCarta("Agujero Negro", "PA");
//
//        assertEquals(true, jugador1.campoVacio());
//        assertEquals(true, jugador2.campoVacio());
//        assertEquals(8000, jugador1.obtenerPuntosDeVida());
//        assertEquals(8000, jugador2.obtenerPuntosDeVida());
//
//    }
//
//    @Test
//    public void test12ColocarMonstruoConSacrificio() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Huevo Monstruoso", "PA");
//        jugador1.agregarCarta("Chica Maga Oscura","PA");
//
//
//        assertEquals(true, jugador1.cartaEnCementerio("Huevo Monstruoso"));
//        assertEquals(true, jugador1.cartaEnJuego("Chica Maga Oscura"));
//    }
//
//    @Test
//    public void test13ColocarMonstruoConDosSacrificios() {
//        Campo campo1 = new Campo();
//        Jugador jugador1 = new Jugador(campo1);
//        jugador1.agregarCarta("Huevo Monstruoso", "PA");
//        jugador1.agregarCarta("Insecto Come-Hombres", "PA");
//        jugador1.agregarCarta("Dragon Blanco De Ojos Azules","PA");
//
//
//        assertEquals(true, jugador1.cartaEnCementerio("Huevo Monstruoso"));
//        assertEquals(true, jugador1.cartaEnCementerio("Insecto Come-Hombres"));
//        assertEquals(true, jugador1.cartaEnJuego("Dragon Blanco De Ojos Azules"));
//
//
//    }
//}
//
//
}
