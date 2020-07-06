package ar.unq.po2.tp05.sistemabancario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SolicitudCreditoPersonalTest {
	
	private @Mock Cliente cliente;
	private Solicitud solicitud;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testConstructor() {
		// exercise
		this.solicitud = new SolicitudCreditoPersonal(cliente, 20000f, 12);
		// verify
		assertNotNull(this.solicitud);
	}
	
	@Test
	void testEsAceptable() {
		// set up
		this.solicitud = new SolicitudCreditoPersonal(cliente, 20000f, 12);
		when(this.cliente.getSueldoNetoAnual()).thenReturn(20000f);
		when(this.cliente.getSueldoMensual()).thenReturn(20000f);
		// exercise
		Boolean resultado = this.solicitud.esAceptable();
		// verify
		assertTrue(resultado);
	}
	
	@Test
	void testNoEsAceptable() {
		// set up
		this.solicitud = new SolicitudCreditoPersonal(cliente, 240000f, 12);
		when(this.cliente.getSueldoNetoAnual()).thenReturn(20000f);
		when(this.cliente.getSueldoMensual()).thenReturn(20000f);
		// exercise
		Boolean resultado = this.solicitud.esAceptable();
		// verify
		assertFalse(resultado);
	}

}
