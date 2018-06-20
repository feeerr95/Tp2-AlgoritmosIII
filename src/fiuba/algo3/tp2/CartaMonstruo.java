package fiuba.algo3.tp2;

public class CartaMonstruo extends Carta{

	protected int atk;
	protected int def;
	protected Nivel nivel;
	private int bonificadorAtaque;
	private int bonificadorDefensa;

	public CartaMonstruo(String unNombre, int unAtaque, int unaDefensa, Nivel nivelDeLaCarta) {
		nivel = nivelDeLaCarta;
		nombreCarta = unNombre;
		atk = unAtaque;
		def = unaDefensa;
		bonificadorAtaque = 0;
		bonificadorDefensa = 0;
	}

	public boolean modoDefensa(){
		return this.posicion.modoDefensa();
	}

	public void atacarOtraCarta(CartaMonstruo otraCarta){
		otraCarta.recibirAtaque(this, this.duenio, this.posicion, this.atk + this.bonificadorAtaque);
	}

	protected void recibirAtaque(CartaMonstruo otraCarta, Jugador jugadorAtacante, PosicionCarta posicionAtacante, int ataqueAtacante){

		this.posicion.recibirAtaque(otraCarta, this, posicionAtacante, ataqueAtacante, this.atk + this.bonificadorAtaque, this.def + this.bonificadorDefensa);
	}

	public void restarPuntosDeVida(int cantidad){
		this.duenio.restarPuntosDeVida(cantidad);
	}

	protected void colocarEnCampo(Campo campo){
		nivel.colocarEnCampo(campo, this);
	}

	@Override
	public void usarEfecto() {

	}


	public boolean esMasDebilQue(CartaMonstruo otraCarta){
		return otraCarta.compararAtaque(this.atk);
	}

	private boolean compararAtaque(int unAtaque){
		return this.atk >= unAtaque;
	}

	public void cambiarBonificaciones(int atkDuenio, int defDuenio) {
		this.bonificadorAtaque = atkDuenio;
		this.bonificadorDefensa = defDuenio;
	}

	public void modificarBonificadorAtaque(int unAumento) {
		this.bonificadorAtaque = unAumento;
	}

	public void modificarBonificadorDefensa(int unAumento) {
		this.bonificadorDefensa = unAumento;
	}

	public String obtenerNombre() {
		return this.nombreCarta;
	}
	
}
