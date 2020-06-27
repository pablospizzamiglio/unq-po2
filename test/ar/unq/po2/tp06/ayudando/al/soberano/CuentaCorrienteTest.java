package ar.unq.po2.tp06.ayudando.al.soberano;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaCorrienteTest {

	CuentaBancaria cuentaCorriente;

	@BeforeEach
	void setUp() throws Exception {
		this.cuentaCorriente = new CuentaCorriente("Clemente", 200);
	}

	@Test
	void testPuedeExtraerTrue() {
		this.cuentaCorriente.setSaldo(1000);
		assertTrue(this.cuentaCorriente.puedeExtraer(100));
	}

	@Test
	void testExtraerExitoso() {
		this.cuentaCorriente.setSaldo(1000);

		this.cuentaCorriente.extraer(500);

		assertEquals(500, this.cuentaCorriente.getSaldo());
	}

	@Test
	void testPuedeExtraerFalse() {
		this.cuentaCorriente.setSaldo(1000);
		assertFalse(this.cuentaCorriente.puedeExtraer(1500));
	}

	@Test
	void testExtraerFallo() {
		this.cuentaCorriente.setSaldo(1000);

		this.cuentaCorriente.extraer(1500);

		assertEquals(1000, this.cuentaCorriente.getSaldo());
	}

}
