package ar.unq.po2.tp05.clienteemail;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class ServidorPOPTest {
	
	private @Spy Almacenamiento almacenamiento;
	private @Spy Conexion conexion;
	private Servidor servidor;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.servidor = new ServidorPOP(this.conexion, this.almacenamiento);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.servidor);
	}
	
	@Test
	void testGetAlmacenamiento() {
		// exercise
		Almacenamiento resultado = this.servidor.getAlmacenamiento();
		// verify
		assertEquals(this.almacenamiento, resultado);
	}
	
	@Test
	void testGetConexion() {
		// exercise
		Conexion resultado = this.servidor.getConexion();
		// verify
		assertEquals(this.conexion, resultado);
	}
	
	@Test
	void testConectar() {
		// exercise
		this.servidor.conectar("user", "pass");
		// verify
		verify(this.conexion, times(1)).conectar("user", "pass");
	}
	
	@Test
	void testResetear() {
		// exercise
		this.servidor.resetear();
		// verify
		verify(this.conexion, times(1)).resetear();
	}
	
	@Test
	void testRecibirNuevos() {
		// set up
		Correo correoA = mock(Correo.class);
		Correo correoB = mock(Correo.class);
		List<Correo> correos = List.of(correoA, correoB);
		when(this.almacenamiento.recibirNuevos(anyString(), anyString())).thenReturn(correos);
		when(this.conexion.esValida()).thenReturn(true);
		// exercise
		List<Correo> resultado = this.servidor.recibirNuevos("user", "pass");
		// verify
		assertEquals(correos, resultado);
		verify(this.conexion, times(1)).esValida();
		verify(this.almacenamiento, times(1)).recibirNuevos("user", "pass");
	}
	
	@Test
	void testRecibirNuevosFallo() {
		// set up
		when(this.conexion.esValida()).thenReturn(false);
		// exercise
		List<Correo> resultado = this.servidor.recibirNuevos("user", "pass");
		// verify
		assertTrue(resultado.isEmpty());
		verify(this.conexion, times(1)).esValida();
		verify(this.almacenamiento, never()).recibirNuevos("user", "pass");
	}
	
	@Test
	void testEnviar() {
		// set up
		Correo correo = mock(Correo.class);
		when(this.conexion.esValida()).thenReturn(true);
		// exercise
		this.servidor.enviar(correo);
		// verify
		verify(this.conexion, times(1)).esValida();
		verify(this.almacenamiento, times(1)).enviar(correo);;
	}
	
	@Test
	void testEnviarFallo() {
		// set up
		Correo correo = mock(Correo.class);
		when(this.conexion.esValida()).thenReturn(false);
		// exercise
		this.servidor.enviar(correo);
		// verify
		verify(this.conexion, times(1)).esValida();
		verify(this.almacenamiento, never()).enviar(correo);;
	}
	
	@Test
	void testTazaDeTransferencia() {
		// set up
		when(this.almacenamiento.tazaDeTransferencia()).thenReturn(10f);
		// exercise
		float resultado = this.servidor.tazaDeTransferencia();
		// verify
		assertEquals(10f, resultado);
		verify(this.almacenamiento, times(1)).tazaDeTransferencia();
	}
	
	@Test
	void testRealizarBackUp() {
		// exercise
		this.servidor.realizarBackUp();
		// verify
		verify(this.almacenamiento, times(1)).realizarBackUp();
	}
	
}
