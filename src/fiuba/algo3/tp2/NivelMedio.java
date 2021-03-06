package fiuba.algo3.tp2;

import excepciones.NoHayMonstruosEnCampo;

public class NivelMedio extends Nivel{

    @Override
    public void agregarseAlCampo(Campo campo, CartaMonstruo carta) throws NoHayMonstruosEnCampo{
        if(campo.cantidadDeMonstruos() >= 1){
            campo.eliminarCartaAlAzar();
            campo.agregarCartaEnZonaDeAtaque(carta);
        }
        else{
        	throw new NoHayMonstruosEnCampo("No hay suficentes monstruos para sacrificar");
        }
    }
}
