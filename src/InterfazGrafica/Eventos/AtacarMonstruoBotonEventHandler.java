package InterfazGrafica.Eventos;


import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.VentanaAtacar;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AtacarMonstruoBotonEventHandler implements EventHandler<MouseEvent> {

    Controlador controlador;
    CartaBoton cartaBoton;
    Stage ventanaQueHacer;

    public AtacarMonstruoBotonEventHandler(Stage ventanaQueHacer, Controlador controlador, CartaBoton cartaBoton){
        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.ventanaQueHacer = ventanaQueHacer;
    }

    @Override
    public void handle(MouseEvent event) {
        VentanaAtacar ventanaAtacar = new VentanaAtacar(ventanaQueHacer,controlador, cartaBoton);
        ventanaAtacar.setHeight(200);
        ventanaAtacar.setWidth(608);
        ventanaAtacar.setResizable(false);
        ventanaAtacar.show();
    }
}
