package InterfazGrafica.Controlador;

import InterfazGrafica.Modelo.Modelo;
import InterfazGrafica.Vista.ContenedorInicial;
import InterfazGrafica.Vista.ContenedorPrincipal;
import fiuba.algo3.tp2.Carta;

import java.util.ArrayList;

public class Controlador{

    Modelo modelo;
    ContenedorPrincipal contenedorPrincipal;
    ContenedorInicial contenedorInicial;

    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public void setContenedorInicial(ContenedorInicial contenedorInicial) {
        this.contenedorInicial = contenedorInicial;
    }

    public void setContenedorPrincipal(ContenedorPrincipal contenedorPrincipal) {
        this.contenedorPrincipal = contenedorPrincipal;
    }

    public ContenedorInicial getContenedorInicial() {
        return contenedorInicial;
    }

    public ContenedorPrincipal getContenedorPrincipal() {
        return contenedorPrincipal;
    }

    public Modelo getModelo() {
        return modelo;
    }
    public void setManosIniciales(){
        ArrayList<Carta> manoJugador1 = modelo.obtenerManoJugador1();
        ArrayList<Carta> manoJugador2 = modelo.obtenerManoJugador2();
        contenedorPrincipal.setManos(manoJugador1,manoJugador2);
    }
}
