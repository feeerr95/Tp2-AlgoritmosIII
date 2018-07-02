package InterfazGrafica.Vista;


import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.*;
import fiuba.algo3.tp2.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CartaBoton {

    Carta carta;
    Controlador controlador;
    Button cartaBoton;
    String posicion;

    public CartaBoton(Carta carta, Controlador controlador){
        this.carta = carta;
        this.controlador = controlador;
        this.setCaracteristicas();
        this.tipoDeBoton();

    }

    private void tipoDeBoton(){
        if(carta instanceof CartaMonstruo){
            ClickearCartaMonstruoEventHandler clickearCartaMonstruoEventHandler = new ClickearCartaMonstruoEventHandler(this, controlador);
            cartaBoton.setOnMouseClicked(clickearCartaMonstruoEventHandler);
        }
        else if(carta instanceof CartaMagica){
            ClickearCartaMagicaEventHandler clickearCartaMagicaEventHandler = new ClickearCartaMagicaEventHandler(this, controlador);
            cartaBoton.setOnMouseClicked(clickearCartaMagicaEventHandler);
        }
        else if(carta instanceof CartaTrampa){
            ClickearCartaTrampaEventHandler clickearCartaTrampaEventHandler = new ClickearCartaTrampaEventHandler(this, controlador);
            cartaBoton.setOnMouseClicked(clickearCartaTrampaEventHandler);
        }
        else if(carta instanceof CartaTerreno){
            ClickearCartaTerrenoEventHandler clickearCartaTerrenoEventHandler = new ClickearCartaTerrenoEventHandler(this, controlador);
            cartaBoton.setOnMouseClicked(clickearCartaTerrenoEventHandler);
        }
    }
    private void setCaracteristicas(){
        cartaBoton = new Button();
        if(carta.estaEnElCampo() && carta.estaBocaAbajo()){
            this.vistaVerticalAbajo();
        }else {
            this.vistaVerticalArriba();
        }
        ClickearCartaEventHandler clickearCartaEventHandler = new ClickearCartaEventHandler(this, controlador);
        cartaBoton.setOnMouseClicked(clickearCartaEventHandler);
    }

    public Button getBoton(){
        return cartaBoton;
    }

    public Carta getCarta() {
        return carta;
    }

    public void actualizarVista(String posicionCarta, String caraCarta){
        this.posicion = posicionCarta;

        if (posicionCarta.equals("Horizontal") && caraCarta.equals("Abajo")){
            this.vistaHorizontalAbajo();
        }
        else if(posicionCarta.equals("Horizontal") && caraCarta.equals("Arriba")){
            this.vistaHorizontalArriba();
        }
        else if(posicionCarta.equals("Vertical") && caraCarta.equals("Abajo")){
            this.vistaVerticalAbajo();
        }
        else if(posicionCarta.equals("Vertical") && caraCarta.equals("Arriba")){
            this.vistaVerticalArriba();
        }
    }

    private void vistaVerticalArriba(){
        Image image = new Image("Imagenes/"+carta.getNombreCarta()+".png");
        ImageView imagenCarta = new ImageView(image);
        imagenCarta.setFitHeight(140);
        imagenCarta.setFitWidth(90);
        cartaBoton.setGraphic(imagenCarta);
        cartaBoton.setMinSize(94,160);
    }
    private void vistaVerticalAbajo(){
        Image image = new Image("Imagenes/Carta Boca Abajo.png");
        ImageView imagenCarta = new ImageView(image);
        imagenCarta.setFitHeight(140);
        imagenCarta.setFitWidth(90);
        cartaBoton.setGraphic(imagenCarta);
        cartaBoton.setMinSize(94,160);
    }
    private void vistaHorizontalArriba(){
        Image image = new Image("Imagenes/"+carta.getNombreCarta()+".png");
        ImageView imagenCarta = new ImageView(image);
        imagenCarta.setRotate(90);
        imagenCarta.setFitHeight(140);
        imagenCarta.setFitWidth(90);
        cartaBoton.setGraphic(imagenCarta);
    }
    private void vistaHorizontalAbajo(){
        Image image = new Image("Imagenes/Carta Boca Abajo.png");
        ImageView imagenCarta = new ImageView(image);
        imagenCarta.setRotate(90);
        imagenCarta.setFitHeight(140);
        imagenCarta.setFitWidth(90);
        cartaBoton.setGraphic(imagenCarta);
    }

    public void cambiarDePosicion(){
        ImageView imagen = (ImageView) cartaBoton.getGraphic();
        if(posicion.equals("Vertical")){
            posicion = "Horizontal";
            carta.cambiarPosicion(new PosicionHorizontal());
            imagen.setRotate(90);
        }
        else{
            posicion = "Vertical";
            carta.cambiarPosicion(new PosicionVertical());
            imagen.setRotate(0);
        }

    }

    public void darVuelta(){
        if(posicion.equals("Vertical")){
            carta.darVuelta();
            this.vistaVerticalArriba();
        }
        else{
            carta.darVuelta();
            this.vistaHorizontalArriba();
        }
    }
}