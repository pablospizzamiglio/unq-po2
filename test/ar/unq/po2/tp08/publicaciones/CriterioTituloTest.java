package ar.unq.po2.tp08.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CriterioTituloTest {
	
	private @Mock Articulo articulo;
	private CriterioTitulo criterio;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.criterio = new CriterioTitulo("Eine Reise Durch Die Zeit: A Journey Through Time");
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.criterio);
	}
	
	@Test
	void testEsDeInteres() {
		// set up
		when(this.articulo.getTitulo()).thenReturn("Eine Reise Durch Die Zeit: A Journey Through Time");
		// excercise
		Boolean resultado = this.criterio.esDeInteres(this.articulo);
		// verify
		assertTrue(resultado);
	}

}
