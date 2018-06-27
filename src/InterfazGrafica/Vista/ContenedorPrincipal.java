package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.BotonEmpezarJuegoEventHandler;
import InterfazGrafica.Eventos.BotonTerminarTurnoEventHandler;
import fiuba.algo3.tp2.Carta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class ContenedorPrincipal extends AnchorPane {

    private ArrayList<Carta> cartasManoJ1;
    private ArrayList<Carta> cartasManoJ2;

    private Label cantCartasMazo1;
    private Label cantCartasMazo2;

    private ListView<Button> manoJugador1 = new ListView<>();
    private ListView<Button> manoJugador2 = new ListView<>();
    private Controlador controlador;
    private ArrayList<CartaBoton> listaDeCartasBotonesJ1;
    private ArrayList<CartaBoton> listaDeCartasBotonesJ2;
    private HBox manoJugador1Box;
    private HBox manoJugador2Box;


    public ContenedorPrincipal(Stage stage,Controlador controlador){

        Image imagenFondo = new Image("Imagenes/Tablero.jpg");
        BackgroundImage imagen = new BackgroundImage(imagenFondo,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.controlador = controlador;

        cantCartasMazo1 = new Label();
        cantCartasMazo1 = new Label();


        manoJugador1Box = new HBox();
        manoJugador2Box = new HBox();

        cartasManoJ1 = new ArrayList<>();
        cartasManoJ2 = new ArrayList<>();

        listaDeCartasBotonesJ1 = new ArrayList<>();
        listaDeCartasBotonesJ2 = new ArrayList<>();


        Background fondo = new Background(imagen);
        this.setBackground(fondo);

        Button empezarJuegoBoton = new Button("Empezar Juego");
        empezarJuegoBoton.setLayoutX(80);
        empezarJuegoBoton.setLayoutY(400);
        BotonEmpezarJuegoEventHandler botonEmpezarJuegoEventHandler = new BotonEmpezarJuegoEventHandler(controlador, empezarJuegoBoton);
        empezarJuegoBoton.setOnAction(botonEmpezarJuegoEventHandler);
        this.getChildren().add(empezarJuegoBoton);

    }

    public void actualizarManos(ArrayList<Carta> cartasManoJ1, ArrayList<Carta> cartasManoJ2){
        this.cartasManoJ1 = cartasManoJ1;
        this.cartasManoJ2 = cartasManoJ2;
        this.dibujarManos(cartasManoJ1,cartasManoJ2);
    }

    public ArrayList<Carta> getManoJugador1Cartas() {
        return cartasManoJ1;
    }

    private void dibujarManos(ArrayList<Carta> manoJugador1, ArrayList<Carta> manoJugador2){

        this.manoJugador1Box.getChildren().clear();
        this.manoJugador2Box.getChildren().clear();

        manoJugador1Box = new HBox();
        manoJugador2Box = new HBox();

        ScrollPane sp1 = new ScrollPane();
        sp1.setContent(manoJugador1Box);
        sp1.setMaxSize(565,400);

        sp1.setLayoutX(460);
        sp1.setLayoutY(0);

        ScrollPane sp2 = new ScrollPane();
        sp2.setContent(manoJugador2Box);

        sp2.setLayoutX(460);
        sp2.setLayoutY(860);
        sp2.setMaxSize(565,400);

        for(Carta carta: manoJugador1){
            CartaBoton cartaBoton = new CartaBoton(carta,controlador);
            listaDeCartasBotonesJ1.add(cartaBoton);
            this.manoJugador1.getItems().add(cartaBoton.obtenerBoton());
            manoJugador1Box.getChildren().add(cartaBoton.obtenerBoton());

        }

        for(Carta carta: manoJugador2){
            CartaBoton cartaBoton = new CartaBoton(carta,controlador);
            listaDeCartasBotonesJ2.add(cartaBoton);
            this.manoJugador2.getItems().add(cartaBoton.obtenerBoton());
            manoJugador2Box.getChildren().add(cartaBoton.obtenerBoton());
        }

        this.getChildren().addAll(sp1,sp2);
    }

    public void actualizarPuntosDeVida(Integer puntosJ1, Integer puntosJ2){
        Label puntosJ1Label = new Label(puntosJ1.toString());
        puntosJ1Label.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        puntosJ1Label.setTextFill(Color.web("FFFFFF"));

        puntosJ1Label.setLayoutX(60);
        puntosJ1Label.setLayoutY(150);

        Label puntosJ2Label = new Label(puntosJ2.toString());
        puntosJ2Label.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        puntosJ2Label.setTextFill(Color.web("FFFFFF"));
        puntosJ2Label.setLayoutX(60);
        puntosJ2Label.setLayoutY(250);
        this.getChildren().addAll(puntosJ1Label,puntosJ2Label);
    }

     public void setInicioJuego() {

        Image mazo2 = new Image("Imagenes/Mazo.png");
        ImageView imagenMazo2 = new ImageView(mazo2);
        imagenMazo2.setFitWidth(110);
        imagenMazo2.setFitHeight(150);
        imagenMazo2.setLayoutX(1045);
        imagenMazo2.setLayoutY(690);

        Image mazo1 = new Image("Imagenes/Mazo.png");
        ImageView imagenMazo1 = new ImageView(mazo1);
        imagenMazo1.setFitWidth(110);
        imagenMazo1.setFitHeight(150);
        imagenMazo1.setLayoutX(1045);
        imagenMazo1.setLayoutY(168);

        controlador.actualizarCantMazos();

        Button terminarTurnoBoton = new Button("Terminar Turno");
        terminarTurnoBoton.setLayoutX(80);
        terminarTurnoBoton.setLayoutY(400);
        BotonTerminarTurnoEventHandler botonTerminarTurnoEventHandler = new BotonTerminarTurnoEventHandler(controlador);
        terminarTurnoBoton.setOnMouseClicked(botonTerminarTurnoEventHandler);

        this.getChildren().addAll(terminarTurnoBoton, imagenMazo1, imagenMazo2);
     }

     public void actualizarLabelsMazo(Integer cantidadCartasMazo1, Integer cantidadCartasMazo2){

        this.getChildren().removeAll(this.cantCartasMazo1, this.cantCartasMazo2);

         cantCartasMazo1 = new Label(cantidadCartasMazo1.toString());
         cantCartasMazo2 = new Label(cantidadCartasMazo2.toString());
         cantCartasMazo1.setLayoutX(1077);
         cantCartasMazo1.setLayoutY(199);
         cantCartasMazo2.setLayoutX(1077);
         cantCartasMazo2.setLayoutY(738);
         cantCartasMazo1.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
         cantCartasMazo1.setTextFill(Color.web("FFFFFF"));
         cantCartasMazo2.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
         cantCartasMazo2.setTextFill(Color.web("FFFFFF"));
         cantCartasMazo1.toFront();
         cantCartasMazo2.toFront();


         this.getChildren().addAll(cantCartasMazo1,cantCartasMazo2);


     }
}
