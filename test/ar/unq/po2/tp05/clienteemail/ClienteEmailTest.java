package ar.unq.po2.tp05.clienteemail;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ClienteEmailTest {
	
	private @Mock Servidor servidor;
	private @Mock ColeccionEmail emails;
	private @Mock Correo correoA;
	private @Mock Correo correoB;
	private ClienteEmail cliente;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.cliente = new ClienteEmail("user", "pass", this.servidor, this.emails);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.cliente);
	}
	
	@Test
	void testConectar() {
		// exercise
		this.cliente.conectar();
		// verify
		verify(this.servidor, times(2)).conectar(anyString(), anyString());
	}
	
	@Test
	void testBorrarCorreo() {
		// exercise
		this.cliente.borrarCorreo(this.correoA);
		// verify
		verify(this.emails, times(1)).borrarCorreo(this.correoA);
	}
	
	@Test
	void testEliminarBorrado() {
		// exercise
		this.cliente.eliminarBorrado(this.correoA);
		// verify
		verify(this.emails, times(1)).eliminarBorrado(this.correoA);
	}
	
	@Test
	void testContarBorrados() {
		// set up
		when(this.emails.contarBorrados()).thenReturn(10);
		// exercise
		Integer resultado = this.cliente.contarBorrados();
		// verify
		assertEquals(10, resultado);
		verify(this.emails, times(1)).contarBorrados();
	}
	
	@Test
	void testContarInbox() {
		// set up
		when(this.emails.contarInbox()).thenReturn(10);
		// exercise
		Integer resultado = this.cliente.contarInbox();
		// verify
		assertEquals(10, resultado);
		verify(this.emails, times(1)).contarInbox();
	}
	
	@Test
	void testRecibirNuevos() {
		// exercise
		this.cliente.recibirNuevos();
		// verify
		verify(this.servidor, times(1)).recibirNuevos(anyString(), anyString());
	}
	
	@Test
	void testEnciarCorreo() {
		// exercise
		this.cliente.enviarCorreo("Asunto", List.of("DestinatarioA", "DestinatarioB"), "Cuerpo");
		// verify
		verify(this.servidor, times(1)).enviar(any(Correo.class));
	}

}
