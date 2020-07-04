package ar.unq.po2.tp08.eventosdeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AspectoDeporteTest {
	
	private @Mock EventoDeportivo eventoDeportivo;
	private Aspecto aspecto;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		List<String> deportes = List.of("Tennis", "Basket");
		this.aspecto = new AspectoDeporte(deportes);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.aspecto);
	}
	
	@Test
	void testVerifica() {
		// set up
		when(this.eventoDeportivo.getDeporte()).thenReturn("Basket");
		// exercise
		Boolean resultado = this.aspecto.verificar(this.eventoDeportivo);
		// verify
		assertTrue(resultado);
	}

}
