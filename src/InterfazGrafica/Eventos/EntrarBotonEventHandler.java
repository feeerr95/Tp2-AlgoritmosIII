package InterfazGrafica.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EntrarBotonEventHandler implements EventHandler<ActionEvent> {

    private Stage ventana;
    private Scene proximaEscena;
    private double ancho;
    private double alto;

    public EntrarBotonEventHandler(Stage ventana, Scene proximaEscena, double ancho, double alto){
        this.ventana = ventana;
        this.proximaEscena = proximaEscena;
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public void handle(ActionEvent event) {
        ventana.setMinHeight(600);
        ventana.setMinWidth(500);
        ventana.setMaxWidth(ancho);
        ventana.setMaxHeight(alto);
        ventana.setResizable(true);
        ventana.centerOnScreen();
        ventana.setScene(proximaEscena);
    }
}
