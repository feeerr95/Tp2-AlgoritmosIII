package fiuba.algo3.tp2;

import java.util.Stack;

public class ZonaCementerio implements Zona {

    private Stack<Carta> stackCartas;

    public ZonaCementerio(){
        this.stackCartas = new Stack<>();
    }

    public void agregarCarta(Carta unaCarta) {
        this.stackCartas.push(unaCarta);
    }

    public Carta removerCarta(Carta unaCarta) {
        return this.stackCartas.pop();
    }

	public boolean cartaEnCementerio(Carta carta) {
		return stackCartas.contains(carta);
	}
    
}