package ar.unq.po2.tp08.eventosdeportivos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AspectoCompuestoTest {
	
	private @Mock Aspecto aspectoA;
	private @Mock Aspecto aspectoB;
	private @Mock EventoDeportivo eventoDeportivo;
	private AspectoCompuesto aspecto;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.aspecto = new AspectoCompuesto();
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.aspecto);
	}
	
	@Test
	void testGetAspectos() {
		// verify
		assertTrue(this.aspecto.getAspectos().isEmpty());
	}
	
	@Test
	void testAgregarAspecto() {
		// exercise
		this.aspecto.agregarAspecto(this.aspectoA);
		// verify
		assertEquals(1, this.aspecto.getAspectos().size());
	}
	
	@Test
	void testRemoverAspecto() {
		// set up
		this.aspecto.agregarAspecto(this.aspectoA);
		// exercise
		this.aspecto.removerAspecto(this.aspectoA);
		// verify
		assertEquals(0, this.aspecto.getAspectos().size());
	}
	
	@Test
	void testVerificarTrue() {
		// set up
		when(this.aspectoA.verificar(any(EventoDeportivo.class))).thenReturn(true);
		when(this.aspectoB.verificar(any(EventoDeportivo.class))).thenReturn(false);
		this.aspecto.agregarAspecto(this.aspectoA);
		this.aspecto.agregarAspecto(this.aspectoB);
		// exercise
		Boolean resultado = this.aspecto.verificar(this.eventoDeportivo);
		// verify
		assertTrue(resultado);
	}
	
	@Test
	void testVerificarFalse() {
		// set up
		when(this.aspectoA.verificar(any(EventoDeportivo.class))).thenReturn(false);
		when(this.aspectoB.verificar(any(EventoDeportivo.class))).thenReturn(false);
		this.aspecto.agregarAspecto(this.aspectoA);
		this.aspecto.agregarAspecto(this.aspectoB);
		// exercise
		Boolean resultado = this.aspecto.verificar(this.eventoDeportivo);
		// verify
		assertFalse(resultado);
	}

}
