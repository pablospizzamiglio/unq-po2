package ar.unq.po2.tp08.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SistemaTest {
	
	private @Mock Criterio criterioA;
	private @Mock Criterio criterioB;
	private @Mock Investigador investigadorA;
	private @Mock Investigador investigadorB;
	private @Mock Articulo articulo1;
	private @Mock Articulo articulo2;
	private Sistema sistema;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.sistema = new Sistema();
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.sistema);
	}
	
	@Test
	void testGetArticulos() {
		// verify
		assertTrue(this.sistema.getArticulos().isEmpty());
	}
	
	@Test
	void testGetSuscripciones() {
		// verify
		assertTrue(this.sistema.getArticulos().isEmpty());
	}
	
	@Test
	void testSuscribir() {
		// exercise
		this.sistema.suscribir(this.investigadorA, this.criterioA);
		// verify
		assertEquals(1, this.sistema.getSuscripciones().size());
	}
	
	@Test
	void testDesuscribir() {
		// set up
		this.sistema.suscribir(this.investigadorA, this.criterioA);
		// exercise
		this.sistema.desuscribir(this.investigadorA);
		// verify
		assertEquals(0, this.sistema.getSuscripciones().size());
	}
	
	@Test
	void testAgregarArticulo() {
		// set up
		when(this.criterioA.esDeInteres(any(Articulo.class))).thenReturn(true);
		when(this.criterioB.esDeInteres(any(Articulo.class))).thenReturn(false);
		this.sistema.suscribir(this.investigadorA, this.criterioA);
		this.sistema.suscribir(this.investigadorB, this.criterioB);
		// exercise
		this.sistema.agregarArticulo(this.articulo1);
		// verify		
		InOrder inOrder = inOrder(
			this.criterioA,
			this.investigadorA, 
			this.criterioB,
			this.investigadorB
		);
		inOrder.verify(this.criterioA, times(1)).esDeInteres(this.articulo1);
		inOrder.verify(this.investigadorA, times(1)).actualizar(this.articulo1);
		inOrder.verify(this.criterioB, times(1)).esDeInteres(this.articulo1);
		inOrder.verify(this.investigadorB, never()).actualizar(this.articulo1);
		assertEquals(1, this.sistema.getArticulos().size());
	}

}
