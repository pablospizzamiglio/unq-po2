package ar.unq.po2.tp08.eventosdeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


class SistemaTest {

	private @Mock Aspecto aspectoA;
	private @Mock Aspecto aspectoB;
	private @Mock Suscriptor suscriptorA;
	private @Mock Suscriptor suscriptorB;
	private @Mock EventoDeportivo eventoDeportivo;
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
	void testGetEventosDeportivos() {
		// verify
		assertTrue(this.sistema.getEventosDeportivos().isEmpty());
	}
	
	@Test
	void testGetSuscripciones() {
		// verify
		assertTrue(this.sistema.getSuscripciones().isEmpty());
	}
	
	@Test
	void testSuscribir() {
		// exercise
		this.sistema.suscribir(this.suscriptorA, this.aspectoA);
		// verify
		assertEquals(1, this.sistema.getSuscripciones().size());
	}
	
	@Test
	void testDesuscribir() {
		// set up
		this.sistema.suscribir(this.suscriptorA, this.aspectoA);
		// exercise
		this.sistema.desuscribir(this.suscriptorA);
		// verify
		assertEquals(0, this.sistema.getSuscripciones().size());
	}
	
	@Test
	void testAgregarEventoDeportivo() {
		// set up
		when(this.aspectoA.verificar(any(EventoDeportivo.class))).thenReturn(true);
		when(this.aspectoB.verificar(any(EventoDeportivo.class))).thenReturn(false);
		this.sistema.suscribir(this.suscriptorA, this.aspectoA);
		this.sistema.suscribir(this.suscriptorB, this.aspectoB);
		// exercise
		this.sistema.agregarEventoDeportivo(this.eventoDeportivo);
		// verify		
		InOrder inOrder = inOrder(
			this.aspectoA,
			this.suscriptorA, 
			this.aspectoB,
			this.suscriptorB
		);
		inOrder.verify(this.aspectoA, times(1)).verificar(this.eventoDeportivo);
		inOrder.verify(this.suscriptorA, times(1)).recibirEventoDeportivo(this.eventoDeportivo);
		inOrder.verify(this.aspectoB, times(1)).verificar(this.eventoDeportivo);
		inOrder.verify(this.suscriptorB, never()).recibirEventoDeportivo(this.eventoDeportivo);
		assertEquals(1, this.sistema.getEventosDeportivos().size());
	}

}
