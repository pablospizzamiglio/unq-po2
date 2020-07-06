package ar.unq.po2.tp05.clienteemail;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CorreoTest {
	
	private Correo correo;

	@BeforeEach
	void setUp() throws Exception {
		this.correo = new Correo("Asunto", List.of("DestinatarioA", "DestinatarioB"), "Cuerpo");
	}

	@Test
	void testCorreo() {
		// verify
		assertNotNull(this.correo);
	}
	
	@Test
	void testGetAsunto() {
		// exercise
		String resultado = this.correo.getAsunto();
		// verify
		assertEquals("Asunto", resultado);
	}
	
	@Test
	void testGetDestinatarios() {
		// exercise
		List<String> resultado = this.correo.getDestinatarios();
		// verify
		assertEquals(List.of("DestinatarioA", "DestinatarioB"), resultado);
	}
	
	@Test
	void testGetCuerpo() {
		// exercise
		String resultado = this.correo.getCuerpo();
		// verify
		assertEquals("Cuerpo", resultado);
	}

}
