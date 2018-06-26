package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.BotonEmpezarJuegoEventHandler;
import InterfazGrafica.Eventos.ClickearCartaEventHandler;
import InterfazGrafica.Modelo.Modelo;
import fiuba.algo3.tp2.Carta;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorPrincipal extends AnchorPane {

    ListView<Button> manoJugador1 = new ListView<>();
    ListView<Button> manoJugador2 = new ListView<>();
    Controlador controlador;

    public ContenedorPrincipal(Stage stage, Modelo modelo, Controlador controlador){

        Image imagenFondo = new Image("Imagenes/Tablero.jpg");
        BackgroundImage imagen = new BackgroundImage(imagenFondo,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.controlador = controlador;

        Background fondo = new Background(imagen);
        this.setBackground(fondo);

        Button empezarJuegoBoton = new Button("Empezar Juego");
        empezarJuegoBoton.setLayoutX(80);
        empezarJuegoBoton.setLayoutY(400);
        BotonEmpezarJuegoEventHandler botonEmpezarJuegoEventHandler = new BotonEmpezarJuegoEventHandler(controlador, empezarJuegoBoton);
        empezarJuegoBoton.setOnAction(botonEmpezarJuegoEventHandler);
        this.getChildren().add(empezarJuegoBoton);

    }

    public void setManos(ArrayList<Carta> manoJugador1, ArrayList<Carta> manoJugador2){

        HBox manoJugador1Box = new HBox();
        HBox manoJugador2Box = new HBox();

        for(Carta carta: manoJugador1){
            Button cartaBoton = new Button();
            Image image = new Image("Imagenes/"+carta.getNombreCarta()+".png");
            ImageView imagenCarta = new ImageView(image);
            imagenCarta.setFitHeight(140);
            imagenCarta.setFitWidth(90);
            cartaBoton.setGraphic(imagenCarta);
            cartaBoton.setMaxSize(94,144);

//            ClickearCartaEventHandler clickearCartaEventHandler = new ClickearCartaEventHandler(cartaBoton);
//            cartaBoton.setOnMouseExited(clickearCartaEventHandler);

            this.manoJugador1.getItems().add(cartaBoton);
            manoJugador1Box.getChildren().add(cartaBoton);
        }

        for(Carta carta: manoJugador2){
            Button cartaBoton = new Button();
            Image image = new Image("Imagenes/"+carta.getNombreCarta()+".png");
            ImageView imagenCarta = new ImageView(image);
            imagenCarta.setFitHeight(140);
            imagenCarta.setFitWidth(90);
            cartaBoton.setGraphic(imagenCarta);
            cartaBoton.setMaxSize(94,144);

//            ClickearCartaEventHandler clickearCartaEventHandler = new ClickearCartaEventHandler(cartaBoton);
//            cartaBoton.setOnMouseExited(clickearCartaEventHandler);

            this.manoJugador2.getItems().add(cartaBoton);
            manoJugador2Box.getChildren().add(cartaBoton);
        }

        manoJugador1Box.setLayoutY(0);
        manoJugador1Box.setLayoutX(460);
        manoJugador1Box.setMaxSize(180,167);
        manoJugador2Box.setLayoutY(900);
        manoJugador2Box.setLayoutX(460);
        manoJugador2Box.setMaxSize(180,167);

        this.getChildren().addAll(manoJugador1Box,manoJugador2Box);
    }

}
