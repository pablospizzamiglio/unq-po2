package ar.unq.po2.tp05.clienteemail;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConjuntoEmailTest {
	
	private Correo correoA;
	private Correo correoB;
	private ColeccionEmail emails;

	@BeforeEach
	void setUp() throws Exception {
		this.correoA = new Correo("Asunto", List.of("DestinatarioA"), "Cuerpo");
		this.correoB = new Correo("Asunto", List.of("DestinatarioB"), "Cuerpo");
		this.emails = new ConjuntoEmail();
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.emails);
	}
	
	@Test
	void testContarInbox() {
		// exercise
		Integer resultado = this.emails.contarInbox();
		// verify
		assertEquals(0, resultado);
	}
	
	@Test
	void testContarBorrados() {
		// exercise
		Integer resultado = this.emails.contarBorrados();
		// verify
		assertEquals(0, resultado);
	}
	
	@Test
	void testAgregarCorreo() {
		// exercise
		this.emails.agregar(this.correoA);
		// verify
		assertEquals(1, this.emails.contarInbox());
	}
	
	@Test
	void testAgregarTodos() {
		// exercise
		this.emails.agregarTodos(List.of(this.correoA, this.correoB));
		// verify
		assertEquals(2, this.emails.contarInbox());
	}
	
	@Test
	void testBorrarCorreo() {
		// set up
		this.emails.agregar(this.correoA);
		// exercise
		this.emails.borrarCorreo(this.correoA);
		// verify
		assertEquals(0, this.emails.contarInbox());
		assertEquals(1, this.emails.contarBorrados());
	}
	
	@Test
	void testEliminarBorrados() {
		// set up
		this.emails.agregar(this.correoA);
		this.emails.borrarCorreo(this.correoA);
		// exercise
		this.emails.eliminarBorrado(this.correoA);
		// verify
		assertEquals(0, this.emails.contarInbox());
		assertEquals(0, this.emails.contarBorrados());
	}

}
