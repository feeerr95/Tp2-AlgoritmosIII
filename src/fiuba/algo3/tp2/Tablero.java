package fiuba.algo3.tp2;

public class Tablero {

    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero(){
    }

    public void cargarJugadores(Jugador unJugador, Jugador otroJugador){
        jugador1 = unJugador;
        jugador2 = otroJugador;
    }


    public void eliminarTodasLasCartasMonstruo(){
        this.jugador1.destruirTodasLasCartasMonstruo();
        this.jugador2.destruirTodasLasCartasMonstruo();
    }

    //El dueño que se pasa por parámetro tiene que ser uno de los jugadores que esta agregado en tablero
	public void bonificarCartas(Jugador duenio, int atkDuenio, int defDuenio, int atkEnemigo, int defEnemigo) {
		duenio.bonificarCartas(atkDuenio, defDuenio);
		if(duenio.obtenerNombre() == jugador1.obtenerNombre()) {
			jugador2.bonificarCartas(atkEnemigo, defEnemigo);
		}else {
			jugador1.bonificarCartas(atkEnemigo, defEnemigo);
		}	
	}
}
