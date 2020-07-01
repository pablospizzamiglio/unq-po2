package ar.unq.po2.tp08.cultivosalterados;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp08.cultivosalterados.Cultivo;
import ar.unq.po2.tp08.cultivosalterados.CultivoSimple;

class CultivoSimpleTest {
	
	private Cultivo soja;

	@BeforeEach
	void setUp() throws Exception {
		this.soja = new CultivoSimple("Soja", 500f);
	}

	@Test
	void testContructor() {
		// verificaci�n
		assertNotNull(this.soja);
	}
	
	@Test
	void testGetTipo() {
		// verificaci�n
		assertEquals("Soja", this.soja.getTipo());
	}
	
	@Test
	void testGetGanancia() {
		// verificaci�n
		assertEquals(500f, this.soja.getGanancia());
	}

}
