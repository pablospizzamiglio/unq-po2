package ar.unq.po2.tp08.cultivos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CultivoSojaTest {
	
	private CultivoSoja soja;

	@BeforeEach
	void setUp() throws Exception {
		this.soja = new CultivoSoja();
	}

	@Test
	void testContructor() {
		// verificación
		assertNotNull(this.soja);
	}
	
	@Test
	void testGetGanancia() {
		// verificación
		assertEquals(500f, this.soja.getGanancia());
	}

}
