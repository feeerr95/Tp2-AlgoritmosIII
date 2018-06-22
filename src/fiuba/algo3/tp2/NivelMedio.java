package fiuba.algo3.tp2;

public class NivelMedio extends Nivel{

    @Override
    public void agregarseAlCampo(Campo campo, CartaMonstruo carta) {
        if(campo.cantidadDeMonstruos() >= 1){
            campo.eliminarCartaAlAzar(); //ACA SE TIENE QUE SELECCIONAR LA CARTA A ELIMINAR
            campo.agregarCartaEnZonaDeAtaque(carta);
        }
        else{
            //EXCEPCION NO TIENE MONSTRUOS EN EL CAMPO PARA SACRIFICAR
        }
    }
}
