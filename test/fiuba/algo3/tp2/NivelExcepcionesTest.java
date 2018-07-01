package fiuba.algo3.tp2;

import excepciones.NoHayMonstruosEnCampo;
import fiuba.algo3.tp2.BaseDatosCartas.ChicaMagaOscura;
import org.junit.Test;

public class NivelExcepcionesTest {

    @Test(expected = NoHayMonstruosEnCampo.class)
    public void noHayMonstruoParaColocarCartaNivelMedio(){

        Campo campo = new Campo();
        Carta chicaMagaOscura = new ChicaMagaOscura();
        campo.agregarCarta(chicaMagaOscura ,new PosicionVertical(), new BocaAbajo());
    }

    @Test
    public void hayUnMonstruoParaColocarCartaNivelMedio(){
        
    }

}
