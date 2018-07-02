package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.AtacarALosPuntosDeVidaEventHandler;
import InterfazGrafica.Eventos.RecibirAtaqueEventHandler;
import fiuba.algo3.tp2.Carta;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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

        layout = new HBox();
        escena = new Scene(layout);
        this.setScene(escena);
        this.controlador = controlador;
        this.ventanaQueHacer = ventanaQueHacer;
        this.botonCartaAtacante = botonCartaAtacante;
        layout.setPadding(new Insets(10));
        layout.setSpacing(20);

        Image imagen = new Image("Imagenes/Zona De Ataque.png");
        BackgroundImage fondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(fondo);
        layout.setBackground(background);

        setEnemigos();

    }

    private void setEnemigos(){

        cartasEnemigas = this.controlador.obtenerEnemigos();
        if(!cartasEnemigas.isEmpty()){
            for(CartaBoton botonCartaAtacada: cartasEnemigas) {
                if(!botonCartaAtacada.getCarta().estaDestruida()){
                    CartaBoton carta = new CartaBoton(botonCartaAtacada.getCarta(), controlador);
                    RecibirAtaqueEventHandler recibirAtaqueEventHandler = new RecibirAtaqueEventHandler(this, controlador, botonCartaAtacada, this.botonCartaAtacante, ventanaQueHacer);
                    carta.getBoton().setOnMouseClicked(recibirAtaqueEventHandler);
                    layout.getChildren().add(carta.getBoton());
                }
            }
        }
        else if (cartasEnemigas.isEmpty() && !controlador.esElPrimerTurno()){
            Button atacarALosPuntosDeVidaBoton = new Button("Atacar a los puntos de vida");
            atacarALosPuntosDeVidaBoton.setPrefSize(608,190);
            AtacarALosPuntosDeVidaEventHandler atacarALosPuntosDeVidaEventHandler = new AtacarALosPuntosDeVidaEventHandler(this, controlador, botonCartaAtacante);
            atacarALosPuntosDeVidaBoton.setOnMouseClicked(atacarALosPuntosDeVidaEventHandler);
            layout.getChildren().add(atacarALosPuntosDeVidaBoton);
        }

    }
}
