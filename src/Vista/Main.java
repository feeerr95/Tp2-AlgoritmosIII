package Vista;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {


        Stage ventanaJuego = new Stage();
        ContenedorPrincipalPrueba contenedorPrincipalPrueba = new ContenedorPrincipalPrueba(ventanaJuego);
        Scene escenaJuego = new Scene(contenedorPrincipalPrueba);
        ventanaJuego.setScene(escenaJuego);
        ContenedorBienvenidosPrueba contenedorBienvenidosPrueba = new ContenedorBienvenidosPrueba(stage, ventanaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidosPrueba);

        stage.setScene(escenaBienvenidos);
        stage.show();
    }

}
