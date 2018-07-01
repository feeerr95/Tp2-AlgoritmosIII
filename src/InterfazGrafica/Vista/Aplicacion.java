package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import fiuba.algo3.tp2.Campo;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tablero;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application{

    public static void main(String[] args){
        launch(args);
    }

    Campo campo1;
    Campo campo2;
    Jugador jugador1;
    Jugador jugador2;
    Tablero tablero;
    Controlador controlador;


    public Aplicacion(){

        campo1 = new Campo();
        campo2 = new Campo();
        jugador1 = new Jugador(campo1);
        jugador2 = new Jugador(campo2);
        tablero = new Tablero(campo1, campo2);
        campo1.setTablero(tablero);
        campo2.setTablero(tablero);
        controlador = new Controlador(tablero, jugador1, jugador2);
    }


    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Juego");

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, controlador);
        AnchorPane ap = (AnchorPane) contenedorPrincipal;
        ScrollPane sp = new ScrollPane();
        sp.setMinSize(800,700);
        sp.setMaxSize(1170,1038);

        sp.setContent(ap);
        Scene escenaJuego = new Scene(sp);

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaJuego,sp.getMaxWidth(), sp.getMaxHeight());
        Scene escenaBienvenida = new Scene (contenedorInicial);

        controlador.setContenedorInicial(contenedorInicial);
        controlador.setContenedorPrincipal(contenedorPrincipal);

        stage.setScene(escenaBienvenida);
        stage.show();
    }
}
