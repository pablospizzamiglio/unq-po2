package ar.unq.po2.tp08.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CriterioPalabraClaveTest {

	private @Mock Articulo articulo;
	private CriterioListaValor criterio;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.criterio = new CriterioPalabraClave(List.of("oop", "patterns"));
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.criterio);
	}
	
	@Test
	void testEsDeInteres() {
		// set up
		when(this.articulo.getPalabrasClave()).thenReturn(List.of("oop"));
		// excercise
		Boolean resultado = this.criterio.esDeInteres(this.articulo);
		// verify
		assertTrue(resultado);
	}

}
