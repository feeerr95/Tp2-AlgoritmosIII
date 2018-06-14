package fiuba.algo3.tp2;

public class EstadoHorizontalBocaArriba implements EstadoCarta{

	private String abreviacion = "HBAR";

	@Override
	public boolean es(String unEstado) {
		return abreviacion.equals(unEstado);
	}

}
