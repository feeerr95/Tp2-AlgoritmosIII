package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.*;
import excepciones.NoHayMonstruosEnCampo;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaQueHacer extends Stage {

    private VBox layout;
    private Scene escena;
    private String tipoDeCarta;
    private Controlador controlador;
    private CartaBoton cartaBoton;
    private int ancho;
    private int alto;

    public VentanaQueHacer(String tipoDeCarta, Controlador controlador, CartaBoton cartaBoton){

        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.centerOnScreen();
        layout = new VBox();

        this.setResizable(false);
        ancho = 280;
        alto = 420;
        Image imagen;
        if(cartaBoton.getCarta().estaDestruida()){
            imagen = new Image("Imagenes/Carta Destruida.png");
        }
        else{
            imagen = new Image("Imagenes/"+cartaBoton.getCarta().getNombreCarta()+".png");
        }
        layout.setPrefSize(ancho,alto);
        BackgroundImage fondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(ancho,alto,false,false,false, false));
        Background background = new Background(fondo);
        layout.setBackground(background);


        escena = new Scene(layout);
        this.setScene(escena);
        this.tipoDeCarta = tipoDeCarta;
        this.setBotonera();
    }

    private void setBotonera(){

        switch(tipoDeCarta){
            case "Terreno":
                this.setBotonesTerreno();
                break;
            case "Monstruo":
                this.setBotonesMonstruo();
                break;
            case "Magica":
                this.setBotonesMagica();
                break;
            case "Trampa":
                this.setBotonesTrampa();
                break;
        }
    }

    private void setBotonesTerreno(){
        Button colocarBoton = new Button("Colocar");
        ColocarBotonEventHandler colocarBotonEventHandler = new ColocarBotonEventHandler(this,"Terreno", controlador, cartaBoton);
        colocarBoton.setOnMouseClicked(colocarBotonEventHandler);

        layout.getChildren().add(colocarBoton);
    }
    private void setBotonesMonstruo(){
        Button colocarBoton = new Button("Colocar");
        Button atacarMonstruoBoton = new Button("Atacar Monstruo");
        Button usarEfectoBoton = new Button("Usar Efecto");
        Button cambiarPosicionBoton = new Button("Cambiar Posicion");
        Button darVueltaBoton = new Button("Dar Vuelta");

        if(controlador.estaEnJuego(cartaBoton.getCarta())){
            colocarBoton.setDisable(true);
            if(!cartaBoton.getCarta().estaBocaAbajo()){
                darVueltaBoton.setDisable(true);
            }
        }
        else{
            darVueltaBoton.setDisable(true);
            atacarMonstruoBoton.setDisable(true);
            usarEfectoBoton.setDisable(true);
            cambiarPosicionBoton.setDisable(true);
        }
        if(cartaBoton.getCarta().estaDestruida()){
            darVueltaBoton.setDisable(true);
            atacarMonstruoBoton.setDisable(true);
            usarEfectoBoton.setDisable(true);
            cambiarPosicionBoton.setDisable(true);
            colocarBoton.setDisable(true);
        }

        UsarEfectoBotonHandler usarEfectoBotonHandler = new UsarEfectoBotonHandler(this, controlador, cartaBoton);
        usarEfectoBoton.setOnMouseClicked(usarEfectoBotonHandler);

        ColocarBotonEventHandler colocarBotonEventHandler = new ColocarBotonEventHandler(this, "Monstruo", controlador, cartaBoton);
        colocarBoton.setOnMouseClicked(colocarBotonEventHandler);

        CambiarPosicionBotonEventHandler cambiarPosicionBotonEventHandler = new CambiarPosicionBotonEventHandler(this, controlador, cartaBoton);
        cambiarPosicionBoton.setOnMouseClicked(cambiarPosicionBotonEventHandler);

        AtacarMonstruoBotonEventHandler atacarMonstruoBotonEventHandler = new AtacarMonstruoBotonEventHandler(this, controlador, cartaBoton);
        atacarMonstruoBoton.setOnMouseClicked(atacarMonstruoBotonEventHandler);

        DarVueltaBotonEventHandler darVueltaBotonEventHandler = new DarVueltaBotonEventHandler(this, controlador, cartaBoton);
        darVueltaBoton.setOnMouseClicked(darVueltaBotonEventHandler);

        layout.getChildren().addAll(colocarBoton, usarEfectoBoton, atacarMonstruoBoton, cambiarPosicionBoton, darVueltaBoton);
    }
    private void setBotonesMagica(){
        Button colocarBoton = new Button("Colocar");
        Button usarEfectoBoton = new Button("Usar Efecto");
        layout.getChildren().addAll(colocarBoton, usarEfectoBoton);

        ColocarBotonEventHandler colocarBotonEventHandler = new ColocarBotonEventHandler(this, "Magica", controlador, cartaBoton);
        colocarBoton.setOnMouseClicked(colocarBotonEventHandler);
    }
    private void setBotonesTrampa(){
        Button colocarBoton = new Button("Colocar");
        layout.getChildren().add(colocarBoton);

        ColocarBotonEventHandler colocarBotonEventHandler = new ColocarBotonEventHandler(this, "Trampa", controlador, cartaBoton);
        colocarBoton.setOnMouseClicked(colocarBotonEventHandler);
    }
}
