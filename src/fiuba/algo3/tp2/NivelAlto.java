package fiuba.algo3.tp2;

public class NivelAlto extends Nivel {

    @Override
    public void agregarseAlCampo(Campo campo, CartaMonstruo carta) {
        if(campo.cantidadDeMonstruos() >= 2){
            campo.eliminarCartaAlAzar();
            campo.eliminarCartaAlAzar();
            campo.agregarCartaEnZonaDeAtaque(carta);
        }
        else{
            //EXCEPCION NO TIENE MONSTRUOS EN EL CAMPO PARA SACRIFICAR
        }
    }
}