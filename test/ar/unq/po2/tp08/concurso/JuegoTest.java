package ar.unq.po2.tp08.concurso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class JuegoTest {
	
	private @Mock Participante participante1;
	private @Mock Participante participante2;
	private @Mock Participante participante3;
	private @Mock Participante participante4;
	private @Mock Participante participante5;
	private @Mock Participante participanteRechazado;
	private ByteArrayOutputStream consolaFalsa;
	private Juego juego;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.consolaFalsa = new ByteArrayOutputStream();
		System.setOut(new PrintStream(consolaFalsa));
		
		when(this.participante1.getNombre()).thenReturn("Participante1");
		when(this.participante2.getNombre()).thenReturn("Participante2");
		when(this.participante3.getNombre()).thenReturn("Participante3");
		when(this.participante4.getNombre()).thenReturn("Participante4");
		when(this.participante5.getNombre()).thenReturn("Participante5");
		
		Map<String, String> enunciados = new HashMap<String, String>();
		enunciados.put("Pregunta1", "Solucion1");
		enunciados.put("Pregunta2", "Solucion2");
		enunciados.put("Pregunta3", "Solucion3");
		enunciados.put("Pregunta4", "Solucion4");
		enunciados.put("Pregunta5", "Solucion5");
		
		this.juego = new Juego(enunciados);
	}
	
	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.juego);
	}
	
	@Test
	void testSolicitarParticipacionYConcursoEsperaAOtrosParticipantes() {
		// exercise
		this.juego.solicitarParticipacion(this.participante1);
		// verify
		verify(this.participante1, never()).recibirNotificacionAceptacion(anySet());
	}
	
	@Test
	void testSolicitarParticipacionYConcursoInicia() {
		// set up	
		this.juego.solicitarParticipacion(this.participante1);
		this.juego.solicitarParticipacion(this.participante2);
		this.juego.solicitarParticipacion(this.participante3);
		this.juego.solicitarParticipacion(this.participante4);
		// exercise
		this.juego.solicitarParticipacion(this.participante5);
		// verify
		verify(this.participante1, times(1)).recibirNotificacionAceptacion(anySet());
		verify(this.participante2, times(1)).recibirNotificacionAceptacion(anySet());
		verify(this.participante3, times(1)).recibirNotificacionAceptacion(anySet());
		verify(this.participante4, times(1)).recibirNotificacionAceptacion(anySet());
		verify(this.participante5, times(1)).recibirNotificacionAceptacion(anySet());
	}
	
	@Test
	void testSolicitarParticipacionDosVeces() {
		// set up	
		this.juego.solicitarParticipacion(this.participante1);
		// exercise
		this.juego.solicitarParticipacion(this.participante1);
		// verify
		assertEquals("No hay más cupos o ya está inscripto", this.consolaFalsa.toString().trim());
	}
	
	@Test
	void testSolicitarParticipacionYEsRechazada() {
		// set up	
		this.juego.solicitarParticipacion(this.participante1);
		this.juego.solicitarParticipacion(this.participante2);
		this.juego.solicitarParticipacion(this.participante3);
		this.juego.solicitarParticipacion(this.participante4);
		this.juego.solicitarParticipacion(this.participante5);
		// exercise
		this.juego.solicitarParticipacion(this.participanteRechazado);
		// verify
		assertEquals("No hay más cupos o ya está inscripto", this.consolaFalsa.toString().trim());
		verify(this.participanteRechazado, never()).recibirNotificacionAceptacion(anySet());
	}
	
	@Test
	void testRecibirSolucionEnunciadoYEsValida() {
		// set up
		this.juego.solicitarParticipacion(this.participante1);
		this.juego.solicitarParticipacion(this.participante2);
		this.juego.solicitarParticipacion(this.participante3);
		this.juego.solicitarParticipacion(this.participante4);
		this.juego.solicitarParticipacion(this.participante5);
		// exercise
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta1", "Solucion1");		
		// verify
		verify(this.participante1, times(1)).recibirNotificacionValidezSolucion("Pregunta1", true);
		verify(this.participante1, times(1)).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
		verify(this.participante2, times(1)).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
		verify(this.participante3, times(1)).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
		verify(this.participante4, times(1)).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
		verify(this.participante5, times(1)).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
	}
	
	@DisplayName("Solución para el punto 3")
	@Test
	void testRecibirSolucionEnunciadoYEsInvalida() {
		// set up
		this.juego.solicitarParticipacion(this.participante1);
		this.juego.solicitarParticipacion(this.participante2);
		this.juego.solicitarParticipacion(this.participante3);
		this.juego.solicitarParticipacion(this.participante4);
		this.juego.solicitarParticipacion(this.participante5);
		// exercise
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta1", "SolucionInvalida");
		// verify
		verify(this.participante1, times(1)).recibirNotificacionValidezSolucion("Pregunta1", false);
		verify(this.participante1, never()).recibirNotificacionEnunciadoResuelto(anyString(), anyString());
		verify(this.participante2, never()).recibirNotificacionEnunciadoResuelto(anyString(), anyString());
		verify(this.participante3, never()).recibirNotificacionEnunciadoResuelto(anyString(), anyString());
		verify(this.participante4, never()).recibirNotificacionEnunciadoResuelto(anyString(), anyString());
		verify(this.participante5, never()).recibirNotificacionEnunciadoResuelto(anyString(), anyString());
	}
	
	@Test
	void testRecibirSolucionEnunciadoParticipantePendienteDeSerAceptado() {
		// exercise
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta1", "Solucion1");
		// verify
		assertEquals("La partida finalizó o usted no es un participante válido", this.consolaFalsa.toString().trim());
		verify(this.participante1, never()).recibirNotificacionValidezSolucion(anyString(), anyBoolean());
	}
	
	@Test
	void testRecibirSolucionEnunciadoCantidadParticipantesInsuficiente() {
		// set up
		this.juego.solicitarParticipacion(this.participante1);
		this.juego.solicitarParticipacion(this.participante2);
		this.juego.solicitarParticipacion(this.participante3);
		this.juego.solicitarParticipacion(this.participante4);
		// exercise
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta1", "Solucion1");		
		// verify
		verify(this.participante1, never()).recibirNotificacionValidezSolucion("Pregunta1", true);
		verify(this.participante1, never()).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
		verify(this.participante2, never()).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
		verify(this.participante3, never()).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
		verify(this.participante4, never()).recibirNotificacionEnunciadoResuelto("Participante1", "Pregunta1");
	}
	
	@Test
	void testRecibirSolucionAUltimaPregunta() {
		// set up
		this.juego.solicitarParticipacion(this.participante1);
		this.juego.solicitarParticipacion(this.participante2);
		this.juego.solicitarParticipacion(this.participante3);
		this.juego.solicitarParticipacion(this.participante4);
		this.juego.solicitarParticipacion(this.participante5);
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta1", "Solucion1");
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta2", "Solucion2");
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta3", "Solucion3");
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta4", "Solucion4");
		// exercise
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta5", "Solucion5");
		// verify
		verify(this.participante1, times(5)).recibirNotificacionValidezSolucion(anyString(), anyBoolean());
		verify(this.participante1, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante2, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante3, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante4, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante5, times(1)).recibirNotificacionGanador("Participante1");
	}
	
	@Test
	void testRecibirSolucionLuegoDeFinalizadoElConcurso() {
		// set up
		this.juego.solicitarParticipacion(this.participante1);
		this.juego.solicitarParticipacion(this.participante2);
		this.juego.solicitarParticipacion(this.participante3);
		this.juego.solicitarParticipacion(this.participante4);
		this.juego.solicitarParticipacion(this.participante5);
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta1", "Solucion1");
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta2", "Solucion2");
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta3", "Solucion3");
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta4", "Solucion4");
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta5", "Solucion5");
		// exercise
		this.juego.recibirSolucionEnunciado(this.participante1, "Pregunta1", "Solucion1");
		// verify
		assertEquals("La partida finalizó o usted no es un participante válido", this.consolaFalsa.toString().trim());
		verify(this.participante1, times(5)).recibirNotificacionValidezSolucion(anyString(), anyBoolean());
		verify(this.participante1, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante2, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante3, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante4, times(1)).recibirNotificacionGanador("Participante1");
		verify(this.participante5, times(1)).recibirNotificacionGanador("Participante1");
	}

}
