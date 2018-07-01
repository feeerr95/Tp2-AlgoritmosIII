package fiuba.algo3.tp2;

import fiuba.algo3.tp2.BaseDatosCartas.EspadachinDeLandstar;
import fiuba.algo3.tp2.BaseDatosCartas.HuevoMonstruoso;
import fiuba.algo3.tp2.BaseDatosCartas.InsectoComeHombres;
import fiuba.algo3.tp2.BaseDatosCartas.Jinzo7;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TableroTest {


    @Test
    public void elminarMonstruosDestruidosDelTablero(){
        Campo campo1 = new Campo();
        Campo campo2 = new Campo();
        Tablero tablero = new Tablero(campo1, campo2);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        CartaMonstruo espadachin = new EspadachinDeLandstar();

        campo1.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaAbajo());
        campo2.agregarCarta(espadachin, new PosicionVertical(), new BocaAbajo());

        insectoComeHombres.destruir();
        espadachin.destruir();

        tablero.eliminarCartasDestruidasJ1();
        tablero.eliminarCartasDestruidasJ2();

        assertEquals(false, campo1.estaEnElCampo(insectoComeHombres));
        assertEquals(false, campo2.estaEnElCampo(espadachin));
    }

    @Test
    public void elminarMonstruosDelTablero(){
        Campo campo1 = new Campo();
        Campo campo2 = new Campo();
        Tablero tablero = new Tablero(campo1, campo2);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        CartaMonstruo jinzo7 = new Jinzo7();
        CartaMonstruo espadachin = new EspadachinDeLandstar();

        campo1.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaAbajo());
        campo1.agregarCarta(huevoMonstruoso, new PosicionVertical(), new BocaAbajo());

        campo2.agregarCarta(jinzo7, new PosicionVertical(), new BocaAbajo());
        campo2.agregarCarta(espadachin, new PosicionVertical(), new BocaAbajo());

        tablero.eliminarMonstruos();
        tablero.eliminarCartasDestruidasJ1();
        tablero.eliminarCartasDestruidasJ2();

        assertEquals(false, campo1.estaEnElCampo(insectoComeHombres));
        assertEquals(false, campo1.estaEnElCampo(huevoMonstruoso));
        assertEquals(false, campo2.estaEnElCampo(jinzo7));
        assertEquals(false, campo2.estaEnElCampo(espadachin));

    }
}
