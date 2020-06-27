package ar.unq.po2.tp06.ayudando.al.soberano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaDeAhorroTest {

	CuentaBancaria cajaDeAhorro;

	@BeforeEach
	void setUp() throws Exception {
		this.cajaDeAhorro = new CajaDeAhorro("Clemente", 500);
	}

	@Test
	void testPuedeExtraerTrue() {
		this.cajaDeAhorro.setSaldo(1000);
		assertTrue(this.cajaDeAhorro.puedeExtraer(100));
	}

	@Test
	void testExtraerExitoso() {
		this.cajaDeAhorro.setSaldo(1000);

		this.cajaDeAhorro.extraer(500);

		assertEquals(500, this.cajaDeAhorro.getSaldo());
	}

	@Test
	void testPuedeExtraerFalse() {
		this.cajaDeAhorro.setSaldo(1000);
		assertFalse(this.cajaDeAhorro.puedeExtraer(1000));
	}

	@Test
	void testExtraerFallo() {
		this.cajaDeAhorro.setSaldo(1000);

		this.cajaDeAhorro.extraer(1500);

		assertEquals(1000, this.cajaDeAhorro.getSaldo());
	}

}
