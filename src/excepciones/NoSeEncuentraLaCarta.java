package excepciones;

public class NoSeEncuentraLaCarta extends Exception {

	public static final long serialVersionUID = 700L;
	
	public NoSeEncuentraLaCarta(String msj) {
		
		super(msj);
		
	}
}
