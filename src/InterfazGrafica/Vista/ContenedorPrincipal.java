package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.EmpezarJuegoBotonEventHandler;
import InterfazGrafica.Eventos.TerminarTurnoBotonEventHandler;
import fiuba.algo3.tp2.Carta;
import javafx.scene.Node;
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
import java.util.ArrayList;
import java.util.HashMap;

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
    private TableroVista tableroVista;
    private ScrollPane sp1;
    private ScrollPane sp2;

    private Label puntosJ1Label;
    private Label puntosJ2Label;

    private HashMap<Carta, CartaBoton> cartasEnJuego;


    public ContenedorPrincipal(Stage stage, Controlador controlador){

        Image imagenFondo = new Image("Imagenes/Tablero.png");
        BackgroundImage imagen = new BackgroundImage(imagenFondo,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        this.controlador = controlador;


        puntosJ1Label = new Label();
        puntosJ2Label = new Label();

        cantCartasMazo1 = new Label();
        cantCartasMazo1 = new Label();

        manoJugador1Box = new HBox();
        manoJugador2Box = new HBox();

        sp1 = new ScrollPane();
        sp2 = new ScrollPane();

        cartasEnJuego = new HashMap<>();

        cartasManoJ1 = new ArrayList<>();
        cartasManoJ2 = new ArrayList<>();

        listaDeCartasBotonesJ1 = new ArrayList<>();
        listaDeCartasBotonesJ2 = new ArrayList<>();

        tableroVista = new TableroVista();

        Background fondo = new Background(imagen);
        this.setBackground(fondo);

        Button empezarJuegoBoton = new Button("Empezar Juego");
        empezarJuegoBoton.setLayoutX(80);
        empezarJuegoBoton.setLayoutY(400);
        EmpezarJuegoBotonEventHandler empezarJuegoBotonEventHandler = new EmpezarJuegoBotonEventHandler(controlador, empezarJuegoBoton);
        empezarJuegoBoton.setOnAction(empezarJuegoBotonEventHandler);
        this.getChildren().addAll(empezarJuegoBoton,tableroVista,puntosJ1Label,puntosJ2Label);

    }

    public void actualizarManos(ArrayList<Carta> cartasManoJ1, ArrayList<Carta> cartasManoJ2){
        this.cartasManoJ1 = cartasManoJ1;
        this.cartasManoJ2 = cartasManoJ2;
        this.dibujarManos(cartasManoJ1,cartasManoJ2);
    }

    private void dibujarManos(ArrayList<Carta> manoJugador1, ArrayList<Carta> manoJugador2){

        manoJugador1Box.getChildren().clear();
        manoJugador2Box.getChildren().clear();

        for(Carta carta: manoJugador1){
            CartaBoton cartaBoton = new CartaBoton(carta,controlador);
            listaDeCartasBotonesJ1.add(cartaBoton);
            this.manoJugador1.getItems().add(cartaBoton.getBoton());
            manoJugador1Box.getChildren().add(cartaBoton.getBoton());
        }

        for(Carta carta: manoJugador2){
            CartaBoton cartaBoton = new CartaBoton(carta,controlador);
            listaDeCartasBotonesJ2.add(cartaBoton);
            this.manoJugador2.getItems().add(cartaBoton.getBoton());
            manoJugador2Box.getChildren().add(cartaBoton.getBoton());
        }
    }

    public void actualizarPuntosDeVida(Integer puntosJ1, Integer puntosJ2){

        puntosJ1Label.setText(puntosJ1.toString());
        puntosJ1Label.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        puntosJ1Label.setTextFill(Color.web("FFFFFF"));

        puntosJ1Label.setLayoutX(100);
        puntosJ1Label.setLayoutY(150);

        puntosJ2Label.setText(puntosJ2.toString());
        puntosJ2Label.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        puntosJ2Label.setTextFill(Color.web("FFFFFF"));
        puntosJ2Label.setLayoutX(100);
        puntosJ2Label.setLayoutY(250);
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

         Label J1 = new Label("Jugador N°1");
         Label J2 = new Label("Jugador N°2");

         J1.setLayoutX(60);
         J1.setLayoutY(135);
         J1.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
         J1.setTextFill(Color.web("FFFFFF"));

         J2.setLayoutX(60);
         J2.setLayoutY(235);
         J2.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
         J2.setTextFill(Color.web("FFFFFF"));

        controlador.actualizarCantMazos();

        Button terminarTurnoBoton = new Button("Terminar Turno");
        terminarTurnoBoton.setLayoutX(80);
        terminarTurnoBoton.setLayoutY(400);
        TerminarTurnoBotonEventHandler terminarTurnoBotonEventHandler = new TerminarTurnoBotonEventHandler(controlador);
        terminarTurnoBoton.setOnMouseClicked(terminarTurnoBotonEventHandler);

         sp1.setContent(manoJugador1Box);
         sp1.setLayoutX(460);
         sp1.setLayoutY(0);
         sp1.setMaxSize(565,400);

         sp2.setContent(manoJugador2Box);
         sp2.setLayoutX(460);
         sp2.setLayoutY(860);
         sp2.setMaxSize(565,400);
         this.cancelarManoJ2();

        this.getChildren().addAll(terminarTurnoBoton, imagenMazo1, imagenMazo2,sp1,sp2,J1,J2);
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

    public void cancelarManoJ1(){
        for(Node carta: manoJugador1Box.getChildren()){
            this.darVueltaCarta((Button)carta);
            carta.setDisable(true);
        }
        for(Node carta: manoJugador2Box.getChildren()){
            carta.setDisable(false);
        }
    }

    public void cancelarManoJ2(){
        for(Node carta: manoJugador1Box.getChildren()){
            carta.setDisable(false);
        }
        for(Node carta: manoJugador2Box.getChildren()){
            this.darVueltaCarta((Button)carta);
            carta.setDisable(true);
        }
    }

    public void darVueltaCarta(Button carta){
        Image image = new Image("Imagenes/Carta Boca Abajo.png");
        ImageView imagenCarta = new ImageView(image);
        imagenCarta.setFitHeight(140);
        imagenCarta.setFitWidth(90);
        carta.setGraphic(imagenCarta);
        carta.setMinSize(94,160);
    }

    public void colocarMonstruo(CartaBoton cartaBoton, String posicionCarta, String caraCarta){
        cartaBoton.actualizarVista(posicionCarta,caraCarta);
        Button cartaJugada = cartaBoton.getBoton();
        cartasEnJuego.put(cartaBoton.getCarta(), cartaBoton);

        if(manoJugador1Box.getChildren().contains(cartaJugada)){
            manoJugador1Box.getChildren().remove(cartaJugada);
            tableroVista.agregarCartaMonstruoJ1(cartaJugada, cartaBoton);
        }
        else{
            manoJugador2Box.getChildren().remove(cartaJugada);
            tableroVista.agregarCartaMonstruoJ2(cartaJugada, cartaBoton);
        }
    }

    public void colocarTerreno(CartaBoton cartaBoton, String posicionCarta, String caraCarta){

        cartaBoton.actualizarVista(posicionCarta,caraCarta);
        Button cartaJugada = cartaBoton.getBoton();
        cartasEnJuego.put(cartaBoton.getCarta(), cartaBoton);

        if(manoJugador1Box.getChildren().contains(cartaJugada)){
            manoJugador1Box.getChildren().remove(cartaJugada);
            tableroVista.agregarCartaTerrenoJ1(cartaJugada, cartaBoton);
        }
        else{
            manoJugador2Box.getChildren().remove(cartaJugada);
            tableroVista.agregarCartaTerrenoJ2(cartaJugada, cartaBoton);
        }
    }



    public void colocarCartaEfecto(CartaBoton cartaBoton, String posicionCarta, String caraCarta){

        cartaBoton.actualizarVista(posicionCarta,caraCarta);
        Button cartaJugada = cartaBoton.getBoton();
        cartasEnJuego.put(cartaBoton.getCarta(), cartaBoton);

        if(manoJugador1Box.getChildren().contains(cartaJugada)){
            manoJugador1Box.getChildren().remove(cartaJugada);
            tableroVista.agregarCartaEfectoJ1(cartaJugada, cartaBoton);
        }
        else{
            manoJugador2Box.getChildren().remove(cartaJugada);
            tableroVista.agregarCartaEfectoJ2(cartaJugada, cartaBoton);
        }
    }

    public void eliminarCartasDestruidas(ArrayList<Carta> cartasJ1, ArrayList<Carta> cartasJ2){

        ArrayList<CartaBoton> cartasAEliminar = new ArrayList<>();

        for(Carta carta: cartasJ1){
            cartasAEliminar.add(cartasEnJuego.get(carta));
            cartasEnJuego.remove(carta);
        }
        for(Carta carta: cartasJ2){
            cartasAEliminar.add(cartasEnJuego.get(carta));
            cartasEnJuego.remove(carta);
        }

        tableroVista.elminarCartasDestruidas(cartasAEliminar);
    }

    public ArrayList<CartaBoton> obtenerMonstruosJ2(){
        return tableroVista.obtenerMonstruosJ2();
    }

    public ArrayList<CartaBoton> obtenerMonstruosJ1(){
        return tableroVista.obtenerMonstruosJ1();
    }


}
