package ar.unq.po2.tp05.sistemabancario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class BancoTest {
	
	private @Mock Cliente cliente;
	private @Mock Solicitud solicitudA;
	private @Mock Solicitud solicitudB;
	private Banco banco;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.banco = new Banco();
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.banco);
	}
	
	@Test
	void testAgregarCliente() {
		// exercise
		this.banco.agregarCliente(this.cliente);
		// verify
		assertEquals(1, this.banco.getClientes().size());
	}
	
	@Test
	void testAgregarSolicitud() {
		// exercise
		this.banco.agregarSolicitud(this.solicitudA);
		// verify
		assertEquals(1, this.banco.getSolicitudes().size());
	}
	
	@Test
	void testMontoADesembolsar() {
		// set up
		when(this.solicitudA.esAceptable()).thenReturn(true);
		when(this.solicitudA.getMonto()).thenReturn(50000f);
		when(this.solicitudB.esAceptable()).thenReturn(false);
		this.banco.agregarSolicitud(this.solicitudA);
		this.banco.agregarSolicitud(this.solicitudB);
		// exercise
		Float resultado = this.banco.montoADesembolsar();
		// verify
		assertEquals(50000f, resultado);
	}

}
