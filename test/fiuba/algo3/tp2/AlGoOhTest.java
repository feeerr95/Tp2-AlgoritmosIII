package fiuba.algo3.tp2;

import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;

import static org.junit.Assert.assertEquals;

public class AlGoOhTest {

	@Test
    public void atacarAMonstruoConMayorAtaqueAmbosPoscionAtaque() {

        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.asignarDuenio(atacante);
        campo1.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaArriba());

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);
        CartaMonstruo huevoMonstruoso = new CartaMonstruo("Huevo Monstruoso", 600, 900, new NivelBasico() );
        huevoMonstruoso.asignarDuenio(atacado);
        campo2.agregarCarta(huevoMonstruoso, new PosicionVertical(), new BocaArriba());

        insectoComeHombres.atacarOtraCarta(huevoMonstruoso);

        //Los puntos de vida del atacante tienen que disminuir 150
        assertEquals(7850,atacante.puntosDeVida());

        //Confirmo que la carta atacante fue destruida
        assertEquals(true, insectoComeHombres.estaDestruida());
    }

    @Test
    public void atacarAMonstruoConMenorAtaqueAmbosPoscionAtaque() {

        //Seteo el atacante
        Campo campo2 = new Campo();
        Jugador atacante = new Jugador(campo2);
        CartaMonstruo huevoMonstruoso = new CartaMonstruo("Huevo Monstruoso", 600, 900, new NivelBasico() );
        campo2.agregarCarta(huevoMonstruoso,  new PosicionVertical(), new BocaArriba());
        huevoMonstruoso.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador(campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        campo1.agregarCarta(insectoComeHombres,  new PosicionVertical(), new BocaArriba());
        insectoComeHombres.asignarDuenio(atacado);

        huevoMonstruoso.atacarOtraCarta(insectoComeHombres);

        //Los puntos de vida del atacado tienen que disminuir 150
        assertEquals(7850, atacado.puntosDeVida());

        //Confirmo que la carta atacada fue destruida
        assertEquals(true, insectoComeHombres.estaDestruida());
    }

    @Test
    public void atacarAMonstruoConIgualAtaqueAmbosEnPosicionAtaque() {

        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        campo1.agregarCarta(insectoComeHombres,  new PosicionVertical(), new BocaArriba());
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);
        CartaMonstruo insectoComeHombres2 = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        campo2.agregarCarta(insectoComeHombres2,  new PosicionVertical(), new BocaArriba());
        insectoComeHombres2.asignarDuenio(atacado);

        insectoComeHombres.atacarOtraCarta(insectoComeHombres2);

        assertEquals(8000, atacado.puntosDeVida());
        assertEquals(8000,atacante.puntosDeVida());

        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, insectoComeHombres2.estaDestruida());
    }

    @Test
    public void atacarMonstruoEnModoDefensaConMenorDefensaQueElAtaqueDelAtacante() {

       //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);
        CartaMonstruo abismoReluciente = new CartaMonstruo("Abismo Reluciente", 1600, 1800, new NivelBasico());
        campo1.agregarCarta(abismoReluciente, new PosicionVertical(), new BocaArriba() );
        abismoReluciente.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        campo2.agregarCarta(insectoComeHombres, new PosicionHorizontal(), new BocaArriba());
        insectoComeHombres.asignarDuenio(atacado);

        abismoReluciente.atacarOtraCarta(insectoComeHombres);

        assertEquals(8000,atacado.puntosDeVida());
        assertEquals(true, insectoComeHombres.estaDestruida());

    }



    @Test
    public void atacarMonstruoEnModoDefensaConMayorDefensaQueElAtaqueDelAtacante() {

        //Seteo el atacante
        Campo campo2 = new Campo();
        Jugador atacante = new Jugador(campo2);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        campo2.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaArriba() );
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador(campo1);
        CartaMonstruo abismoReluciente = new CartaMonstruo("Abismo Reluciente", 1600, 1800, new NivelBasico());
        campo1.agregarCarta(abismoReluciente, new PosicionHorizontal(), new BocaArriba());
        abismoReluciente.asignarDuenio(atacado);

        insectoComeHombres.atacarOtraCarta(abismoReluciente);

        //El atacante recibe daño por tenes menor puntos de ataque que la defensa del atacado
        assertEquals(8000, atacado.puntosDeVida());
        assertEquals(6650, atacante.puntosDeVida());

        //La carta atacante es destruida
        assertEquals(false, abismoReluciente.estaDestruida());
        assertEquals(false, insectoComeHombres.estaDestruida());
    }

    @Test
    public void colocarYUtilizarAgujeroNegroQueEliminaATodasLasCartas() { //ESTO DESPUES LO ARREGLO (ATTE: FER)

    	Campo campo1 = new Campo();
    	Jugador atacado = new Jugador(campo1);
    	Campo campo2 = new Campo();
    	Jugador atacante = new Jugador(campo2);
    	Tablero tablero = new Tablero(campo1, campo2);


        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        CartaMonstruo piernaDerechaDeExodia = new PiernaDerechaDeExodia();
        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        CartaEfecto agujeroNegro = new AgujeroNegro();
        CartaEfecto agujeroNegro2 = new AgujeroNegro();

        insectoComeHombres.asignarDuenio(atacado);
        campo1.agregarCarta(insectoComeHombres, new PosicionHorizontal(), new BocaArriba());

        huevoMonstruoso.asignarDuenio(atacado);
        campo1.agregarCarta(huevoMonstruoso, new PosicionHorizontal(), new BocaArriba());

        piernaDerechaDeExodia.asignarDuenio(atacante);
        campo2.agregarCarta(piernaDerechaDeExodia, new PosicionHorizontal(), new BocaArriba());

        cabezaDeExodia.asignarDuenio(atacante);
        campo2.agregarCarta(cabezaDeExodia, new PosicionHorizontal(), new BocaArriba());

        agujeroNegro.asignarDuenio(atacante);
        agujeroNegro2.asignarDuenio(atacado);

        agujeroNegro.usarEfectoContra(tablero);

        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, huevoMonstruoso.estaDestruida());
        assertEquals(true, cabezaDeExodia.estaDestruida());
        assertEquals(true, piernaDerechaDeExodia.estaDestruida());
        assertEquals(true, agujeroNegro.estaDestruida());

        //Solo elimina a las cartas monstruo
        assertEquals(false, agujeroNegro2.estaDestruida());
    }

    @Test
    public void colocarMonstruoConUnSacrificio() {

    Campo campo = new Campo();
    Jugador jugador = new Jugador(campo);
    CartaMonstruo insectoComeHombres = new InsectoComeHombres();
    insectoComeHombres.asignarDuenio(jugador);
    campo.agregarCarta(insectoComeHombres, new PosicionHorizontal(), new BocaArriba());

    CartaMonstruo chicaMagaOscura = new ChicaMagaOscura();
    chicaMagaOscura.asignarDuenio(jugador);
    campo.agregarCarta(chicaMagaOscura, new PosicionHorizontal(), new BocaArriba());
    assertEquals(true, insectoComeHombres.estaDestruida());
}

    @Test
    public void colocarMonstruoConDosSacrificios(){

        Campo campo = new Campo();
        Jugador jugador = new Jugador(campo);
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.asignarDuenio(jugador);
        campo.agregarCarta(insectoComeHombres, new PosicionHorizontal(), new BocaArriba());

        CartaMonstruo abismoReluciente = new AbismoReluciente();
        abismoReluciente.asignarDuenio(jugador);
        campo.agregarCarta(abismoReluciente, new PosicionHorizontal(), new BocaArriba());

        CartaMonstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
        dragonBlancoDeOjosAzules.asignarDuenio(jugador);
        campo.agregarCarta(dragonBlancoDeOjosAzules, new PosicionHorizontal(), new BocaArriba());


        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, abismoReluciente.estaDestruida());
    }

    @Test
    public void usarWastelandYBonificarAtaqueDeMisMonstruosYDefensaDelEnemigo() {
    	
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);

        Tablero tablero = new Tablero(campo1, campo2);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.asignarDuenio(atacante);
        campo1.agregarCarta(insectoComeHombres, new PosicionVertical(), new BocaArriba());


        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.asignarDuenio(atacado);
        campo2.agregarCarta(huevoMonstruoso, new PosicionVertical(), new BocaArriba());


        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);
        
        CartaTerreno wasteland = new Wasteland();
        wasteland.asignarDuenio(atacante);
        campo1.agregarCarta(wasteland, new PosicionVertical(), new BocaArriba());
        wasteland.usarEfectoContra(tablero);


        //Como esta vez hay un efecto de campo, Insecto come hombres deberia ganar
        insectoComeHombres.atacarOtraCarta(huevoMonstruoso);
        
        //Los puntos de vida del atacado tienen que disminuir 50
        assertEquals(7950,atacado.puntosDeVida());

        //Confirmo que la carta atacada fue destruida
        assertEquals(true, huevoMonstruoso.estaDestruida());

    }

    @Test
    public void agregarCartaDespuesDeHaberUsadoWastelandYVerQueSigueEstandoPresenteElEfecto() {

        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);

        Tablero tablero = new Tablero(campo1, campo2);

        CartaTerreno wasteland = new Wasteland();
        wasteland.asignarDuenio(atacante);
        campo1.agregarCarta(wasteland, new PosicionVertical(), new BocaArriba());
        wasteland.usarEfectoContra(tablero);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.asignarDuenio(atacante);
        campo1.agregarCarta(insectoComeHombres,new PosicionVertical(), new BocaArriba());


        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.asignarDuenio(atacado);
        campo2.agregarCarta(huevoMonstruoso,new PosicionVertical(), new BocaArriba());


        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);


        //Como esta vez hay un efecto de campo, Insecto come hombres deberia ganar
        insectoComeHombres.atacarOtraCarta(huevoMonstruoso);

        //Los puntos de vida del atacado tienen que disminuir 50
        assertEquals(7950,atacado.puntosDeVida());

        //Confirmo que la carta atacada fue destruida
        assertEquals(true, huevoMonstruoso.estaDestruida());

    }

    @Test
    public void usarSogenYBonificarDefensaDeMisMonstruosYAtaqueDelEnemigo(){

        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);


        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);

        Tablero tablero = new Tablero(campo1, campo2);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.asignarDuenio(atacante);
        campo1.agregarCarta(insectoComeHombres,new PosicionHorizontal(), new BocaArriba());

        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.asignarDuenio(atacado);
        campo2.agregarCarta(huevoMonstruoso, new PosicionHorizontal(), new BocaArriba());


        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);

        CartaMonstruo acechadorDelCraneo = new AcechadorDelCraneo();
        acechadorDelCraneo.cambiarPosicion(new PosicionHorizontal());
        acechadorDelCraneo.asignarDuenio(atacante);
        campo1.agregarCarta(acechadorDelCraneo, new PosicionHorizontal(), new BocaArriba());

        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        cabezaDeExodia.cambiarPosicion(new PosicionVertical());
        cabezaDeExodia.asignarDuenio(atacado);
        campo2.agregarCarta(cabezaDeExodia, new PosicionHorizontal(), new BocaArriba());

        CartaTerreno sogen = new Sogen();
        sogen.asignarDuenio(atacante);
        campo1.agregarCarta(sogen, new PosicionVertical(), new BocaArriba());
        sogen.usarEfectoContra(tablero);

        //Normalmente la Cabeza de exodia deberia destruir a la otra carta, pero no sucede ya que hay un efecto de campo
        cabezaDeExodia.atacarOtraCarta(acechadorDelCraneo);

        //Los puntos de vida del atacado tienen que disminuir 100
        assertEquals(7900,atacado.puntosDeVida());

        //Confirmo que la carta atacada no fue destruida
        assertEquals(false, acechadorDelCraneo.estaDestruida());
    }

    @Test
    public void usarOllaDeLaCodiciaYVerQueEnElMazoTengoDosCartasMenos(){
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador jugador = new Jugador(campo1);
        CartaEfecto ollaDeLaCodicia = new OllaDeLaCodicia();
        ollaDeLaCodicia.asignarDuenio(jugador);
        int cantidadActual = jugador.cantidadDeCartasEnElMazo();
        ollaDeLaCodicia.usarEfectoContra(jugador);

        assertEquals(cantidadActual - 2, jugador.cantidadDeCartasEnElMazo());
        assertEquals(true,ollaDeLaCodicia.estaDestruida());
    }

    @Test
    public void usarFisuraYVerQueLaCartaMasDebilDelEnemigoEsEliminada(){

        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador(campo1);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarPosicion(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacado);
        campo1.agregarCarta(insectoComeHombres, new PosicionHorizontal(), new BocaArriba());
        insectoComeHombres.darVuelta();

        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarPosicion(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        campo1.agregarCarta(huevoMonstruoso, new PosicionHorizontal(), new BocaArriba());
        huevoMonstruoso.darVuelta();

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacante = new Jugador(campo2);
        CartaMagica fisura = new Fisura();
        fisura.asignarDuenio(atacante);
        fisura.usarEfectoContra(atacado);


        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(false, huevoMonstruoso.estaDestruida());

    }

    @Test
    public void usarAJinzo7YAtacarDirectamenteALosPuntosDeVida(){
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador(campo1);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarPosicion(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacado);
        campo1.agregarCarta(insectoComeHombres,new PosicionHorizontal(), new BocaArriba());

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacante = new Jugador(campo2);
        CartaMonstruo jinzo7 = new Jinzo7();
        jinzo7.usarEfectoContra(atacado);

        assertEquals(7500, atacado.puntosDeVida());
    }

    @Test
    public void darVueltaInsectoComeHombresYMatarCartaMonstruoEnemigo(){
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);

        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.asignarDuenio(atacado);
        campo2.agregarCarta(insectoComeHombres, new PosicionHorizontal(), new BocaAbajo());

        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.asignarDuenio(atacante);
        campo1.agregarCarta(huevoMonstruoso, new PosicionVertical(), new BocaArriba());

        huevoMonstruoso.atacarOtraCarta(insectoComeHombres);

        assertEquals(true, huevoMonstruoso.estaDestruida());

    }

    @Test
    public void meAtacanYSeActivaCilindroMagico(){
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);

        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);

        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.asignarDuenio(atacante);
        campo1.agregarCarta(huevoMonstruoso, new PosicionVertical(), new BocaArriba());

        CartaTrampa cilindroMagico = new CilindroMagico();
        cilindroMagico.asignarDuenio(atacado);
        campo2.agregarCarta(cilindroMagico, new PosicionVertical(), new BocaAbajo());

        CartaMonstruo jinzo7 = new Jinzo7();
        jinzo7.asignarDuenio(atacado);
        campo2.agregarCarta(jinzo7, new PosicionVertical(), new BocaArriba());

        huevoMonstruoso.atacarOtraCarta(jinzo7);

        assertEquals(false, huevoMonstruoso.estaDestruida());
        assertEquals(false, jinzo7.estaDestruida());
        assertEquals(true, cilindroMagico.estaDestruida());
        assertEquals(7400, atacante.puntosDeVida());
    }

    @Test
    public void meAtacanYSeActivaReinforcements(){
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);

        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);

        CartaMonstruo acechadorDelCraneo = new AcechadorDelCraneo();
        acechadorDelCraneo.asignarDuenio(atacante);
        campo1.agregarCarta(acechadorDelCraneo, new PosicionVertical(), new BocaArriba());

        CartaTrampa reinforcements = new Reinforcements();
        reinforcements.asignarDuenio(atacado);
        campo2.agregarCarta(reinforcements, new PosicionVertical(), new BocaAbajo());

        CartaMonstruo jinzo7 = new Jinzo7();
        jinzo7.asignarDuenio(atacado);
        campo2.agregarCarta(jinzo7, new PosicionVertical(), new BocaArriba());

        acechadorDelCraneo.atacarOtraCarta(jinzo7);

        assertEquals(true, acechadorDelCraneo.estaDestruida());
        assertEquals(false, jinzo7.estaDestruida());
        assertEquals(true, reinforcements.estaDestruida());
        assertEquals(7900, atacante.puntosDeVida());
        assertEquals(8000, atacado.puntosDeVida());

    }

    @Test
    public void jugarTodasLasPartesDeExodiaYGanar(){
        //Seteo el ganador
        Campo campo1 = new Campo();
        Jugador ganador = new Jugador(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador perdedor = new Jugador(campo2);

        ganador.agregarEnemigo(perdedor);
        perdedor.agregarEnemigo(ganador);

        CartaMonstruo cabezaExodia = new CabezaDeExodia();
        CartaMonstruo brazoDerechoExodia = new BrazoDerechoDeExodia();
        CartaMonstruo brazoIzquierdoExodia = new BrazoIzquierdoDeExodia();
        CartaMonstruo piernaDerechaExodia = new PiernaDerechaDeExodia();
        CartaMonstruo piernaIzquierdaExodia = new PiernaIzquierdaDeExodia();

        cabezaExodia.asignarDuenio(ganador);
        brazoDerechoExodia.asignarDuenio(ganador);
        brazoIzquierdoExodia.asignarDuenio(ganador);
        piernaDerechaExodia.asignarDuenio(ganador);
        piernaIzquierdaExodia.asignarDuenio(ganador);

        campo1.agregarCarta(cabezaExodia, new PosicionHorizontal(), new BocaAbajo());
        campo1.agregarCarta(brazoDerechoExodia, new PosicionVertical(), new BocaAbajo());
        campo1.agregarCarta(brazoIzquierdoExodia, new PosicionHorizontal(), new BocaArriba());
        campo1.agregarCarta(piernaDerechaExodia, new PosicionVertical(), new BocaArriba());
        campo1.agregarCarta(piernaIzquierdaExodia, new PosicionHorizontal(), new BocaAbajo());

        assertEquals(0, perdedor.puntosDeVida());

    }

}




