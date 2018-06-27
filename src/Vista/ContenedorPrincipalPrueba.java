package Vista;

import Vista.Eventos.BotonEmpezarEventHandlerPrueba;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPrincipalPrueba extends AnchorPane {

    BarraDeMenu menuBar;
    private Stage stage;

    public ContenedorPrincipalPrueba(Stage stage){
        stage.setTitle("Al-Go-Oh!");
        this.stage = stage;
        this.setMenu();
        this.setFondoTablero();
        this.setBotonera();
    }

    public void setBotonera(){
        Button botonEmpezar = new Button();
        botonEmpezar.setText("Empezar juego");
        botonEmpezar.setLayoutX(80);
        botonEmpezar.setLayoutY(400);
        BotonEmpezarEventHandlerPrueba botonEmpezarEventHandlerPrueba = new BotonEmpezarEventHandlerPrueba(this, botonEmpezar);
        botonEmpezar.setOnAction(botonEmpezarEventHandlerPrueba);
        this.getChildren().add(botonEmpezar);
    }

    public void iniciarJuego(){
        Label nombreJugador1 = new Label("Nombre del jugador N°1:");
        Label nombreJugador2 = new Label("Nombre del jugador N°2:");
        Label puntosDeVidaJ1 = new Label(" Cantidad de puntos de vida:");
        Label puntosDeVidaJ2 = new Label(" Cantidad de puntos de vida:");
        Label separacion = new Label("-----------------------------");
        Label puntosDeVidaJugador1Label = new Label("8000");
        Label puntosDeVidaJugador2Label = new Label("8000");

        this.crearMazo(1040,190);
        this.crearMazo(1040,750);

        modificarLetraDeLabel(puntosDeVidaJ1,12);
        ubicarEnPantalla(40,190,puntosDeVidaJ1);

        modificarLetraDeLabel(puntosDeVidaJ2,12);
        ubicarEnPantalla(40,300,puntosDeVidaJ2);

        modificarLetraDeLabel(separacion,14);
        ubicarEnPantalla(40,230,separacion);

        modificarLetraDeLabel(nombreJugador1,14);
        ubicarEnPantalla(40,140,nombreJugador1);

        modificarLetraDeLabel(nombreJugador2,14);
        ubicarEnPantalla(40,250,nombreJugador2);

        modificarLetraDeLabel(puntosDeVidaJugador1Label,14);
        ubicarEnPantalla(113, 210,puntosDeVidaJugador1Label);

        modificarLetraDeLabel(puntosDeVidaJugador2Label,14);
        ubicarEnPantalla(113,320,puntosDeVidaJugador2Label);



    }

    private void ubicarEnPantalla(int coordenadaX, int coordenadaY, Node nodo){
        nodo.setLayoutX(coordenadaX);
        nodo.setLayoutY(coordenadaY);
        this.getChildren().add(nodo);
    }

    private void modificarLetraDeLabel(Label label, int size){
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, size));
        label.setTextFill(Color.web("FFFFFF"));
    }

    private void setFondoTablero(){

        //Fondo de la ventana
        Image imagenFondo = new Image("Imagenes/Tablero.jpg");
        BackgroundImage imagen = new BackgroundImage(imagenFondo,
                                                    BackgroundRepeat.REPEAT,
                                                    BackgroundRepeat.REPEAT,
                                                    BackgroundPosition.DEFAULT,
                                                    BackgroundSize.DEFAULT);

        Background fondo = new Background(imagen);
        this.setBackground(fondo);

        stage.setWidth(imagenFondo.getWidth());
        System.out.println(imagenFondo.getWidth());
        System.out.println(imagenFondo.getHeight());
        stage.setHeight(imagenFondo.getHeight());
        stage.setResizable(false);
    }

    private void setMenu(){
        this.menuBar = new BarraDeMenu(stage);
        this.setTopAnchor(menuBar,0d);
        this.getChildren().add(menuBar);

    }

    private void crearCartaBocaAbajo(int coordenadaX, int coordenadaY){
        Image image = new Image("Imagenes/Carta Boca Abajo.png");
        Button carta = new Button();
        ImageView cartaBocaAbajo = new ImageView(image);

        cartaBocaAbajo.setFitHeight(140);
        cartaBocaAbajo.setFitWidth(90);

        carta.setGraphic(cartaBocaAbajo);
        carta.setMaxSize(94,144);

        this.ubicarEnPantalla(coordenadaX, coordenadaY, carta);
//        SalirEventHandler salir = new SalirEventHandler(stage);
//        carta.setOnAction(salir);
    }

    private void crearMazo(int coordenadaX, int coordenadaY){
        Image image = new Image("Imagenes/Mazo.png");
        Button mazo = new Button();
        ImageView cartaBocaAbajo = new ImageView(image);

        cartaBocaAbajo.setFitHeight(140);
        cartaBocaAbajo.setFitWidth(90);

        mazo.setGraphic(cartaBocaAbajo);
        mazo.setMaxSize(80,120);

        this.ubicarEnPantalla(coordenadaX,coordenadaY,mazo);
    }

    private void setearCartasDePrueba(){
        //defensa enemigo
        this.crearCartaBocaAbajo(379,170);
        this.crearCartaBocaAbajo(512,170);
        this.crearCartaBocaAbajo(647,170);
        this.crearCartaBocaAbajo(780,170);
        this.crearCartaBocaAbajo(914,170);

        //ataque enemigo
        this.crearCartaBocaAbajo(379,335);
        this.crearCartaBocaAbajo(512,335);
        this.crearCartaBocaAbajo(647,335);
        this.crearCartaBocaAbajo(780,335);
        this.crearCartaBocaAbajo(914,335);

        //ataque propio
        this.crearCartaBocaAbajo(379,518);
        this.crearCartaBocaAbajo(512,518);
        this.crearCartaBocaAbajo(647,518);
        this.crearCartaBocaAbajo(780,518);
        this.crearCartaBocaAbajo(914,518);

        //defensa propia
        this.crearCartaBocaAbajo(379,682);
        this.crearCartaBocaAbajo(512,682);
        this.crearCartaBocaAbajo(647,682);
        this.crearCartaBocaAbajo(780,682);
        this.crearCartaBocaAbajo(914,682);

        //-------------------------CAMPOS-------------------------------
        //campo enemigo
        this.crearCartaBocaAbajo(254,244);
        //campo propio
        this.crearCartaBocaAbajo(254,600);

        //------------------------CEMENTERIOS----------------------------
        //cementerio enemigo
        this.crearCartaBocaAbajo(1039,331);
        //cementerio propio
        this.crearCartaBocaAbajo(1039,519);

    }
}
