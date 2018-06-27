package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.PosicionAtaqueBotonEventHandler;
import InterfazGrafica.Eventos.PosicionDefensaBotonEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VentanaPosicionAColocar extends Stage {

    private Controlador controlador;
    private CartaBoton cartaBoton;
    private HBox layout;
    private Scene escena;

    public VentanaPosicionAColocar(Controlador controlador, CartaBoton cartaBoton) {
            this.controlador = controlador;
            this.cartaBoton = cartaBoton;
            this.centerOnScreen();
            layout = new HBox();
            escena = new Scene(layout);
            layout.setPrefSize(300,100);
            this.setScene(escena);
            this.setBotonera();
    }

    private void setBotonera(){
        Button posicionAtaqueBoton = new Button("Poscicion de Ataque");
        Button posicionDefensaBoton = new Button("Posicion de Defensa");


        PosicionAtaqueBotonEventHandler posicionAtaqueBotonEventHandler = new PosicionAtaqueBotonEventHandler(this, controlador, cartaBoton);
        posicionAtaqueBoton.setOnMouseClicked(posicionAtaqueBotonEventHandler);

        PosicionDefensaBotonEventHandler posicionDefensaBotonEventHandler = new PosicionDefensaBotonEventHandler(this, controlador, cartaBoton);
        posicionDefensaBoton.setOnMouseClicked(posicionDefensaBotonEventHandler);


        layout.getChildren().addAll(posicionAtaqueBoton,posicionDefensaBoton);
    }
}


