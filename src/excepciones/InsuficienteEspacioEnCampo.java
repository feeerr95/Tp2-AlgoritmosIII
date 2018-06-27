package excepciones;

public class InsuficienteEspacioEnCampo extends RuntimeException{

	public static final long serialVersionUID = 700L;
	
	public InsuficienteEspacioEnCampo(String msj) {
		
		super(msj);
		
	}
}
