package ar.unq.po2.tp08.cultivos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CultivoTrigoTest {

	private CultivoTrigo trigo;

	@BeforeEach
	void setUp() throws Exception {
		this.trigo = new CultivoTrigo();
	}

	@Test
	void testContructor() {
		// verificaci�n
		assertNotNull(this.trigo);
	}
	
	@Test
	void testGetGanancia() {
		// verificaci�n
		assertEquals(300f, this.trigo.getGanancia());
	}

}
