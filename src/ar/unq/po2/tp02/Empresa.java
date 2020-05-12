package ar.unq.po2.tp02;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
	
	private int cuit;
	private String nombre;
	private ArrayList<Empleado> empleados;

	
	public Empresa(int cuit, String nombre) {
		this.setCuit(cuit);
		this.setNombre(nombre);
		this.setEmpleados(new ArrayList<Empleado>());
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
	
	private ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	private void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public void addEmpleado(Empleado empleado) {
		this.getEmpleados().add(empleado);
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
	
	public ArrayList<ReciboHaber> liquidarSueldos() {
		ArrayList<ReciboHaber> recibos = new ArrayList<ReciboHaber>();
		for (Empleado empleado : this.getEmpleados()) {
			recibos.add(new ReciboHaber(empleado, LocalDate.now()));
		}
		return recibos;
	}

}
