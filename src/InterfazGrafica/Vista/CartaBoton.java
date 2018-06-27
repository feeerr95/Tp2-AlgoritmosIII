package InterfazGrafica.Vista;


import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.ClickearCartaEventHandler;
import fiuba.algo3.tp2.Carta;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CartaBoton {

    Carta carta;
    Controlador controlador;
    Button cartaBoton;

    public CartaBoton(Carta carta, Controlador controlador){
        this.carta = carta;
        this.controlador = controlador;
        this.setCaracteristicas();
    }

    private void setCaracteristicas(){
        cartaBoton = new Button();
        Image image = new Image("Imagenes/"+carta.getNombreCarta()+".png");
        ImageView imagenCarta = new ImageView(image);
        imagenCarta.setFitHeight(140);
        imagenCarta.setFitWidth(90);
        ClickearCartaEventHandler clickearCartaEventHandler = new ClickearCartaEventHandler(this, controlador);
        cartaBoton.setOnMouseClicked(clickearCartaEventHandler);
        cartaBoton.setGraphic(imagenCarta);
        cartaBoton.setMinSize(94,160);
    }

    public Button obtenerBoton(){
        return cartaBoton;
    }

    public Carta getCarta() {
        return carta;
    }
}
