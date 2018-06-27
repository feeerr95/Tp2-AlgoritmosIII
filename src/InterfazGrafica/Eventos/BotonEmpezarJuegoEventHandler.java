package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonEmpezarJuegoEventHandler implements EventHandler<ActionEvent> {

    Controlador controlador;
    Button botonEmpezar;

    public BotonEmpezarJuegoEventHandler(Controlador controlador, Button botonEmpezar){
        this.controlador = controlador;
        this.botonEmpezar = botonEmpezar;
    }

    @Override
    public void handle(ActionEvent event) {
        controlador.setManosIniciales();
        controlador.getContenedorPrincipal().getChildren().remove(botonEmpezar);
        controlador.getContenedorPrincipal().setInicioJuego();
    }
}
