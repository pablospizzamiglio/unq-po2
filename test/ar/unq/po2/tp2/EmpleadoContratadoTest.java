package ar.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoContratadoTest {
	
	EmpleadoContratado empleado;
	
	@BeforeEach
	void beforeEach() {
		this.empleado = new EmpleadoContratado(
				"Walter White", 
				"Evergreen 1111", 
				"CASADO", 
				LocalDate.parse("1980-01-01"),
				1000.0f,
				1234556,
				"TRANSFERENCIA"
		);		
	}

	@Test
	void testGetters() {
		assertEquals(1234556, this.empleado.getNumeroContrato());
		assertEquals("TRANSFERENCIA", this.empleado.getMedioDePago());
	}
	
	@Test
	void testCalcularSueldoBruto() {
		assertEquals(1000.0f, this.empleado.calcularSueldoBruto());
	}
	
	@Test
	void testCalcularRetenciones() {
		assertEquals(50.0f, this.empleado.calcularRetenciones());
	}
	
	@Test
	void testCalcularSueldoNeto() {
		assertEquals(950.0f, this.empleado.calcularSueldoNeto());
	}
	
	@Test
	void testGetConceptos() {
		assertFalse(this.empleado.getConceptos().isBlank());
	}
	
}
