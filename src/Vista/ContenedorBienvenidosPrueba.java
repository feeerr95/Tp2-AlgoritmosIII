package Vista;

import Vista.Eventos.BotonEntrarEventHandlerPrueba;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenidosPrueba extends VBox{

    Stage stage;
    Stage proximaVentana;

    public ContenedorBienvenidosPrueba(Stage stage, Stage proximaVentana){

        stage.setTitle("Al-Go-Oh!");
        this.stage = stage;  //Es la ventana
        this.proximaVentana = proximaVentana;
        this.setPreferencias();
        this.setBotonera();
        this.comenzarJuego();
    }

    private void setBotonera(){

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");
        BotonEntrarEventHandlerPrueba botonEntrarHandler = new BotonEntrarEventHandlerPrueba(stage, proximaVentana);
        botonEntrar.setOnAction(botonEntrarHandler);
        this.getChildren().add(botonEntrar);
    }

    public void comenzarJuego(){

        Label nombreJugador1Label = new Label("Nombre del jugador 1: ");
        this.modificarLetraDeLabel(nombreJugador1Label,14);
        TextField textField1 = new TextField ();
        HBox nombreJugador1Box = new HBox();
        nombreJugador1Box.setStyle("-fx-background-color: rgba(0,0,0,0.6);");
        nombreJugador1Box.getChildren().addAll(nombreJugador1Label, textField1);
        nombreJugador1Box.setSpacing(10);

        Label nombreJugador2Label = new Label("Nombre del jugador 2: ");
        this.modificarLetraDeLabel(nombreJugador2Label,14);
        TextField textField2 = new TextField ();
        HBox nombreJugador2Box = new HBox();
        nombreJugador2Box.setStyle("-fx-background-color: rgba(0,0,0,0.6);");
        nombreJugador2Box.getChildren().addAll(nombreJugador2Label, textField2);
        nombreJugador2Box.setSpacing(10);

        this.getChildren().addAll(nombreJugador1Box, nombreJugador2Box);

    }

    private void modificarLetraDeLabel(Label label, int size){
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, size));
        label.setTextFill(Color.web("FFFFFF"));
    }


    private void setPreferencias(){

        Image imagenFondo = new Image("Imagenes/Fondo bienvenido.jpg");
        BackgroundImage imagen = new BackgroundImage(imagenFondo,null,null,null,null);
        Background fondo = new Background(imagen);
        this.setBackground(fondo);

        stage.setWidth(imagenFondo.getWidth());
        stage.setHeight(imagenFondo.getHeight());

        System.out.println(imagenFondo.getWidth());
        System.out.println(imagenFondo.getHeight());
        stage.setResizable(false);
    }
}
