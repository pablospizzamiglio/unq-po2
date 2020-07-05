package ar.unq.po2.tp08.concurso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
//import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JugadorTest {
	
	private Concurso concurso;
	private ByteArrayOutputStream consolaFalsa;
	private Jugador jugador;

	@BeforeEach
	void setUp() throws Exception {
		Map<String, String> enunciados = new HashMap<String, String>();
		enunciados.put("Pregunta1", "Solucion1");
		enunciados.put("Pregunta2", "Solucion2");
		enunciados.put("Pregunta3", "Solucion3");
		enunciados.put("Pregunta4", "Solucion4");
		enunciados.put("Pregunta5", "Solucion5");
		this.concurso = spy(new Juego(enunciados));
		
		this.consolaFalsa = new ByteArrayOutputStream();
		System.setOut(new PrintStream(consolaFalsa));
		
		this.jugador = new Jugador("Jugador", this.concurso);
	}
	
	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.jugador);
		verify(this.concurso, times(1)).solicitarParticipacion(this.jugador);
	}
	
	@Test
	void testGetNombre() {
		// exercise
		String resultado = this.jugador.getNombre();
		// verify
		assertEquals("Jugador", resultado);
	}
	
	@Test
	void testEstaListo() {
		// exercise
		Boolean resultado = this.jugador.estaListo();
		// verify
		assertFalse(resultado);
	}
	
	@Test
	void testGetEnunciados() {
		// exercise
		Map<String, Boolean> resultado = this.jugador.getEnunciados();
		// verify
		assertTrue(resultado.isEmpty());
	}
	
	@Test
	void testRecibirNotificacionAceptacion() {
		// set up
		Set<String> enunciados = Set.of("Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5");
		// exercise
		this.jugador.recibirNotificacionAceptacion(enunciados);
		// verify
		assertEquals(5, this.jugador.getEnunciados().size());
	}
	
	@Test
	void testRecibirNotificacionValidezSolucionTrue() {
		// set up
		Set<String> enunciados = Set.of("Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5");
		this.jugador.recibirNotificacionAceptacion(enunciados);
		// exercise
		this.jugador.recibirNotificacionValidezSolucion("Pregunta1", true);
		// verify
		assertTrue(this.jugador.getEnunciados().get("Pregunta1"));
	}
	
	@Test
	void testRecibirNotificacionValidezSolucionFalse() {
		// set up
		Set<String> enunciados = Set.of("Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5");
		this.jugador.recibirNotificacionAceptacion(enunciados);
		// exercise
		this.jugador.recibirNotificacionValidezSolucion("Pregunta1", false);
		// verify
		assertFalse(this.jugador.getEnunciados().get("Pregunta1"));
	}
	
	@Test
	void testRecibirNotificacionEnunciadoResuelto() {
		// set up
		Set<String> enunciados = Set.of("Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5");
		this.jugador.recibirNotificacionAceptacion(enunciados);
		// exercise
		this.jugador.recibirNotificacionEnunciadoResuelto("OtroJugador", "Pregunta2");
		// verify
		assertEquals("Concursante OtroJugador resolvió el enunciado: Pregunta2", this.consolaFalsa.toString().trim());
	}
	
	@Test
	void testRecibirNotificacionGanador() {
		// set up
		Set<String> enunciados = Set.of("Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5");
		this.jugador.recibirNotificacionAceptacion(enunciados);
		// exercise
		this.jugador.recibirNotificacionGanador("OtroJugador");
		// verify
		assertEquals("Concursante OtroJugador es el ganador!", this.consolaFalsa.toString().trim());
	}
	
	@Test
	void testEnviarSolucion() {
		// set up
		Set<String> enunciados = Set.of("Pregunta1", "Pregunta2", "Pregunta3", "Pregunta4", "Pregunta5");
		this.jugador.recibirNotificacionAceptacion(enunciados);
		// exercise
		this.jugador.enviarSolucion("Pregunta1", "Solucion1");
		// verify
		verify(this.concurso, times(1)).recibirSolucionEnunciado(this.jugador, "Pregunta1", "Solucion1");
	}
	
//	@Test
//	void testResolverEnunciados() throws IOException {
//		// set up
//		Jugador jugador2 = new Jugador("Jugador2", this.concurso);
//		Jugador jugador3 = new Jugador("Jugador3", this.concurso);
//		Jugador jugador4 = new Jugador("Jugador4", this.concurso);
//		Jugador jugador5 = new Jugador("Jugador5", this.concurso);
//		this.jugador.resolverEnunciados();
//	}

}
