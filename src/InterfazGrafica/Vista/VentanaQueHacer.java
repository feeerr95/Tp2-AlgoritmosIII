package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.AtacarMonstruoBotonEventHandler;
import InterfazGrafica.Eventos.CambiarPosicionBotonEventHandler;
import InterfazGrafica.Eventos.ColocarBotonEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VentanaQueHacer extends Stage {

    private VBox layout;
    private Scene escena;
    private String tipoDeCarta;
    private Controlador controlador;
    private CartaBoton cartaBoton;

    public VentanaQueHacer(String tipoDeCarta, Controlador controlador, CartaBoton cartaBoton){
        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.centerOnScreen();
        layout = new VBox();
//------------------------------------------------------------------------------------------------
        Image imagenCarta = new Image("Imagenes/"+cartaBoton.getCarta().getNombreCarta()+".png");
        BackgroundImage imagen = new BackgroundImage(imagenCarta,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background fondo = new Background(imagen);
        layout.setBackground(fondo);

        this.widthProperty().add(imagenCarta.getWidth());
        this.heightProperty().add(imagenCarta.getHeight());
//-------------------------------------------------------------------------------------------------
        escena = new Scene(layout);
        layout.setPrefSize(300,100);
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

        ColocarBotonEventHandler colocarBotonEventHandler = new ColocarBotonEventHandler(this, "Monstruo", controlador, cartaBoton);
        colocarBoton.setOnMouseClicked(colocarBotonEventHandler);

        CambiarPosicionBotonEventHandler cambiarPosicionBotonEventHandler = new CambiarPosicionBotonEventHandler(this, controlador, cartaBoton);
        cambiarPosicionBoton.setOnMouseClicked(cambiarPosicionBotonEventHandler);

        AtacarMonstruoBotonEventHandler atacarMonstruoBotonEventHandler = new AtacarMonstruoBotonEventHandler(this, controlador, cartaBoton);
        atacarMonstruoBoton.setOnMouseClicked(atacarMonstruoBotonEventHandler);


        layout.getChildren().addAll(colocarBoton, usarEfectoBoton, atacarMonstruoBoton, cambiarPosicionBoton);
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
