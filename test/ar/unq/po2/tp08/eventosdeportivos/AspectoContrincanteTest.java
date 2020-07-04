package ar.unq.po2.tp08.eventosdeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AspectoContrincanteTest {
	
	private @Mock EventoDeportivo eventoDeportivo;
	private Aspecto aspecto;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		List<String> contrincantes = List.of("Player1", "Player2");
		this.aspecto = new AspectoContrincante(contrincantes);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.aspecto);
	}
	
	@Test
	void testVerificar() {
		// set up
		when(this.eventoDeportivo.getContrincantes()).thenReturn(List.of("Player2", "Player8"));
		// exercise
		Boolean resultado = this.aspecto.verificar(this.eventoDeportivo);
		// verify
		assertTrue(resultado);
	}

}
