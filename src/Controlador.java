
import Vista.ContenedorBienvenidosPrueba;
import Vista.ContenedorPrincipalPrueba;
import fiuba.algo3.tp2.Jugador;
import fiuba.algo3.tp2.Tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    Tablero tablero;
    Jugador jugador1;
    Jugador jugador2;
    ContenedorPrincipalPrueba contenedorPrincipalPrueba;
    ContenedorBienvenidosPrueba contenedorBienvenidosPrueba;


    public Controlador(Tablero tablero, Jugador jugador1, Jugador jugador2,
                       ContenedorBienvenidosPrueba contenedorBienvenidosPrueba,
                       ContenedorPrincipalPrueba contenedorPrincipalPrueba){

        this.tablero = tablero;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.contenedorBienvenidosPrueba = contenedorBienvenidosPrueba;
        this.contenedorPrincipalPrueba = contenedorPrincipalPrueba;


    }

    @Override
    public void actionPerformed(ActionEvent evento) {



    }
}
