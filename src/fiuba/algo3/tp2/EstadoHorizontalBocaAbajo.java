package fiuba.algo3.tp2;

public class EstadoHorizontalBocaAbajo implements EstadoCarta{

	private String abreviacion = "HBAB";

	@Override
	public boolean es(String unEstado) {
		return abreviacion.equals(unEstado);
	}
}
