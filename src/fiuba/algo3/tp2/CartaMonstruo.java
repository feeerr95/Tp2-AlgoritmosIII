package fiuba.algo3.tp2;

public class CartaMonstruo extends Carta{
	
	private String nombreMonstruo;
	private int atk;
	private int def;
	
	public CartaMonstruo(){
		atk = 0;
		def = 0;
	}
	
	public CartaMonstruo(String unNombre, int unAtaque, int unaDefensa) {
		nombreMonstruo = unNombre;
		atk = unAtaque;
		def = unaDefensa;
	}
}
