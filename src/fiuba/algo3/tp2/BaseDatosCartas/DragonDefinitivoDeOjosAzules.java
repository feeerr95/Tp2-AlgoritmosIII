package fiuba.algo3.tp2.BaseDatosCartas;

import fiuba.algo3.tp2.CartaMonstruo;
import fiuba.algo3.tp2.NivelFusion;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo{
	
	public DragonDefinitivoDeOjosAzules() {
		super("Dragon Definitivo De Ojos Azules", 4500, 3800, new NivelFusion());
		CartaMonstruo dragonOjosAzules = new DragonBlancoDeOjosAzules();

		this.nivel.agregarSacrificio(dragonOjosAzules);
		this.nivel.agregarSacrificio(dragonOjosAzules);
		this.nivel.agregarSacrificio(dragonOjosAzules);
	}
	
}
