package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class VentanaAtacar implements MouseListener {
    private Controlador controlador;
    private CartaBoton cartaBoton;
    private HBox layout;
    private Scene escena;
    private Stage stage;

    public VentanaAtacar(Controlador controlador, CartaBoton cartaBoton) {

        this.stage = new Stage();
        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        stage.centerOnScreen();
        layout = new HBox();
        escena = new Scene(layout);
        layout.setPrefSize(300, 100);
        stage.setScene(escena);
        Label mensaje = new Label("Selecciona al monstruo que desea atacar");
        mensaje.setLayoutY(layout.getHeight() / 2);
        mensaje.setLayoutX(layout.getWidth() / 2);
        layout.getChildren().add(mensaje);
    }

    public void mostrar() {
        stage.show();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("hola");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
