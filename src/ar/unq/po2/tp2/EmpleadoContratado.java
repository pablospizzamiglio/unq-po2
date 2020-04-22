package ar.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoContratado extends Empleado {
	
	private Integer numeroContrato;
	private String medioDePago;

	public EmpleadoContratado(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento,Float sueldoBasico, Integer numeroContrato, String medioDePago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.setNumeroContrato(numeroContrato);
		this.setMedioDePago(medioDePago);
	}

	public Integer getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Integer numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}
	
	public Float getRetencionCargosAdministrativos() {
		return 50.0f;
	}

	@Override
	public Float calcularSueldoBruto() {
		return this.getSueldoBasico();
	}

	@Override
	public Float calcularRetenciones() {
		return this.getRetencionCargosAdministrativos();
	}

	@Override
	public String getConceptos() {
		ArrayList<String> conceptos = new ArrayList<String>();
		conceptos.add(String.format("Sueldo Básico $ %.2f", this.getSueldoBasico()));
		conceptos.add(String.format("Retención por Cargos Administrativos ($ %.2f)", this.getRetencionCargosAdministrativos()));
		conceptos.add(String.format("Total Bruto $ %.2f", this.calcularSueldoBruto()));
		conceptos.add(String.format("Total Retenido ($ %.2f)", this.calcularRetenciones()));
		conceptos.add(String.format("Total Neto $ %.2f", this.calcularSueldoNeto()));
		return String.join("\n", conceptos);
	}

}
