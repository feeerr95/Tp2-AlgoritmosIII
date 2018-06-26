package Vista.Eventos;

import Vista.BotonTerminarTurno;
import Vista.ContenedorPrincipalPrueba;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class BotonEmpezarEventHandlerPrueba implements EventHandler<ActionEvent> {

    private ContenedorPrincipalPrueba contenedorPrincipalPrueba;
    private Button botonEmpezar;

    public BotonEmpezarEventHandlerPrueba(ContenedorPrincipalPrueba contenedorPrincipalPrueba, Button botonEmpezar){
        this.contenedorPrincipalPrueba = contenedorPrincipalPrueba;
        this.botonEmpezar = botonEmpezar;
    }
    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {

        contenedorPrincipalPrueba.iniciarJuego();
        BotonTerminarTurno botonTerminarTurno = new BotonTerminarTurno();
        botonTerminarTurno.setLayoutX(botonEmpezar.getLayoutX());
        botonTerminarTurno.setLayoutY(botonEmpezar.getLayoutY());
        contenedorPrincipalPrueba.getChildren().remove(botonEmpezar);
        contenedorPrincipalPrueba.getChildren().add(botonTerminarTurno);
    }

}

