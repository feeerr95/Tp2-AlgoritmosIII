package Vista;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {

        ImageView fondo = new ImageView("Imagenes/Tablero.jpg");
        primaryStage.setTitle("Al-Go-Oh! juego");
        Pane layout = new Pane(fondo);
        this.setearCartasDePrueba(layout);


        Scene scene = new Scene(layout, 1170,1000);
        primaryStage.setScene(scene);
        fondo.setFitWidth(scene.getWidth());
        fondo.setFitHeight(scene.getHeight());
        primaryStage.show();
    }

    public Button crearCartaBocaAbajo(){
        Image image = new Image("Imagenes/E39.png");
        Button carta = new Button();
        ImageView cartaBocaAbajo = new ImageView(image);

        cartaBocaAbajo.setFitHeight(140);
        cartaBocaAbajo.setFitWidth(90);

        carta.setGraphic(cartaBocaAbajo);
        carta.setMaxSize(80,120);

        return carta;
    }

    public void colocarCarta(Pane layout, int coordenadaX, int coordenadaY){
        Button carta = this.crearCartaBocaAbajo();
        carta.setLayoutX(coordenadaX);
        carta.setLayoutY(coordenadaY);
        layout.getChildren().add(carta);
    }

    public void setearCartasDePrueba(Pane layout){
        //defensa enemigo
        this.colocarCarta(layout,379,170);
        this.colocarCarta(layout,512,170);
        this.colocarCarta(layout,647,170);
        this.colocarCarta(layout,780,170);
        this.colocarCarta(layout,914,170);

        //ataque enemigo
        this.colocarCarta(layout,379,335);
        this.colocarCarta(layout,512,335);
        this.colocarCarta(layout,647,335);
        this.colocarCarta(layout,780,335);
        this.colocarCarta(layout,914,335);

        //ataque propio
        this.colocarCarta(layout,379,518);
        this.colocarCarta(layout,512,518);
        this.colocarCarta(layout,647,518);
        this.colocarCarta(layout,780,518);
        this.colocarCarta(layout,914,518);

        //defensa propia
        this.colocarCarta(layout,379,682);
        this.colocarCarta(layout,512,682);
        this.colocarCarta(layout,647,682);
        this.colocarCarta(layout,780,682);
        this.colocarCarta(layout,914,682);

        //-------------------------CAMPOS-------------------------------
        //campo enemigo
        this.colocarCarta(layout,254,244);
        //campo propio
        this.colocarCarta(layout,254,600);

        //------------------------CEMENTERIOS----------------------------
        //cementerio enemigo
        this.colocarCarta(layout,1039,331);
        //cementerio propio
        this.colocarCarta(layout,1039,519);

        //----------------------------DECKS------------------------------
        //deck enemigo
        this.colocarCarta(layout,1039,173);
        //deck propio
        this.colocarCarta(layout,1039,679);
    }
}
