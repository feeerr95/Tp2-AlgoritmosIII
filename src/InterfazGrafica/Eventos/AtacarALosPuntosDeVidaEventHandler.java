package InterfazGrafica.Eventos;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Vista.CartaBoton;
import fiuba.algo3.tp2.CartaMonstruo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AtacarALosPuntosDeVidaEventHandler implements EventHandler<MouseEvent> {

    private Controlador controlador;
    private CartaBoton cartaAtacanteBoton;
    private Stage ventanaAtacar;


    public AtacarALosPuntosDeVidaEventHandler(Stage ventanaAtacar, Controlador controlador, CartaBoton cartaAtacanteBoton){
        this.controlador = controlador;
        this.cartaAtacanteBoton = cartaAtacanteBoton;
        this.ventanaAtacar = ventanaAtacar;

    }

    @Override
    public void handle(MouseEvent event) {
        controlador.atacarPuntosDeVidaEnemigo((CartaMonstruo) cartaAtacanteBoton.getCarta());
        controlador.actualizarPuntosDeVida();
        ventanaAtacar.close();
    }
}
