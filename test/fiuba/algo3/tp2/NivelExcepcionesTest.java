package fiuba.algo3.tp2;

import excepciones.NoHayMonstruosEnCampo;
import fiuba.algo3.tp2.BaseDatosCartas.ChicaMagaOscura;
import fiuba.algo3.tp2.BaseDatosCartas.DragonBlancoDeOjosAzules;
import fiuba.algo3.tp2.BaseDatosCartas.HuevoMonstruoso;
import fiuba.algo3.tp2.BaseDatosCartas.InsectoComeHombres;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NivelExcepcionesTest {

    @Test(expected = NoHayMonstruosEnCampo.class)
    public void noHayMonstruoParaColocarCartaNivelMedio(){

        Campo campo = new Campo();
        Carta chicaMagaOscura = new ChicaMagaOscura();
        campo.agregarCarta(chicaMagaOscura ,new PosicionVertical(), new BocaAbajo());
    }

    @Test
    public void hayUnMonstruoParaColocarCartaNivelMedio(){
        Campo campo = new Campo();
        Carta chicaMagaOscura = new ChicaMagaOscura();
        Carta insectoComeHombres = new InsectoComeHombres();
        campo.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaAbajo());
        campo.agregarCarta(chicaMagaOscura ,new PosicionVertical(), new BocaAbajo());

        assertEquals(true, campo.estaEnElCampo(chicaMagaOscura));
        assertEquals(true, insectoComeHombres.estaDestruida());
    }

    @Test(expected = NoHayMonstruosEnCampo.class)
    public void noHayMonstruosParaColocarCartaNivelAlto(){

        Campo campo = new Campo();
        Carta dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
        campo.agregarCarta(dragonBlancoDeOjosAzules ,new PosicionVertical(), new BocaAbajo());
    }

    @Test
    public void hayDosMonstruosParaColocarCartaNivelAlto(){
        Campo campo = new Campo();
        Carta huevoMonstruoso = new HuevoMonstruoso();
        Carta insectoComeHombres = new InsectoComeHombres();
        Carta dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
        campo.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaAbajo());
        campo.agregarCarta(huevoMonstruoso ,new PosicionVertical(), new BocaAbajo());
        campo.agregarCarta(dragonBlancoDeOjosAzules ,new PosicionVertical(), new BocaAbajo());

        assertEquals(true, campo.estaEnElCampo(dragonBlancoDeOjosAzules));
        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, huevoMonstruoso.estaDestruida());
    }

    @Test
    public void agregarMonstruoNivelBasico(){
        Campo campo = new Campo();
        Carta huevoMonstruoso = new HuevoMonstruoso();
        campo.agregarCarta(huevoMonstruoso ,new PosicionVertical(), new BocaAbajo());

        assertEquals(true, campo.estaEnElCampo(huevoMonstruoso));
    }

}
