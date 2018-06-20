package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelEspecial;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo{
	
	public DragonDefinitivoDeOjosAzules() {
		super("Dragon Definitivo De Ojos Azules", 4500, 3800, new NivelEspecial());
		this.nivel.agregarSacrificio("Dragon Blanco De Ojos Azules");
		this.nivel.agregarSacrificio("Dragon Blanco De Ojos Azules");
		this.nivel.agregarSacrificio("Dragon Blanco De Ojos Azules");
	}
	
}
