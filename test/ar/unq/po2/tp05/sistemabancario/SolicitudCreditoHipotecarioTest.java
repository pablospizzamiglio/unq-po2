package ar.unq.po2.tp05.sistemabancario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SolicitudCreditoHipotecarioTest {
	
	private @Mock Cliente cliente;
	private @Mock Propiedad propiedad;
	private Solicitud solicitud;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testEsAceptable() {
		// set up
		this.solicitud = new SolicitudCreditoHipotecario(this.cliente, 20000f, 12, this.propiedad);
		when(this.cliente.getSueldoNetoAnual()).thenReturn(20000f);
		when(this.cliente.getSueldoMensual()).thenReturn(20000f);
		when(this.cliente.getEdad()).thenReturn(33);
		when(this.propiedad.getValorFiscal()).thenReturn(1000000f);
		// exercise
		Boolean resultado = this.solicitud.esAceptable();
		// verify
		assertTrue(resultado);
	}
	
	@Test
	void testNoEsAceptable() {
		// set up
		this.solicitud = new SolicitudCreditoHipotecario(this.cliente, 800000f, 12, this.propiedad);
		when(this.cliente.getSueldoNetoAnual()).thenReturn(20000f);
		when(this.cliente.getSueldoMensual()).thenReturn(20000f);
		when(this.cliente.getEdad()).thenReturn(33);
		when(this.propiedad.getValorFiscal()).thenReturn(1000000f);
		// exercise
		Boolean resultado = this.solicitud.esAceptable();
		// verify
		assertFalse(resultado);
	}

}
