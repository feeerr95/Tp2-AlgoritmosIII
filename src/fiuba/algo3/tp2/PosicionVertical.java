package fiuba.algo3.tp2;

public class PosicionVertical implements PosicionCarta {
	
	@Override
	public void recibirAtaque(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, PosicionCarta otraPosicion, int atkAtacante, int atkAtacado, int defAtacado) {

		if(cartaAtacada.bocaAbajo) {		
			cartaAtacada.darVuelta();
		}
		
		int diferenciaDeAtaque = atkAtacado - atkAtacante;

		if(diferenciaDeAtaque < 0 ){
			cartaAtacada.restarPuntosDeVida( Math.abs(diferenciaDeAtaque) );
			cartaAtacada.destruir();
		}
		else if(diferenciaDeAtaque == 0){
			cartaAtacada.destruir();
			cartaAtacante.destruir();
		}
		else{
			cartaAtacante.restarPuntosDeVida( Math.abs(diferenciaDeAtaque) );
			cartaAtacante.destruir();
		}
	}

	@Override
	public boolean modoDefensa() {
		return false;
	}
}
