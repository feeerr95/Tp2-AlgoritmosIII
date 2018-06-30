package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.RecibirAtaqueEventHandler;
import fiuba.algo3.tp2.Carta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class VentanaAtacar extends Stage {
    private Controlador controlador;
    private CartaBoton botonCartaAtacante;
    private HBox layout;
    private Scene escena;
    private ArrayList<CartaBoton> cartasEnemigas;
    private Stage ventanaQueHacer;

    public VentanaAtacar(Stage ventanaQueHacer, Controlador controlador, CartaBoton botonCartaAtacante) {

        this.setTitle("Seleccione a que carta atacar");
        ArrayList<CartaBoton> cartasEnemigas = new ArrayList<>();

        layout = new HBox();
        escena = new Scene(layout);
        this.setScene(escena);
        this.controlador = controlador;
        this.ventanaQueHacer = ventanaQueHacer;
        this.botonCartaAtacante = botonCartaAtacante;
        layout.setSpacing(20);


        setEnemigos();

    }

    private void setEnemigos(){

        cartasEnemigas = this.controlador.obtenerEnemigos();
        for(CartaBoton botonCartaAtacada: cartasEnemigas) {

            CartaBoton carta = new CartaBoton(botonCartaAtacada.getCarta(), controlador);
            RecibirAtaqueEventHandler recibirAtaqueEventHandler = new RecibirAtaqueEventHandler(this, controlador, botonCartaAtacada, this.botonCartaAtacante, ventanaQueHacer);
            carta.getBoton().setOnMouseClicked(recibirAtaqueEventHandler);
            layout.getChildren().add(carta.getBoton());

        }
    }
}
