package excepciones;

public class NoSeEncuentraLaCarta extends RuntimeException {

	public static final long serialVersionUID = 700L;
	
	public NoSeEncuentraLaCarta(String msj) {
		
		super(msj);
		
	}
}
