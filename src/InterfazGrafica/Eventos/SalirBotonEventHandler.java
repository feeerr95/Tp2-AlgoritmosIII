package InterfazGrafica.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SalirBotonEventHandler implements EventHandler<ActionEvent> {

    Stage ventana;

    public SalirBotonEventHandler(Stage ventana){
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent event) {
        ventana.close();
    }
}
