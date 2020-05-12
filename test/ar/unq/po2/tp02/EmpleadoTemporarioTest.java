package ar.unq.po2.tp02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp02.EmpleadoTemporario;

public class EmpleadoTemporarioTest {
	
	EmpleadoTemporario empleadoMenor50Casado;
	EmpleadoTemporario empleadoMayor50Soltero;
	
	@BeforeEach
	void beforeEach() {
		this.empleadoMenor50Casado = new EmpleadoTemporario(
			"Test Tres", 
			"Evergreen 3333", 
			"CASADO", 
			LocalDate.parse("1980-01-01"),
			40.0f,
			LocalDate.parse("2020-12-01"),
			35
		);
		this.empleadoMayor50Soltero = new EmpleadoTemporario(
				"Test Tres", 
				"Evergreen 3333", 
				"SOLTERO", 
				LocalDate.parse("1960-01-01"),
				40.0f,
				LocalDate.parse("2020-12-01"),
				35
			);
	}
	
	@Test
	public void testGetters() {
		assertEquals(LocalDate.parse("2020-12-01"), this.empleadoMenor50Casado.getFechaFinDesignacion());
		assertEquals(LocalDate.parse("2020-12-01"), this.empleadoMayor50Soltero.getFechaFinDesignacion());
	}

	@Test
	void testCalcularSueldoBruto() {
		assertEquals(1400.0f, this.empleadoMenor50Casado.calcularSueldoBruto());
		assertEquals(1400.0f, this.empleadoMayor50Soltero.calcularSueldoBruto());
	}
	
	@Test
	void testCalcularRetenciones() {
		assertEquals(455.0f, this.empleadoMenor50Casado.calcularRetenciones());
		assertEquals(480.0f, this.empleadoMayor50Soltero.calcularRetenciones());
	}
	
	@Test
	void testCalcularSueldoNeto() {
		assertEquals(945.0f, this.empleadoMenor50Casado.calcularSueldoNeto());
		assertEquals(920.0f, this.empleadoMayor50Soltero.calcularSueldoNeto());
	}
	
	@Test
	void testGetConceptos() {
		assertFalse(this.empleadoMenor50Casado.getConceptos().isBlank());
		assertFalse(this.empleadoMayor50Soltero.getConceptos().isBlank());
	}
}
