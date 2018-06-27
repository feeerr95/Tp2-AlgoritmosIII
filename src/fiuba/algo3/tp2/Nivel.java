package fiuba.algo3.tp2;

import excepciones.NoHayMonstruosEnCampo;

public abstract class Nivel {

    public abstract void agregarseAlCampo(Campo campo, CartaMonstruo carta) throws NoHayMonstruosEnCampo;
	public void agregarSacrificio(CartaMonstruo carta){} //VER ESTO
}
