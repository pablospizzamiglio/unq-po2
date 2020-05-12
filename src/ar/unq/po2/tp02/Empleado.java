package ar.unq.po2.tp02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Empleado {

	private String nombre;
	private String direccion;
	private String estadoCivil;
	private LocalDate fechaNacimiento;
	private Float sueldoBasico;
	
	public Empleado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento, Float sueldoBasico) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setEstadoCivil(estadoCivil);
		this.setFechaNacimiento(fechaNacimiento);
		this.setSueldoBasico(sueldoBasico);
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Float getSueldoBasico() {
		return this.sueldoBasico;
	}
	
	public void setSueldoBasico(Float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public Long edad() {
		return ChronoUnit.YEARS.between(this.getFechaNacimiento(), LocalDate.now());
	}

	public Boolean estaCasado() {
		return "CASADO".equalsIgnoreCase(this.getEstadoCivil());
	}
	
	public Float calcularSueldoNeto() {
		return this.calcularSueldoBruto() - this.calcularRetenciones();
	}
	
	public abstract Float calcularSueldoBruto();
	
	public abstract Float calcularRetenciones();
	
	public abstract String getConceptos();
	
}
