package excepciones;

public class NoHayMonstruosEnCampo extends Exception {

	public static final long serialVersionUID = 700L;
	
	public NoHayMonstruosEnCampo(String msj) {
		
		super(msj);
		
	}
}
