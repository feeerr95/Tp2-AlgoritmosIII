package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import excepciones.InsuficienteEspacioEnCampo;
import excepciones.NoHayMonstruosEnCampo;
import fiuba.algo3.tp2.BocaAbajo;
import fiuba.algo3.tp2.CaraCarta;
import fiuba.algo3.tp2.PosicionCarta;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BocaAbajoBotonEventHandler implements EventHandler<MouseEvent> {

    private Controlador controlador;
    private CartaBoton cartaBoton;
    private PosicionCarta posicionCarta;
    private Stage ventanaLadoCaraAColocar;
    private CaraCarta cara;

    public BocaAbajoBotonEventHandler(Stage ventanaLadoCaraAColocar, Controlador controlador, CartaBoton cartaBoton, PosicionCarta posicionCarta){
        this.controlador = controlador;
        this.cartaBoton = cartaBoton;
        this.posicionCarta = posicionCarta;
        this.ventanaLadoCaraAColocar = ventanaLadoCaraAColocar;
        this.cara = new BocaAbajo();
    }

    @Override
    public void handle(MouseEvent event) {

        try{
            controlador.colocarCartaEnCampo(cartaBoton, posicionCarta, cara);
            controlador.colocarMonstruo(cartaBoton, posicionCarta.getPosicion(), cara.getCara());

        }catch(NoHayMonstruosEnCampo excepcion){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("No tiene los suficientes monstruos para convocar a este");
            alerta.showAndWait();
        }catch(InsuficienteEspacioEnCampo excepcion){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("No se pueden colocar mas cartas");
            alerta.showAndWait();
        }

        ventanaLadoCaraAColocar.close();
    }
}
