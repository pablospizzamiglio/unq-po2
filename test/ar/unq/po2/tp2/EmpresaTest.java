package ar.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

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
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleadoTemporarioCasado);
		empleados.add(empleadoPermanenteCasadoConHijos);
		empleados.add(empleadoPermanenteSolteroSinHijos);
		empleados.add(empleadoContratadoCasado);
		
		this.empresa = new Empresa(9876542, "AntsyCoder SA", empleados);
    }

	@Test
	public void test() {	
		for (ReciboHaberes recibo : this.empresa.liquidarSueldos()) {
			System.out.println(recibo.getNombreEmpleado());
			System.out.println(recibo.getConceptos() + "\n");
		}
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
