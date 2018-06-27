package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import fiuba.algo3.tp2.BocaAbajo;
import fiuba.algo3.tp2.CaraCarta;
import fiuba.algo3.tp2.PosicionCarta;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BocaAbajoBotonEventHandler implements EventHandler<MouseEvent> {

    private Controlador controlador;
    private CartaBoton cartaBoton;
    private PosicionCarta posicionCarta;
    private Stage stage;
    private CaraCarta cara;

    public BocaAbajoBotonEventHandler(Stage stage, Controlador controlador, CartaBoton cartaBoton, PosicionCarta posicionCarta){
        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.posicionCarta = posicionCarta;
        this.stage = stage;
        this.cara = new BocaAbajo();
    }

    @Override
    public void handle(MouseEvent event) {
        controlador.colocarMonstruo(cartaBoton, posicionCarta.getPosicion(), cara.getCara());
        controlador.colocarCartaEnCampo(cartaBoton.getCarta(), posicionCarta, cara);
        stage.close();
    }
}
