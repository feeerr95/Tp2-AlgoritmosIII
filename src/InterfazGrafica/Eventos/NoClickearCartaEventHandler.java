package InterfazGrafica.Eventos;

import InterfazGrafica.Vista.ContenedorPrincipal;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

import java.util.List;

public class NoClickearCartaEventHandler implements EventHandler<MouseEvent> {

    Button carta;
    ContenedorPrincipal contenedorPrincipal;

    public NoClickearCartaEventHandler(Button carta) {
        this.carta = carta;
        this.contenedorPrincipal = contenedorPrincipal;
    }


    @Override
    public void handle(MouseEvent event) {
        carta.setScaleX(1);
        carta.setScaleY(1);
    }
}
