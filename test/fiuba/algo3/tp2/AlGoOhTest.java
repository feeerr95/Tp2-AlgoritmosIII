package fiuba.algo3.tp2;

import javafx.scene.control.Tab;
import org.junit.Test;

import fiuba.algo3.tp2.BaseDatosCartas.*;

import static org.junit.Assert.assertEquals;

public class AlGoOhTest {

	@Test
    public void AtacarAMonstruoConMayorAtaqueAmbosPoscionAtaque() {

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
    public void AtacarAMonstruoConMenorAtaqueAmbosPoscionAtaque() {

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
    public void AtacarAMonstruoConIgualAtaqueAmbosEnPosicionAtaque() {

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
    public void AtacarMonstruoEnModoDefensaConMenorDefensaQueElAtaqueDelAtacante() {

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
    public void AtacarMonstruoEnModoDefensaConMayorDefensaQueElAtaqueDelAtacante() {

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
    public void ColocarYUtilizarAgujeroNegroQueEliminaATodasLasCartas() {

    	Campo campo1 = new Campo();
    	Jugador jugador1 = new Jugador("Jugador1", campo1);
    	Campo campo2 = new Campo();
    	Jugador jugador2 = new Jugador("Jugador2", campo2);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        CartaMonstruo piernaDerechaDeExodia = new PiernaDerechaDeExodia();
        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        CartaEfecto agujeroNegro = new AgujeroNegro();
        CartaEfecto agujeroNegro2 = new AgujeroNegro();
        
        insectoComeHombres.colocarEnCampo(campo1);
        huevoMonstruoso.colocarEnCampo(campo1);
        piernaDerechaDeExodia.colocarEnCampo(campo2);
        cabezaDeExodia.colocarEnCampo(campo2);
        agujeroNegro.colocarEnCampo(campo1);
        agujeroNegro2.colocarEnCampo(campo2);

        agujeroNegro.asignarDuenio(jugador1);
        agujeroNegro.asignarEnemigo(jugador2);
        agujeroNegro.usarEfecto();

        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, huevoMonstruoso.estaDestruida());
        assertEquals(true, cabezaDeExodia.estaDestruida());
        assertEquals(true, piernaDerechaDeExodia.estaDestruida());
        assertEquals(true, agujeroNegro.estaDestruida());

        //Solo elimina a las cartas monstruo
        assertEquals(false, agujeroNegro2.estaDestruida());
    }

    @Test
    public void ColocarMonstruoConUnSacrificio() {

    Campo campo = new Campo();
 
    CartaMonstruo insectoComeHombres = new InsectoComeHombres();
    insectoComeHombres.colocarEnCampo(campo);
    CartaMonstruo chicaMagaOscura = new ChicaMagaOscura();
    chicaMagaOscura.colocarEnCampo(campo);
    assertEquals(true, insectoComeHombres.estaDestruida());
}

    @Test
    public void ColocarMonstruoConDosSacrificios(){

        Campo campo = new Campo();
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.colocarEnCampo(campo);
        CartaMonstruo abismoReluciente = new AbismoReluciente();
        abismoReluciente.colocarEnCampo(campo);
        CartaMonstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
        dragonBlancoDeOjosAzules.colocarEnCampo(campo);


        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, abismoReluciente.estaDestruida());
    }

    @Test
    public void UsarWastelandYBonificarAtaqueDeMisMonstruosYDefensaDelEnemigo() {
    	
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador("jugador atacante", campo1);
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);
        insectoComeHombres.colocarEnCampo(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("jugador atacado", campo2);
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        huevoMonstruoso.colocarEnCampo(campo2);

        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);
        
        CartaTerreno cartaDeCampo = new Wasteland();
        cartaDeCampo.asignarDuenio(atacante);
        cartaDeCampo.asignarEnemigo(atacado);
        cartaDeCampo.colocarEnCampo(campo1);
        cartaDeCampo.usarEfecto();
        
        //Como esta vez hay un efecto de campo, Insecto come hombres deberia ganar
        insectoComeHombres.atacarOtraCarta(huevoMonstruoso);
        
        //Los puntos de vida del atacado tienen que disminuir 50
        assertEquals(7950,atacado.puntosDeVida());

        //Confirmo que la carta atacada fue destruida
        assertEquals(true, huevoMonstruoso.estaDestruida());

    }

    @Test
    public void UsarSogenYBonificarDefensaDeMisMonstruosYAtaqueDelEnemigo(){

        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador("jugador atacante", campo1);
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);
        insectoComeHombres.colocarEnCampo(campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("jugador atacado", campo2);
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        huevoMonstruoso.colocarEnCampo(campo2);

        atacante.agregarEnemigo(atacado);
        atacado.agregarEnemigo(atacante);

        CartaMonstruo acechadorDelCraneo = new AcechadorDelCraneo();
        acechadorDelCraneo.cambiarEstado(new PosicionHorizontal());
        acechadorDelCraneo.asignarDuenio(atacante);
        acechadorDelCraneo.colocarEnCampo(campo1);

        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        cabezaDeExodia.cambiarEstado(new PosicionVertical());
        cabezaDeExodia.asignarDuenio(atacado);
        cabezaDeExodia.colocarEnCampo(campo2);

        CartaTerreno cartaDeCampo2 = new Sogen();
        cartaDeCampo2.asignarDuenio(atacante);
        cartaDeCampo2.asignarEnemigo(atacado);
        cartaDeCampo2.colocarEnCampo(campo1);
        campo2.agregarCartaCampoEnemigo(cartaDeCampo2);
        cartaDeCampo2.usarEfecto();

        //Normalmente la Cabeza de exodia deberia destruir a la otra carta, pero no sucede ya que hay un efecto de campo
        cabezaDeExodia.atacarOtraCarta(acechadorDelCraneo);

        //Los puntos de vida del atacado tienen que disminuir 100
        assertEquals(7900,atacado.puntosDeVida());

        //Confirmo que la carta atacada no fue destruida
        assertEquals(false, acechadorDelCraneo.estaDestruida());
    }

    @Test
    public void UsarOllaDeLaCodiciaYVerQueEnElMazoTengoDosCartasMenos(){
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador jugador = new Jugador("jugador atacante", campo1);
        CartaEfecto ollaDeLaCodicia = new OllaDeLaCodicia();
        ollaDeLaCodicia.asignarDuenio(jugador);
        int cantidadActual = jugador.cantidadDeCartasEnElMazo();
        ollaDeLaCodicia.usarEfecto();
        assertEquals(cantidadActual - 2, jugador.cantidadDeCartasEnElMazo());
    }
}




