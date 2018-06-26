package InterfazGrafica.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage ventana;
    Scene proximaEscena;

    public BotonEntrarEventHandler(Stage ventana, Scene proximaEscena){
        this.ventana = ventana;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent event) {
        ventana.setWidth(1170);
        ventana.setHeight(1082);
        ventana.centerOnScreen();
        ventana.setScene(proximaEscena);
    }
}
