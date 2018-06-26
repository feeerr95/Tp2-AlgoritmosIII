package Vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class SalirEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public SalirEventHandler(Stage stage) {
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close();
    }
}