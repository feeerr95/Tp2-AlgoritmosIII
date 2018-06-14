package fiuba.algo3.tp2;

public class EstadoVerticalBocaArriba implements EstadoCarta{

	private String abreviacion = "VBAR";

	@Override
	public boolean es(String unEstado) {
		return abreviacion.equals(unEstado);
	}
}
