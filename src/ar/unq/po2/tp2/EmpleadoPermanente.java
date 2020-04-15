package ar.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoPermanente extends Empleado {
	
	private Integer cantidadHijos;
	private Integer antiguedad;

	public EmpleadoPermanente(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento, Float sueldoBasico, Integer cantidadHijos, Integer antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		setCantidadHijos(cantidadHijos);
		setAntiguedad(antiguedad);
	}

	public Integer getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(Integer cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public Float getBeneficioCasado() {
		Float monto = 0f;
		if (this.estaCasado()) {
			monto = 100f;
		}
		return monto;
	}
	
	public Float getBeneficioHijos() {
		return 150f * this.getCantidadHijos();
	}
	
	public Float getBeneficioAntiguedad() {
		return 50f * this.getAntiguedad();
	}
	
	public Float getRetencionHijos() {
		return 20f * this.getCantidadHijos();
	}

	@Override
	public Float calcularSueldoBruto() {
		return this.getSueldoBasico() + this.getBeneficioAntiguedad() + this.getBeneficioCasado() + this.getBeneficioHijos();
	}

	@Override
	public Float calcularRetenciones() {
		return this.getRetencionHijos() + this.getRetencionJubilacion() + this.getRetencionObraSocial();
	}
	
	@Override
	public String getConceptos() {
		ArrayList<String> conceptos = new ArrayList<String>();
		conceptos.add(String.format("Sueldo Básico $ %.2f", this.getSueldoBasico()));
		conceptos.add(String.format("Beneficio Antigüedad $ %.2f", this.getBeneficioAntiguedad()));
		conceptos.add(String.format("Beneficio Casado $ %.2f", this.getBeneficioCasado()));
		conceptos.add(String.format("Beneficio Hijos $ %.2f", this.getBeneficioHijos()));
		conceptos.add(String.format("Retención Hijos ($ %.2f)", this.getRetencionHijos()));
		conceptos.add(String.format("Retención Jubilación ($ %.2f)", this.getRetencionJubilacion()));
		conceptos.add(String.format("Retención Obra Social ($ %.2f)", this.getRetencionObraSocial()));
		conceptos.add(String.format("Total Bruto $ %.2f", this.calcularSueldoBruto()));
		conceptos.add(String.format("Total Retenido ($ %.2f)", this.calcularRetenciones()));
		conceptos.add(String.format("Total Neto $ %.2f", this.calcularSueldoNeto()));
		return String.join("\n", conceptos);
	}

	@Override
	public Float getPorcentajeJubilacion() {
		return 0.15f;
	}

	@Override
	public Float getPorcentajeObraSocial() {
		return 0.10f;
	}

}
