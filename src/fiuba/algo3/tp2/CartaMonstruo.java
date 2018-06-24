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

	@Override
	public void agregarseAlCampo(Campo campo){
		nivel.agregarseAlCampo(campo, this);
	}

	public void atacarOtraCarta(CartaMonstruo otraCarta){
		otraCarta.recibirAtaque(this, this.duenio, this.posicion, this.atk + this.bonificadorAtaque);
	}

	protected void recibirAtaque(CartaMonstruo otraCarta, Jugador jugadorAtacante, PosicionCarta posicionAtacante, int ataqueAtacante){
	    if(!this.duenio.cartasTrampaEnJuego(this, otraCarta)) { //El efecto tira false si la carta atacada sigue siendo atacada y true si deja de ser atacada
            if (this.estaBocaAbajo() && this.estaEnElCampo()) {
                this.darVuelta();
            }
            this.posicion.recibirAtaque(otraCarta, this, posicionAtacante, ataqueAtacante, this.atk + this.bonificadorAtaque, this.def + this.bonificadorDefensa);
        }
	}

	public int getPuntosDeAtaque(){
	    return this.atk + this.bonificadorAtaque;
    }

	public void restarPuntosDeVida(int cantidad){
		this.duenio.restarPuntosDeVida(cantidad);
	}

	public boolean esMasDebilQue(CartaMonstruo otraCarta){
		return otraCarta.compararAtaque(this.atk);
	}

	private boolean compararAtaque(int unAtaque){
		return this.atk >= unAtaque;
	}

	@Override
	public void cambiarBonificaciones(int bonAtk, int bonDef) {
		this.bonificadorAtaque = bonAtk;
		this.bonificadorDefensa = bonDef;
	}
	
}
