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
    Stage stage;

    public ColocarBotonEventHandler(Stage stage, String tipoDeBoton, Controlador controlador, CartaBoton cartaBoton){
        this.cartaBoton = cartaBoton;
        this.tipoDeBoton = tipoDeBoton;
        this.controlador = controlador;
        this.stage = stage;
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

        stage.close();
    }

    private void comoColocarCarta(){
        VentanaPosicionAColocar ventanaPosicionAColocar = new VentanaPosicionAColocar( controlador, cartaBoton);
        ventanaPosicionAColocar.show();
    }
}
