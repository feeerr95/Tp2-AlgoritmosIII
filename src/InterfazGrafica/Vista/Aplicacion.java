package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import fiuba.algo3.tp2.Campo;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
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
        controlador = new Controlador(tablero, jugador1, jugador2);
    }


    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Juego");

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, controlador);
        Scene escenaJuego = new Scene(contenedorPrincipal);

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaJuego);
        Scene escenaBienvenida = new Scene (contenedorInicial);

        controlador.setContenedorInicial(contenedorInicial);
        controlador.setContenedorPrincipal(contenedorPrincipal);

        stage.setScene(escenaBienvenida);
        stage.show();
    }
}
