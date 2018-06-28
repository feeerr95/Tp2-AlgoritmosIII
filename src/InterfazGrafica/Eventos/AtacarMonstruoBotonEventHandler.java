package InterfazGrafica.Eventos;


import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.VentanaAtacar;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AtacarMonstruoBotonEventHandler implements EventHandler<MouseEvent> {

    Controlador controlador;
    CartaBoton cartaBoton;
    Stage stage;

    public AtacarMonstruoBotonEventHandler(Stage stage, Controlador controlador, CartaBoton cartaBoton){
        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent event) {
        VentanaAtacar ventanaAtacar = new VentanaAtacar(controlador, cartaBoton);
        ventanaAtacar.mostrar();
    }
}
