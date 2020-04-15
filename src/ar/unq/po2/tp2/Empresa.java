package ar.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
	
	private int cuit;
	private String nombre;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();

	
	public Empresa(int cuit, String nombre, ArrayList<Empleado> empleados) {
		this.setCuit(cuit);
		this.setNombre(nombre);
		this.setEmpleados(empleados);
	}

	public int getCuit() {
		return cuit;
	}
	
	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public float totalSueldosNeto() {
		return this.totalSueldosBruto() - this.totalRetenciones();
	}
	
	public float totalSueldosBruto() {
		float totalSueldoBruto = 0.0f;
		for (Empleado empleado : this.getEmpleados()) {
			totalSueldoBruto += empleado.calcularSueldoBruto();
		}
		return totalSueldoBruto;
	}
	
	public float totalRetenciones() {
		float totalRetenciones = 0.0f;
		for (Empleado empleado : this.getEmpleados()) {
			totalRetenciones += empleado.calcularRetenciones();
		}
		return totalRetenciones;
	}
	
	public ArrayList<ReciboHaberes> liquidarSueldos() {
		ArrayList<ReciboHaberes> recibos = new ArrayList<ReciboHaberes>();
		for (Empleado empleado : this.getEmpleados()) {
			recibos.add(new ReciboHaberes(
					empleado.getNombre(),
					empleado.getDireccion(),
					empleado.calcularSueldoBruto(),
					empleado.calcularSueldoNeto(),
					empleado.getConceptos(),
					LocalDate.now()
			));
		}
		return recibos;
	}

}
