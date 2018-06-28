package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.VentanaQueHacer;
import javafx.scene.input.MouseEvent;

public class ClickearCartaMonstruoEventHandler extends ClickearCartaEventHandler {

    public ClickearCartaMonstruoEventHandler(CartaBoton cartaBoton, Controlador controlador) {
        super(cartaBoton, controlador);
    }

    @Override
    public void handle(MouseEvent event) {

        VentanaQueHacer ventanaQueHacer = new VentanaQueHacer("Monstruo", controlador, cartaBoton);
        ventanaQueHacer.show();
    }
}
