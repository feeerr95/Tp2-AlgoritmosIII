package fiuba.algo3.tp2;

public class EstadoVerticalBocaAbajo implements EstadoCarta{

	private String abreviacion = "VBAB";
	@Override
	public boolean es(String unEstado) {
		return abreviacion.equals(unEstado);
	}
}
