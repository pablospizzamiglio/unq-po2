package ar.unq.po2.tp2;

import java.time.LocalDate;

public class ReciboHaberes {
	
	private String nombreEmpleado;
	private String direccion;
	private Float sueldoBruto;
	private Float sueldoNeto;
	private String conceptos;
	private LocalDate fechaEmision;
	
	public ReciboHaberes(String nombreEmpleado, String direccion, Float sueldoBruto, Float sueldoNeto, String conceptos, LocalDate fechaEmision) {
		this.setNombreEmpleado(nombreEmpleado);
		this.setDireccion(direccion);
		this.setSueldoBruto(sueldoBruto);
		this.setSueldoNeto(sueldoNeto);
		this.setConceptos(conceptos);
		this.setFechaEmision(fechaEmision);
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Float getSueldoBruto() {
		return sueldoBruto;
	}

	public void setSueldoBruto(Float sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}

	public Float getSueldoNeto() {
		return sueldoNeto;
	}

	public void setSueldoNeto(Float sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}

	public String getConceptos() {
		return conceptos;
	}

	public void setConceptos(String conceptos) {
		this.conceptos = conceptos;
	}
	
	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}	

}
