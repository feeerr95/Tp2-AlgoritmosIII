package InterfazGrafica.Eventos;


import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CambiarPosicionBotonEventHandler implements EventHandler<MouseEvent> {


    Controlador controlador;
    CartaBoton botonCambiarPosicion;
    Stage ventanaQueHacer;

    public CambiarPosicionBotonEventHandler(Stage ventanaQueHacer, Controlador controlador, CartaBoton botonCambiarPosicion){
        this.controlador = controlador;
        this.botonCambiarPosicion = botonCambiarPosicion;
        this.ventanaQueHacer = ventanaQueHacer;
    }

    @Override
    public void handle(MouseEvent event) {
        botonCambiarPosicion.cambiarDePosicion();
        ventanaQueHacer.close();
    }
}
