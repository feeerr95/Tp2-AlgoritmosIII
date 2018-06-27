package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TableroVista extends Pane {

    private Controlador controlador;
    private HBox campoAtaqueJugador2;
    private HBox campoAtaqueJugador1;
    private HBox campoDefensaJugador2;
    private HBox campoDefensaJugador1;

    public TableroVista(Controlador controlador){
        this.controlador = controlador;
        this.setLayoutX(361);
        this.setLayoutY(108);
        this.setMinSize(677,696);


        campoAtaqueJugador2 = new HBox();
        campoAtaqueJugador2.setLayoutX(20);
        campoAtaqueJugador2.setLayoutY(415);
        campoAtaqueJugador2.setMinSize(662,157);
        campoAtaqueJugador2.setSpacing(25);

        campoAtaqueJugador1 = new HBox();
        campoAtaqueJugador1.setLayoutX(20);
        campoAtaqueJugador1.setLayoutY(225);
        campoAtaqueJugador1.setMinSize(662,157);
        campoAtaqueJugador1.setSpacing(25);

        campoDefensaJugador2 = new HBox();
        campoDefensaJugador2.setLayoutX(20);
        campoDefensaJugador2.setLayoutY(512);
        campoDefensaJugador2.setMinSize(662,157);
        campoDefensaJugador2.setSpacing(25);

        campoDefensaJugador1 = new HBox();
        campoDefensaJugador1.setLayoutX(20);
        campoDefensaJugador1.setLayoutY(0);
        campoDefensaJugador1.setMinSize(662,157);
        campoDefensaJugador1.setSpacing(25);

        this.getChildren().addAll(campoAtaqueJugador1, campoAtaqueJugador2, campoDefensaJugador1, campoDefensaJugador2);
    }

    public void agregarCartaMonstruoJ1(Button carta){
        campoAtaqueJugador1.getChildren().add(carta);
    }
    public void agregarCartaMonstruoJ2(Button carta){
        campoAtaqueJugador2.getChildren().add(carta);
    }
    public void agregarCartaEfectoJ1(Button carta){
        campoDefensaJugador1.getChildren().add(carta);
    }
    public void agregarCartaEfectoJ2(Button carta){
        campoDefensaJugador2.getChildren().add(carta);
    }



}
