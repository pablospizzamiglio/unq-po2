package ar.unq.po2.tp04.impuesto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoTest {
	
	Ingreso ingreso;

	@BeforeEach
	void setUp() throws Exception {
		this.ingreso = new Ingreso("Mayo", "Salario", Double.valueOf(50000));
	}

	@Test
	void test() {
		assertEquals("Mayo", this.ingreso.getMes());
		assertEquals(Double.valueOf(50000), this.ingreso.getMontoPercibido());
		assertEquals(Double.valueOf(50000), this.ingreso.getMontoImponible());
	}

}
