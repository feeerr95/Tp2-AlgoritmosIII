package fiuba.algo3.tp2;

import excepciones.InsuficienteEspacioEnCampo;
import fiuba.algo3.tp2.BaseDatosCartas.Fisura;
import fiuba.algo3.tp2.BaseDatosCartas.InsectoComeHombres;
import org.junit.Test;

public class ZonaDeJuegoExcepcionesTest {

    @Test(expected = InsuficienteEspacioEnCampo.class)
    public void noSePuedenInsertarMasDeCincoMonstruos(){
        Campo campo = new Campo();

        for(int i = 0; i < 6; i++){
            Carta carta = new InsectoComeHombres();
            campo.agregarCarta(carta, new PosicionVertical(), new BocaAbajo());
        }
    }

    @Test(expected = InsuficienteEspacioEnCampo.class)
    public void noSePuedenInsertarMasDeCincoCartasEfecto(){
        Campo campo = new Campo();

        for(int i = 0; i < 6; i++){
            Carta carta = new Fisura();
            campo.agregarCarta(carta, new PosicionVertical(), new BocaAbajo());
        }
    }

}
