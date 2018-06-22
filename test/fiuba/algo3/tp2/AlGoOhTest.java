package fiuba.algo3.tp2;

import javafx.scene.control.Tab;
import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;

import static org.junit.Assert.assertEquals;

public class AlGoOhTest {

	@Test
    public void atacarAMonstruoConMayorAtaqueAmbosPoscionAtaque() {

        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador("Jugador atacante", campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("Jugador atacado", campo2);
        CartaMonstruo huevoMonstruoso = new CartaMonstruo("Huevo Monstruoso", 600, 900, new NivelBasico() );
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);

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
        Jugador atacante = new Jugador("Juador atacante", campo2);
        CartaMonstruo huevoMonstruoso = new CartaMonstruo("Huevo Monstruoso", 600, 900, new NivelBasico() );
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador("Jugador atacado", campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionVertical());
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
        Jugador atacante = new Jugador("Jugador atacante", campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("Jugador atacado", campo2);
        CartaMonstruo insectoComeHombres2 = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres2.cambiarEstado(new PosicionVertical());
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
        Jugador atacante = new Jugador("Jugador atacante", campo1);
        CartaMonstruo abismoReluciente = new CartaMonstruo("Abismo Reluciente", 1600, 1800, new NivelBasico());
        abismoReluciente.cambiarEstado(new PosicionVertical());
        abismoReluciente.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("Jugador atacado", campo2);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionHorizontal());
        insectoComeHombres.asignarDuenio(atacado);

        abismoReluciente.atacarOtraCarta(insectoComeHombres);

        assertEquals(8000,atacado.puntosDeVida());
        assertEquals(true, insectoComeHombres.estaDestruida());

    }



    @Test
    public void atacarMonstruoEnModoDefensaConMayorDefensaQueElAtaqueDelAtacante() {

        //Seteo el atacante
        Campo campo2 = new Campo();
        Jugador atacante = new Jugador("Jugador atacante", campo2);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador("Jugador atacado", campo1);
        CartaMonstruo abismoReluciente = new CartaMonstruo("Abismo Reluciente", 1600, 1800, new NivelBasico());
        abismoReluciente.cambiarEstado(new PosicionHorizontal());
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
    	Jugador atacado = new Jugador("atacado", campo1);
    	Campo campo2 = new Campo();
    	Jugador atacante = new Jugador("atacante", campo2);
    	Tablero tablero = new Tablero(campo1, campo2);


        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        CartaMonstruo piernaDerechaDeExodia = new PiernaDerechaDeExodia();
        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        CartaEfecto agujeroNegro = new AgujeroNegro();
        CartaEfecto agujeroNegro2 = new AgujeroNegro();

        insectoComeHombres.asignarDuenio(atacado);
        campo1.agregarCarta(insectoComeHombres);

        huevoMonstruoso.asignarDuenio(atacado);
        campo1.agregarCarta(huevoMonstruoso);

        piernaDerechaDeExodia.asignarDuenio(atacante);
        campo2.agregarCarta(piernaDerechaDeExodia);

        cabezaDeExodia.asignarDuenio(atacante);
        campo2.agregarCarta(cabezaDeExodia);

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
    Jugador jugador = new Jugador("Jugador", campo);
    CartaMonstruo insectoComeHombres = new InsectoComeHombres();
    insectoComeHombres.asignarDuenio(jugador);
    campo.agregarCarta(insectoComeHombres);

    CartaMonstruo chicaMagaOscura = new ChicaMagaOscura();
    chicaMagaOscura.asignarDuenio(jugador);
    campo.agregarCarta(chicaMagaOscura);
    assertEquals(true, insectoComeHombres.estaDestruida());
}

    @Test
    public void colocarMonstruoConDosSacrificios(){

        Campo campo = new Campo();
        Jugador jugador = new Jugador("jugador", campo);
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.asignarDuenio(jugador);
        campo.agregarCarta(insectoComeHombres);

        CartaMonstruo abismoReluciente = new AbismoReluciente();
        abismoReluciente.asignarDuenio(jugador);
        campo.agregarCarta(abismoReluciente);

        CartaMonstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
        dragonBlancoDeOjosAzules.asignarDuenio(jugador);
        campo.agregarCarta(dragonBlancoDeOjosAzules);


        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, abismoReluciente.estaDestruida());
    }

    @Test
    public void usarWastelandYBonificarAtaqueDeMisMonstruosYDefensaDelEnemigo() {
    	
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador("jugador atacante", campo1);
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);
        campo1.agregarCarta(insectoComeHombres);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("jugador atacado", campo2);
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        campo2.agregarCarta(huevoMonstruoso);

        Tablero tablero = new Tablero(campo1, campo2);

        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);
        
        CartaTerreno cartaDeCampo = new Wasteland();
        cartaDeCampo.asignarDuenio(atacante);
        campo1.agregarCarta(cartaDeCampo);
        cartaDeCampo.usarEfectoContra(tablero);


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
        Jugador atacante = new Jugador("jugador atacante", campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("jugador atacado", campo2);

        Tablero tablero = new Tablero(campo1, campo2);

        CartaTerreno wasteland = new Wasteland();
        wasteland.asignarDuenio(atacante);
        campo1.agregarCarta(wasteland);
        wasteland.usarEfectoContra(tablero);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);
        campo1.agregarCarta(insectoComeHombres);


        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        campo2.agregarCarta(huevoMonstruoso);


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
        Jugador atacante = new Jugador("jugador atacante", campo1);
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);
        campo1.agregarCarta(insectoComeHombres);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("jugador atacado", campo2);
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        campo2.agregarCarta(huevoMonstruoso);
        Tablero tablero = new Tablero(campo1, campo2);


        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);

        CartaMonstruo acechadorDelCraneo = new AcechadorDelCraneo();
        acechadorDelCraneo.cambiarEstado(new PosicionHorizontal());
        acechadorDelCraneo.asignarDuenio(atacante);
        campo1.agregarCarta(acechadorDelCraneo);

        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        cabezaDeExodia.cambiarEstado(new PosicionVertical());
        cabezaDeExodia.asignarDuenio(atacado);
        campo2.agregarCarta(cabezaDeExodia);

        CartaTerreno cartaDeCampo2 = new Sogen();
        cartaDeCampo2.asignarDuenio(atacante);
        campo1.agregarCarta(cartaDeCampo2);
        cartaDeCampo2.usarEfectoContra(tablero);

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
        Jugador jugador = new Jugador("jugador atacante", campo1);
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
        Jugador atacado = new Jugador("jugador atacado", campo1);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacado);
        campo1.agregarCarta(insectoComeHombres);
        insectoComeHombres.darVuelta();

        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        campo1.agregarCarta(huevoMonstruoso);
        huevoMonstruoso.darVuelta();

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacante = new Jugador("jugador atacante", campo2);
        CartaMagica fisura = new Fisura();
        fisura.asignarDuenio(atacante);
        fisura.usarEfectoContra(atacado);


        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(false, huevoMonstruoso.estaDestruida());

    }

    @Test
    public void usarAJinzo7YAtacarDirectamenteALosPuntosDeVida(){
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador("jugador atacado", campo1);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacado);
        campo1.agregarCarta(insectoComeHombres);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacante = new Jugador("jugador atacante", campo2);
        CartaMonstruo jinzo7 = new Jinzo7();
        jinzo7.usarEfectoContra(atacado);

        assertEquals(7500, atacado.puntosDeVida());
    }
}




