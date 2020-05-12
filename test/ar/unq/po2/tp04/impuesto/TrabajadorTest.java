package ar.unq.po2.tp04.impuesto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrabajadorTest {
	
	Trabajador trabajador;

	@BeforeEach
	void setUp() throws Exception {
		this.trabajador = new Trabajador();
		this.trabajador.agregarIngreso(new Ingreso("Enero", "Salario", Double.valueOf(50000)));
		this.trabajador.agregarIngreso(new IngresoPorHorasExtra("Enero", "Extra", Double.valueOf(2500), Integer.valueOf(2)));
		this.trabajador.agregarIngreso(new Ingreso("Febrero", "Salario", Double.valueOf(50000)));
		this.trabajador.agregarIngreso(new Ingreso("Marzo", "Salario", Double.valueOf(50000)));
		this.trabajador.agregarIngreso(new Ingreso("Abril", "Salario", Double.valueOf(50000)));
		this.trabajador.agregarIngreso(new IngresoPorHorasExtra("Abril", "Extra", Double.valueOf(2500), Integer.valueOf(2)));
	}

	@Test
	void test() {
		assertEquals(Double.valueOf(205000), this.trabajador.getTotalPercibido());
		assertEquals(Double.valueOf(200000), this.trabajador.getMontoImponible());
		assertEquals(Double.valueOf(200000) * Double.valueOf(0.02), this.trabajador.getImpuestoAPagar());
	}

}
