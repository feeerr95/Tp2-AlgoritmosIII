package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.VentanaQueHacer;
import javafx.scene.input.MouseEvent;

public class ClickearCartaTrampaEventHandler extends ClickearCartaEventHandler{

    public ClickearCartaTrampaEventHandler(CartaBoton cartaBoton, Controlador controlador) {
        super(cartaBoton, controlador);
    }

    @Override
    public void handle(MouseEvent event) {
        VentanaQueHacer ventanaQueHacer = new VentanaQueHacer("Trampa", controlador, cartaBoton);
        ventanaQueHacer.show();
    }
}
