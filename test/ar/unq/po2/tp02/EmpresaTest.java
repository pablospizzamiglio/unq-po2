package ar.unq.po2.tp02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTest {
	
	Empresa empresa;
	
	@BeforeEach
    void beforeEach() {
        Empleado empleadoTemporarioCasado = new EmpleadoTemporario(
				"Luke Skywalker", 
				"Evergreen 3333", 
				"CASADO", 
				LocalDate.parse("1980-01-01"),
				40.0f,
				LocalDate.parse("2020-12-01"),
				35
		);
        Empleado empleadoPermanenteCasadoConHijos = new EmpleadoPermanente(
				"Marty Byrde", 
				"Evergreen 1111", 
				"CASADO", 
				LocalDate.parse("1980-01-01"),
				1000.0f,
				2,
				5
		);
		Empleado empleadoPermanenteSolteroSinHijos = new EmpleadoPermanente(
				"Jean-Luc Picard", 
				"Evergreen 2222", 
				"SOLTERO", 
				LocalDate.parse("1980-01-01"),
				1000.0f,
				0,
				1
		);
		Empleado empleadoContratadoCasado = new EmpleadoContratado(
				"Walter White", 
				"Evergreen 1111", 
				"CASADO", 
				LocalDate.parse("1980-01-01"),
				1000.0f,
				1234556,
				"TRANSFERENCIA"
		);
		this.empresa = new Empresa(9876542, "AntsyCoder SA");
		this.empresa.addEmpleado(empleadoTemporarioCasado);
		this.empresa.addEmpleado(empleadoPermanenteCasadoConHijos);
		this.empresa.addEmpleado(empleadoPermanenteSolteroSinHijos);
		this.empresa.addEmpleado(empleadoContratadoCasado);
		
    }
	
	@Test
	void testGetters() {
		assertEquals(9876542, this.empresa.getCuit());
		assertEquals("AntsyCoder SA", this.empresa.getNombre());
	}
	
	@Test
	void testCalcularSueldoBruto() {
		assertEquals(5100.0f, this.empresa.totalSueldosBruto());		
	}
	
	@Test
	void testCalcularRetenciones() {
		assertEquals(1220.0f, this.empresa.totalRetenciones());
	}
	
	@Test
	void testCalcularSueldoNeto() {
		assertEquals(3880.0f, this.empresa.totalSueldosNeto());	
	}
	
	@Test
	void testLiquidarSueldos() {
		assertEquals(4, this.empresa.liquidarSueldos().size());	
	}

}
