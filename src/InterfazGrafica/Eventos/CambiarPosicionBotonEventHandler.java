package InterfazGrafica.Eventos;


import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CambiarPosicionBotonEventHandler implements EventHandler<MouseEvent> {


    Controlador controlador;
    CartaBoton botonCambiarPosicion;
    Stage stage;

    public CambiarPosicionBotonEventHandler(Stage stage, Controlador controlador, CartaBoton botonCambiarPosicion){
        this.controlador = controlador;
        this.botonCambiarPosicion = botonCambiarPosicion;
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent event) {
        botonCambiarPosicion.cambiarDePosicion();
        stage.close();
    }
}
