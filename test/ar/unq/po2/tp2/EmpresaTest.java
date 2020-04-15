package ar.unq.po2.tp2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTest {
	
	ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	@BeforeEach
    void beforeEach() {
        this.empleados.clear();
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
		this.empleados = new ArrayList<Empleado>();
		this.empleados.add(empleadoTemporarioCasado);
		this.empleados.add(empleadoPermanenteCasadoConHijos);
		this.empleados.add(empleadoPermanenteSolteroSinHijos);
    }

//	@Test
//	public void test() {	
//		for (ReciboHaberes recibo : empresa.liquidarSueldos()) {
//			System.out.println(recibo.getNombreEmpleado());
//			System.out.println(recibo.getConceptos() + "\n");
//		}
//	}
	
	@Test
	void testGetters() {
		Empresa empresa = new Empresa(9876542, "AntsyCoder SA", this.empleados);
		assertEquals(9876542, empresa.getCuit());
		assertEquals("AntsyCoder SA", empresa.getNombre());
	}
	
	@Test
	void testCalcularSueldoBruto() {
		Empresa empresa = new Empresa(9876542, "AntsyCoder SA", this.empleados);	
		assertEquals(4100.0f, empresa.totalSueldosBruto());		
	}
	
	@Test
	void testCalcularRetenciones() {
		Empresa empresa = new Empresa(9876542, "AntsyCoder SA", this.empleados);	
		assertEquals(1170.0f, empresa.totalRetenciones());
	}
	
	@Test
	void testCalcularSueldoNeto() {
		Empresa empresa = new Empresa(9876542, "AntsyCoder SA", this.empleados);	
		assertEquals(2930.0f, empresa.totalSueldosNeto());	
	}
	
	@Test
	void testLiquidarSueldos() {
		Empresa empresa = new Empresa(9876542, "AntsyCoder SA", this.empleados);	
		assertEquals(3, empresa.liquidarSueldos().size());	
	}

}
