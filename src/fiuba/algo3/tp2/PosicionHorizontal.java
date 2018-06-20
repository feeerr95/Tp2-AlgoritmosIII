package fiuba.algo3.tp2;

public class PosicionHorizontal implements PosicionCarta {

	
	@Override
	public void recibirAtaque(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada, PosicionCarta otraPosicion, int atkAtacante, int atkAtacado, int defAtacado) {
		
		if(cartaAtacada.bocaAbajo) {		
			cartaAtacada.darVuelta();
		}
		
		int diferenciaDeAtaque = defAtacado - atkAtacante;

		if(diferenciaDeAtaque < 0 ){
			cartaAtacada.destruir();
		}
		else if(diferenciaDeAtaque > 0){
			cartaAtacante.restarPuntosDeVida( Math.abs(diferenciaDeAtaque) );
		}
	}

	@Override
	public boolean modoDefensa() {
		return true;
	}

}
