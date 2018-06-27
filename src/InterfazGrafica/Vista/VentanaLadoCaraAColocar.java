package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.BocaAbajoBotonEventHandler;
import InterfazGrafica.Eventos.BocaArribaBotonEventHandler;
import fiuba.algo3.tp2.PosicionCarta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VentanaLadoCaraAColocar extends Stage {

    private Controlador controlador;
    private CartaBoton cartaBoton;
    private PosicionCarta posicionCarta;
    private Scene escena;
    private HBox layout;

    public VentanaLadoCaraAColocar(Controlador controlador, CartaBoton cartaBoton, PosicionCarta posicionCarta) {

        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.centerOnScreen();
        this.posicionCarta = posicionCarta;
        layout = new HBox();
        escena = new Scene(layout);
        layout.setPrefSize(300,100);
        this.setScene(escena);
        this.setBotonera();
    }

    private void setBotonera(){
        Button bocaArribaBoton = new Button("Boca Arriba");
        Button bocaAbajoBoton = new Button("Boca Abajo");

        BocaAbajoBotonEventHandler bocaAbajoBotonEventHandler = new BocaAbajoBotonEventHandler(this,controlador,cartaBoton,posicionCarta);
        bocaAbajoBoton.setOnMouseClicked(bocaAbajoBotonEventHandler);

        BocaArribaBotonEventHandler bocaArribaBotonEventHandler = new BocaArribaBotonEventHandler(this, controlador, cartaBoton, posicionCarta);
        bocaArribaBoton.setOnMouseClicked(bocaArribaBotonEventHandler);

        layout.getChildren().addAll(bocaAbajoBoton,bocaArribaBoton);
    }
}
