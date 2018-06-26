package InterfazGrafica.Eventos;

import InterfazGrafica.Vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ClickearCartaEventHandler implements EventHandler<MouseEvent> {

    Button carta;
    ContenedorPrincipal contenedorPrincipal;

    public ClickearCartaEventHandler(Button carta){
        this.carta = carta;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(MouseEvent event) {
        carta.setScaleX(2);
        carta.setScaleY(2);
    }
}
