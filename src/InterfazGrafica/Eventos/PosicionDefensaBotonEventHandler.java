package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.VentanaLadoCaraAColocar;
import fiuba.algo3.tp2.PosicionCarta;
import fiuba.algo3.tp2.PosicionHorizontal;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PosicionDefensaBotonEventHandler implements EventHandler<MouseEvent> {

    private Controlador controlador;
    private CartaBoton cartaBoton;
    private Stage ventanaPosicionAColocar;
    private PosicionCarta posicion;

    public PosicionDefensaBotonEventHandler(Stage ventanaPosicionAColocar, Controlador controlador, CartaBoton cartaBoton){
        this.cartaBoton = cartaBoton;
        this.controlador = controlador;
        this.ventanaPosicionAColocar = ventanaPosicionAColocar;
        this.posicion = new PosicionHorizontal();
    }

    @Override
    public void handle(MouseEvent event) {
        VentanaLadoCaraAColocar ventanaLadoCaraAColocar = new VentanaLadoCaraAColocar(controlador, cartaBoton, posicion);
        ventanaPosicionAColocar.close();
        ventanaLadoCaraAColocar.show();
    }
}
