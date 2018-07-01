package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class TerminarTurnoBotonEventHandler implements EventHandler<MouseEvent> {

    Controlador controlador;

    public TerminarTurnoBotonEventHandler(Controlador controlador){
        this.controlador = controlador;
    }

    @Override
    public void handle(MouseEvent event) {
        if(!controlador.revisarSiSeGano()){
            controlador.eliminarCartasDestruidas();
            controlador.terminarTurno();
        }
    }
}
