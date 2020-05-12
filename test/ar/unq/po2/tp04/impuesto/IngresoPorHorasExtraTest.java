package ar.unq.po2.tp04.impuesto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngresoPorHorasExtraTest {

	IngresoPorHorasExtra ingreso;

	@BeforeEach
	void setUp() throws Exception {
		this.ingreso = new IngresoPorHorasExtra("Mayo", "Salario", Double.valueOf(50000), Integer.valueOf(10));
	}

	@Test
	void test() {
		assertEquals("Mayo", this.ingreso.getMes());
		assertEquals(Double.valueOf(50000), this.ingreso.getMontoPercibido());
		assertEquals(Double.valueOf(0), this.ingreso.getMontoImponible());
		assertEquals(Integer.valueOf(10), this.ingreso.getCantidadHorasExtra());
	}

}
