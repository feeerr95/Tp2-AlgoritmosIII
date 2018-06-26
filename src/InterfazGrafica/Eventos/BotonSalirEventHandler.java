package InterfazGrafica.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    Stage ventana;

    public BotonSalirEventHandler(Stage ventana){
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent event) {
        ventana.close();
    }
}
