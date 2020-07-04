package ar.unq.po2.tp08.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CriterioCompuestoTest {
	
	private @Mock Criterio criterioA;
	private @Mock Criterio criterioB;
	private @Mock Articulo articulo;
	private CriterioCompuesto criterio;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.criterio = new CriterioCompuesto();
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.criterio);
	}
	
	@Test
	void testGetCriterios() {
		// verify
		assertTrue(this.criterio.getCriterios().isEmpty());
	}
	
	@Test
	void testAgregarCriterio() {
		// exercise
		this.criterio.agregarCriterio(this.criterioA);
		// verify
		assertEquals(1, this.criterio.getCriterios().size());
	}
	
	@Test
	void testRemoverCriterio() {
		// set up
		this.criterio.agregarCriterio(this.criterioA);
		// exercise
		this.criterio.removerCriterio(this.criterioA);
		// verify
		assertEquals(0, this.criterio.getCriterios().size());
	}
	
	@Test
	void testEsDeInteresTrue() {
		// set up
		when(this.criterioA.esDeInteres(any(Articulo.class))).thenReturn(true);
		when(this.criterioB.esDeInteres(any(Articulo.class))).thenReturn(false);
		this.criterio.agregarCriterio(this.criterioA);
		this.criterio.agregarCriterio(this.criterioB);
		// exercise
		Boolean resultado = this.criterio.esDeInteres(this.articulo);
		// verify
		assertTrue(resultado);
	}
	
	@Test
	void testEsDeInteresFalse() {
		// set up
		when(this.criterioA.esDeInteres(any(Articulo.class))).thenReturn(false);
		when(this.criterioB.esDeInteres(any(Articulo.class))).thenReturn(false);
		this.criterio.agregarCriterio(this.criterioA);
		this.criterio.agregarCriterio(this.criterioB);
		// exercise
		Boolean resultado = this.criterio.esDeInteres(this.articulo);
		// verify
		assertFalse(resultado);
	}

}