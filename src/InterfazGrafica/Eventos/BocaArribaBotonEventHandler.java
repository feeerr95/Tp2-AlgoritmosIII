package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import fiuba.algo3.tp2.BocaArriba;
import fiuba.algo3.tp2.CaraCarta;
import fiuba.algo3.tp2.PosicionCarta;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BocaArribaBotonEventHandler implements EventHandler<MouseEvent> {

    private Controlador controlador;
    private CartaBoton cartaBoton;
    private PosicionCarta posicionCarta;
    private Stage stage;
    private CaraCarta cara;

    public BocaArribaBotonEventHandler(Stage stage, Controlador controlador, CartaBoton cartaBoton, PosicionCarta posicionCarta){
        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.posicionCarta = posicionCarta;
        this.stage = stage;
        this.cara = new BocaArriba();
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(controlador);
        System.out.println(cartaBoton);
        System.out.println(posicionCarta);
        System.out.println(cara);
        controlador.colocarMonstruo(cartaBoton, posicionCarta.getPosicion(), cara.getCara());
        controlador.colocarCartaEnCampo(cartaBoton, posicionCarta, cara);
        stage.close();
    }
}
