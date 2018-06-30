package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UsarEfectoBotonHandler implements EventHandler<MouseEvent> {


    Controlador controlador;
    CartaBoton cartaBotonUsarEfecto;
    Stage ventanaQueHacer;

    public UsarEfectoBotonHandler(Stage ventanaQueHacer, Controlador controlador, CartaBoton cartaBotonUsarEfecto){
        this.controlador = controlador;
        this.cartaBotonUsarEfecto = cartaBotonUsarEfecto;
        this.ventanaQueHacer = ventanaQueHacer;
    }

    @Override
    public void handle(MouseEvent event) {
        ventanaQueHacer.close();
    }


}
