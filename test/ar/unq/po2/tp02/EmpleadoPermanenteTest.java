package ar.unq.po2.tp02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp02.EmpleadoPermanente;

public class EmpleadoPermanenteTest {
	
	EmpleadoPermanente empleadoCasadoConHijos;
	EmpleadoPermanente empleadoSolteroSinHijos;
	
	@BeforeEach
	void beforeEach() {
		this.empleadoCasadoConHijos = new EmpleadoPermanente(
				"Marty Byrde", 
				"Evergreen 1111", 
				"CASADO", 
				LocalDate.parse("1980-01-01"),
				1000.0f,
				2,
				5
		);
		this.empleadoSolteroSinHijos = new EmpleadoPermanente(
				"Jean-Luc Picard", 
				"Evergreen 2222", 
				"SOLTERO", 
				LocalDate.parse("1980-01-01"),
				1000.0f,
				0,
				1
		);
		
	}
	
//	@Test
//	public void testGetters() {
//		assertEquals(0.15f, this.empleadoCasadoConHijos.getPorcentajeJubilacion());
//		assertEquals(0.10f, this.empleadoCasadoConHijos.getPorcentajeObraSocial());
//	}

	@Test
	void testCalcularSueldoBruto() {
		assertEquals(1650.0f, this.empleadoCasadoConHijos.calcularSueldoBruto());
		assertEquals(1050.0f, this.empleadoSolteroSinHijos.calcularSueldoBruto());
	}
	
	@Test
	void testCalcularRetenciones() {
		assertEquals(452.5f, this.empleadoCasadoConHijos.calcularRetenciones());
		assertEquals(262.5f, this.empleadoSolteroSinHijos.calcularRetenciones());
	}
	
	@Test
	void testCalcularSueldoNeto() {
		assertEquals(1197.5f, this.empleadoCasadoConHijos.calcularSueldoNeto());
		assertEquals(787.5f, this.empleadoSolteroSinHijos.calcularSueldoNeto());
	}
	
	@Test
	void testGetConceptos() {
		assertFalse(this.empleadoCasadoConHijos.getConceptos().isBlank());
		assertFalse(this.empleadoSolteroSinHijos.getConceptos().isBlank());
	}
}
