package InterfazGrafica.Vista;

import InterfazGrafica.Controlador.Controlador;
import InterfazGrafica.Eventos.EntrarBotonEventHandler;
import InterfazGrafica.Eventos.SalirBotonEventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;


import java.util.ArrayList;

public class ContenedorInicial extends AnchorPane {

    Stage ventana;
    Scene proximaEscena;
    Controlador controlador;
    ArrayList<Node> listaDeElementos;

    public ContenedorInicial(Stage ventana, Scene proximaEscena, double ancho, double alto){

        listaDeElementos = new ArrayList<>();
        this.ventana = ventana;
        this.proximaEscena = proximaEscena;

        Image imagenFondo = new Image("Imagenes/Fondo bienvenido.jpg");
        BackgroundImage imagen = new BackgroundImage(imagenFondo,null,null,null,null);
        Background fondo = new Background(imagen);
        this.setBackground(fondo);

        ventana.setWidth(imagenFondo.getWidth());
        ventana.setHeight(imagenFondo.getHeight());
        ventana.setResizable(false);

        Button salirBoton = new Button("Salir");
        salirBoton.setLayoutX(225);
        salirBoton.setLayoutY(140);
        SalirBotonEventHandler salirBotonEventHandler = new SalirBotonEventHandler(ventana);
        salirBoton.setOnAction(salirBotonEventHandler);
        listaDeElementos.add(salirBoton);

        Button entrarAlJuegoBoton = new Button("Entrar al juego");
        entrarAlJuegoBoton.setLayoutX(197);
        entrarAlJuegoBoton.setLayoutY(100);
        EntrarBotonEventHandler entrarBotonEventHandler = new EntrarBotonEventHandler(ventana, proximaEscena, ancho, alto);
        entrarAlJuegoBoton.setOnAction(entrarBotonEventHandler);
        listaDeElementos.add(entrarAlJuegoBoton);

        this.getChildren().addAll(listaDeElementos);

    }
}
