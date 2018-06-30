package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DarVueltaBotonEventHandler implements EventHandler<MouseEvent> {


    Controlador controlador;
    CartaBoton botonDarVuelta;
    Stage ventanaQueHacer;

    public DarVueltaBotonEventHandler(Stage ventanaQueHacer, Controlador controlador, CartaBoton botonDarVuelta){
        this.controlador = controlador;
        this.botonDarVuelta = botonDarVuelta;
        this.ventanaQueHacer = ventanaQueHacer;
    }

    @Override
    public void handle(MouseEvent event) {

        botonDarVuelta.darVuelta();
        ventanaQueHacer.close();
    }
}
