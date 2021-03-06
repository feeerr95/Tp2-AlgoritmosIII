package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class TableroVista extends Pane {


    private HBox campoAtaqueJ2;
    private HBox campoAtaqueJ1;
    private HBox campoDefensaJ2;
    private HBox campoDefensaJ1;
    private StackPane terrenoJ1;
    private StackPane terrenoJ2;
    private ArrayList<CartaBoton> monstruosJ1;
    private ArrayList<CartaBoton> monstruosJ2;

    private ArrayList<CartaBoton> listaDeTodasLasCartasJ1;
    private ArrayList<CartaBoton> listaDeTodasLasCartasJ2;

    public TableroVista(){
        this.setLayoutX(250);
        this.setLayoutY(108);
        this.setMinSize(792,696);

        listaDeTodasLasCartasJ1 = new ArrayList<>();
        listaDeTodasLasCartasJ2 = new ArrayList<>();
        monstruosJ1 = new ArrayList<>();
        monstruosJ2 = new ArrayList<>();
        campoAtaqueJ2 = new HBox();
        campoAtaqueJ2.setLayoutX(130);
        campoAtaqueJ2.setLayoutY(415);
        campoAtaqueJ2.setMinSize(662,157);
        campoAtaqueJ2.setSpacing(25);

        campoAtaqueJ1 = new HBox();
        campoAtaqueJ1.setLayoutX(130);
        campoAtaqueJ1.setLayoutY(225);
        campoAtaqueJ1.setMinSize(662,157);
        campoAtaqueJ1.setSpacing(25);

        campoDefensaJ2 = new HBox();
        campoDefensaJ2.setLayoutX(130);
        campoDefensaJ2.setLayoutY(576);
        campoDefensaJ2.setMinSize(662,157);
        campoDefensaJ2.setSpacing(25);

        campoDefensaJ1 = new HBox();
        campoDefensaJ1.setLayoutX(130);
        campoDefensaJ1.setLayoutY(60);
        campoDefensaJ1.setMinSize(662,157);
        campoDefensaJ1.setSpacing(25);

        terrenoJ1 = new StackPane();
        terrenoJ1.setLayoutX(0);
        terrenoJ1.setLayoutY(135);
        terrenoJ1.setMinSize(100,157);

        terrenoJ2 = new StackPane();
        terrenoJ2.setLayoutX(0);
        terrenoJ2.setLayoutY(493);
        terrenoJ2.setMinSize(100,157);

        this.getChildren().addAll(campoAtaqueJ1, campoAtaqueJ2, campoDefensaJ1, campoDefensaJ2, terrenoJ1, terrenoJ2);
    }

    public void agregarCartaMonstruoJ1(Button carta, CartaBoton cartaBoton){
        listaDeTodasLasCartasJ1.add(cartaBoton);
        monstruosJ1.add(cartaBoton);
        campoAtaqueJ1.getChildren().add(carta);
    }
    public void agregarCartaMonstruoJ2(Button carta, CartaBoton cartaBoton){
        listaDeTodasLasCartasJ2.add(cartaBoton);
        monstruosJ2.add(cartaBoton);
        campoAtaqueJ2.getChildren().add(carta);
    }
    public void agregarCartaEfectoJ1(Button carta, CartaBoton cartaBoton){
        listaDeTodasLasCartasJ1.add(cartaBoton);
        campoDefensaJ1.getChildren().add(carta);
    }
    public void agregarCartaEfectoJ2(Button carta, CartaBoton cartaBoton){
        listaDeTodasLasCartasJ2.add(cartaBoton);
        campoDefensaJ2.getChildren().add(carta);
    }

    public void agregarCartaTerrenoJ1(Button carta, CartaBoton cartaBoton){
        listaDeTodasLasCartasJ1.add(cartaBoton);
        terrenoJ1.getChildren().add(carta);
    }

    public void agregarCartaTerrenoJ2(Button carta, CartaBoton cartaBoton){
        listaDeTodasLasCartasJ2.add(cartaBoton);
        terrenoJ2.getChildren().add(carta);
    }

    public void elminarCartasDestruidas(ArrayList<CartaBoton> cartasAEliminar){

        if(!cartasAEliminar.isEmpty()){
            for(CartaBoton cartaAEliminar: cartasAEliminar) {
                if (campoAtaqueJ1.getChildren().contains(cartaAEliminar.getBoton())){
                    campoAtaqueJ1.getChildren().remove(cartaAEliminar.getBoton());
                    monstruosJ1.remove(cartaAEliminar);
                }
                else if (campoAtaqueJ2.getChildren().contains(cartaAEliminar.getBoton())){
                    campoAtaqueJ2.getChildren().remove(cartaAEliminar.getBoton());
                    monstruosJ2.remove(cartaAEliminar);
                }

                else if (campoDefensaJ1.getChildren().contains(cartaAEliminar.getBoton()))
                    campoDefensaJ1.getChildren().remove(cartaAEliminar.getBoton());

                else if (terrenoJ1.getChildren().contains(cartaAEliminar.getBoton()))
                    terrenoJ1.getChildren().remove(cartaAEliminar.getBoton());



                else if (campoDefensaJ2.getChildren().contains(cartaAEliminar.getBoton()))
                    campoDefensaJ2.getChildren().remove(cartaAEliminar.getBoton());

                else if (terrenoJ2.getChildren().contains(cartaAEliminar.getBoton()))
                    terrenoJ2.getChildren().remove(cartaAEliminar.getBoton());
            }
        }
    }

    public ArrayList<CartaBoton> obtenerMonstruosJ2(){
        return monstruosJ2;
    }

    public ArrayList<CartaBoton> obtenerMonstruosJ1(){
        return monstruosJ1;
    }


}
