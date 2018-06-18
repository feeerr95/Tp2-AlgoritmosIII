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
        Jugador atacante = new Jugador(campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);
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
        Jugador atacante = new Jugador(campo2);
        CartaMonstruo huevoMonstruoso = new CartaMonstruo("Huevo Monstruoso", 600, 900, new NivelBasico() );
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador(campo1);
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
        Jugador atacante = new Jugador(campo1);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);
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
        Jugador atacante = new Jugador(campo1);
        CartaMonstruo abismoReluciente = new CartaMonstruo("Abismo Reluciente", 1600, 1800, new NivelBasico());
        abismoReluciente.cambiarEstado(new PosicionVertical());
        abismoReluciente.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador(campo2);
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
        Jugador atacante = new Jugador(campo2);
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);

        //Seteo el atacado
        Campo campo1 = new Campo();
        Jugador atacado = new Jugador(campo1);
        CartaMonstruo abismoReluciente = new CartaMonstruo("Abismo Reluciente", 1600, 1800, new NivelBasico());
        abismoReluciente.cambiarEstado(new PosicionHorizontal());
        abismoReluciente.asignarDuenio(atacado);

        insectoComeHombres.atacarOtraCarta(abismoReluciente);

        //El atacante recibe daÃ±o por tenes menor puntos de ataque que la defensa del atacado
        assertEquals(8000, atacado.puntosDeVida());
        assertEquals(6650, atacante.puntosDeVida());

        //La carta atacante es destruida
        assertEquals(false, abismoReluciente.estaDestruida());
        assertEquals(false, insectoComeHombres.estaDestruida());
    }

    @Test
    public void ColocarYUtilizarAgujeroNegroQueEliminaATodasLasCartas() {

    	Campo campo1 = new Campo();
    	Jugador jugador1 = new Jugador(campo1);
    	Campo campo2 = new Campo();
    	Jugador jugador2 = new Jugador(campo2);

    	Tablero tablero = new Tablero();
    	tablero.cargarJugadores(jugador1, jugador2);

        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        CartaMonstruo piernaDerechaDeExodia = new PiernaDerechaDeExodia();
        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        CartaEfecto agujeroNegro = new AgujeroNegro();
        CartaEfecto agujeroNegro2 = new AgujeroNegro();

        insectoComeHombres.colocarEnCampo(tablero,campo1);
        huevoMonstruoso.colocarEnCampo(tablero,campo1);
        piernaDerechaDeExodia.colocarEnCampo(tablero,campo2);
        cabezaDeExodia.colocarEnCampo(tablero,campo2);
        agujeroNegro.colocarEnCampo(tablero,campo1);
        agujeroNegro2.colocarEnCampo(tablero, campo2);

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
    Tablero tablero = new Tablero();
    CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
    insectoComeHombres.colocarEnCampo(tablero, campo);
    CartaMonstruo chicaMagaOscura = new CartaMonstruo("Chica Maga Oscura", 2000, 1700, new NivelMedio());
    chicaMagaOscura.colocarEnCampo(tablero, campo);

    assertEquals(true, insectoComeHombres.estaDestruida());
}

    @Test
    public void ColocarMonstruoConDosSacrificios(){

        Campo campo = new Campo();
        Tablero tablero = new Tablero();
        CartaMonstruo insectoComeHombres = new CartaMonstruo("Insecto Come-Hombres", 450, 600, new NivelBasico());
        insectoComeHombres.colocarEnCampo(tablero, campo);
        CartaMonstruo abismoReluciente = new CartaMonstruo("Abismo Reluciente", 1600, 1800, new NivelBasico());
        abismoReluciente.colocarEnCampo(tablero, campo);
        CartaMonstruo dragonBlancoDeOjosAzules = new CartaMonstruo("Dragon Blanco De Ojos Azules", 3000, 2500, new NivelAlto());
        dragonBlancoDeOjosAzules.colocarEnCampo(tablero, campo);


        assertEquals(true, insectoComeHombres.estaDestruida());
        assertEquals(true, abismoReluciente.estaDestruida());
    }

    @Test
    public void UsarBonificadoresDeCampoYAtacar() {
    	
    	Tablero tablero = new Tablero();
    	
        //Seteo el atacante
        Campo campo1 = new Campo();
        Jugador atacante = new Jugador("jugador1", campo1);
        CartaMonstruo insectoComeHombres = new InsectoComeHombres();
        insectoComeHombres.cambiarEstado(new PosicionVertical());
        insectoComeHombres.asignarDuenio(atacante);
        insectoComeHombres.colocarEnCampo(tablero, campo1);

        //Seteo el atacado
        Campo campo2 = new Campo();
        Jugador atacado = new Jugador("jugador2", campo2);
        CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
        huevoMonstruoso.cambiarEstado(new PosicionVertical());
        huevoMonstruoso.asignarDuenio(atacado);
        huevoMonstruoso.colocarEnCampo(tablero, campo2);

        tablero.cargarJugadores(atacante, atacado);
        CartaMagica cartaDeCampo = new Wasteland();
        cartaDeCampo.asignarDuenio(atacante);
        cartaDeCampo.colocarEnCampo(tablero, campo1);
        cartaDeCampo.usarEfecto();
        
        //Como esta vez hay un efecto de campo, Insecto come hombres debería ganar
        insectoComeHombres.atacarOtraCarta(huevoMonstruoso);
        
        //Los puntos de vida del atacado tienen que disminuir 50
        assertEquals(7950,atacado.puntosDeVida());

        //Confirmo que la carta atacada fue destruida
        assertEquals(true, huevoMonstruoso.estaDestruida());
    
        CartaMonstruo acechadorDelCraneo = new AcechadorDelCraneo();
        acechadorDelCraneo.cambiarEstado(new PosicionHorizontal());
        acechadorDelCraneo.asignarDuenio(atacante);
        acechadorDelCraneo.colocarEnCampo(tablero, campo1);
        
        CartaMonstruo cabezaDeExodia = new CabezaDeExodia();
        cabezaDeExodia.cambiarEstado(new PosicionVertical());
        cabezaDeExodia.asignarDuenio(atacado);
        cabezaDeExodia.colocarEnCampo(tablero, campo2);
        
        CartaMagica cartaDeCampo2 = new Sogen();
        cartaDeCampo2.asignarDuenio(atacante);
        cartaDeCampo2.colocarEnCampo(tablero, campo1);
        cartaDeCampo2.usarEfecto();
        
        //Normalmente la Cabeza de exodia debería destruir a la otra carta, pero no sucede ya que hay un efecto de campo
        cabezaDeExodia.atacarOtraCarta(acechadorDelCraneo);
        
        //Los puntos de vida del atacado tienen que disminuir 100
        assertEquals(7850,atacado.puntosDeVida());

        //Confirmo que la carta atacada no fue destruida
        assertEquals(false, acechadorDelCraneo.estaDestruida());
        
        
    }
}



