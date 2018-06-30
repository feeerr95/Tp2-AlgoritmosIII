package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import fiuba.algo3.tp2.CartaMonstruo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RecibirAtaqueEventHandler implements EventHandler<MouseEvent> {

    private Controlador controlador;
    private CartaBoton cartaBotonAtacante;
    private CartaBoton cartaBotonAtacado;
    private Stage ventanaAtacar;
    private Stage ventanaQueHacer;

    public RecibirAtaqueEventHandler(Stage ventanaAtacar, Controlador controlador, CartaBoton cartaBotonAtacado, CartaBoton cartaBotonAtacante, Stage ventanaQueHacer){
        this.controlador = controlador;
        this.cartaBotonAtacante = cartaBotonAtacante;
        this.cartaBotonAtacado = cartaBotonAtacado;
        this.ventanaAtacar = ventanaAtacar;
        this.ventanaQueHacer = ventanaQueHacer;
    }

    @Override
    public void handle(MouseEvent event) {
        controlador.realizarAtaque((CartaMonstruo)cartaBotonAtacado.getCarta(), (CartaMonstruo) cartaBotonAtacante.getCarta());
        controlador.actualizarPuntosDeVida();
        ventanaAtacar.close();
        ventanaQueHacer.close();
    }
}
