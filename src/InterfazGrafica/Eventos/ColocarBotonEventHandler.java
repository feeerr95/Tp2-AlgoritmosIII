package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import InterfazGrafica.Vista.VentanaPosicionAColocar;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ColocarBotonEventHandler implements EventHandler<MouseEvent> {

    String tipoDeBoton;
    Controlador controlador;
    CartaBoton cartaBoton;
    Stage ventanaQueHacer;

    public ColocarBotonEventHandler(Stage ventanaQueHacer, String tipoDeBoton, Controlador controlador, CartaBoton cartaBoton){
        this.cartaBoton = cartaBoton;
        this.tipoDeBoton = tipoDeBoton;
        this.controlador = controlador;
        this.ventanaQueHacer = ventanaQueHacer;
    }


    @Override
    public void handle(MouseEvent event) {
        switch (tipoDeBoton){
            case "Terreno":
                controlador.colocarTerreno(cartaBoton);
                break;
            case "Monstruo":
                this.comoColocarCarta();
                break;
            case "Trampa":
                controlador.colocarCartaEfecto(cartaBoton);
                break;
            case "Magica":
                controlador.colocarCartaEfecto(cartaBoton);
                break;
        }
        ventanaQueHacer.close();
    }

    private void comoColocarCarta(){
        VentanaPosicionAColocar ventanaPosicionAColocar = new VentanaPosicionAColocar( controlador, cartaBoton);
        ventanaPosicionAColocar.show();
    }
}
