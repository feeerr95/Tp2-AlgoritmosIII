package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MazoTest {

    @Test
    public void agarrarCartaDelMazoRestaCantidadDelMismo(){
        Mazo mazo = new Mazo();

        assertEquals(50, mazo.cantidadDeCartasEnElMazo());

        mazo.obtenerCartaDeMazo();
        mazo.obtenerCartaDeMazo();
        mazo.obtenerCartaDeMazo();
        mazo.obtenerCartaDeMazo();

        assertEquals(46, mazo.cantidadDeCartasEnElMazo());
    }
}
