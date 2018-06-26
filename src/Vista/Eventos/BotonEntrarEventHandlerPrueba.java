package Vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonEntrarEventHandlerPrueba implements EventHandler<ActionEvent> {

    Stage stage;
    Stage proximaEscena;

    public BotonEntrarEventHandlerPrueba(Stage stage, Stage proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        proximaEscena.show();
        stage.close();
    }
}
