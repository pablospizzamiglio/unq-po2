package ar.unq.po2.tp09.videojuego;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideojuegoTest {
	
	private ByteArrayOutputStream consolaFalsa;
	private Videojuego videojuego;

	@BeforeEach
	void setUp() throws Exception {
		this.consolaFalsa = new ByteArrayOutputStream();
		System.setOut(new PrintStream(consolaFalsa));
		this.videojuego = new Videojuego();
	}
	
	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.videojuego);
	}
	
	@Test
	void testIniciarEstandoEnEstadoInicial() {
		// exercise
		this.videojuego.iniciar();
		// verify
		assertEquals("Ingresa una ficha", this.consolaFalsa.toString().trim());
	}
	
	@Test
	void testIngresarFichaEstandoEnEstadoInicial() {
		// exercise
		this.videojuego.ingresarFicha();
		// verify
		assertEquals("1 crédito(s)", this.consolaFalsa.toString().trim());
	}
	
	@Test
	void testIniciarLuegoDeHaberIngresadoUnaFichaEstandoEnEstadoInicial() {
		// set up
		this.videojuego.ingresarFicha();
		// exercise
		this.videojuego.iniciar(); // Videojuego en EstadoJuegaUno
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 1 jugador en curso", mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIniciarLuegoDeHaberIngresadoDosFichasEstandoEnEstadoInicial() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		// exercise
		this.videojuego.iniciar(); // Videojuego en EstadoJueganDos
		// verify 
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 2 jugadores en curso", mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testFinalizarEstandoEnEstadoInicial() {
		// exercise
		this.videojuego.finalizar();
		// verify
		assertTrue(this.consolaFalsa.toString().trim().isEmpty());
	}
	
	@Test
	void testIniciarEstandoEnEstadoJuegaUno() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganUno
		// exercise
		this.videojuego.iniciar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 1 jugador en curso",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIngresarFichaEstandoEnEstadoJuegaUno() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganUno
		// exercise
		this.videojuego.ingresarFicha();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("1 crédito(s)",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIniciarLuegoDeHaberIngresadoUnaFichaEstandoEnEstadoJuegaUno() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganUno
		this.videojuego.ingresarFicha();
		// exercise
		this.videojuego.iniciar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 1 jugador en curso",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIniciarLuegoDeHaberIngresadoDosFichasEstandoEnEstadoJuegaUno() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganUno
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		// exercise
		this.videojuego.iniciar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 1 jugador en curso",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testFinalizarEstandoEnEstadoJuegaUno() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganUno
		// exercise
		this.videojuego.finalizar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Juego finalizado",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIniciarEstandoEnEstadoJueganDos() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganDos
		// exercise
		this.videojuego.iniciar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 2 jugadores en curso",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIngresarFichaEstandoEnEstadoJueganDos() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganDos
		// exercise
		this.videojuego.ingresarFicha();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("1 crédito(s)",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIniciarLuegoDeHaberIngresadoUnaFichaEstandoEnEstadoJueganDos() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganDos
		this.videojuego.ingresarFicha();
		// exercise
		this.videojuego.iniciar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 2 jugadores en curso",  mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testIniciarLuegoDeHaberIngresadoDosFichasEstandoEnEstadoJueganDos() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganDos
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		// exercise
		this.videojuego.iniciar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Partida de 2 jugadores en curso", mensajes.get(mensajes.size() - 1));
	}
	
	@Test
	void testFinalizarEstandoEnEstadoJueganDos() {
		// set up
		this.videojuego.ingresarFicha();
		this.videojuego.ingresarFicha();
		this.videojuego.iniciar(); // Videojuego en EstadoJueganDos
		// exercise
		this.videojuego.finalizar();
		// verify
		List<String> mensajes = List.of(this.consolaFalsa.toString().trim().split("\n"));
		assertEquals("Juego finalizado",  mensajes.get(mensajes.size() - 1));
	}

}
