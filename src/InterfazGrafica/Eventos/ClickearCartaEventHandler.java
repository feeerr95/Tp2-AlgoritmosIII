package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ClickearCartaEventHandler implements EventHandler<MouseEvent> {

    Controlador controlador;
    CartaBoton cartaBoton;

    public ClickearCartaEventHandler(CartaBoton cartaBoton, Controlador controlador){
        this.cartaBoton = cartaBoton;
        this.controlador = controlador;
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
