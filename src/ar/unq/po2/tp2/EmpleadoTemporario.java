package ar.unq.po2.tp2;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpleadoTemporario extends Empleado {
	
	private LocalDate fechaFinDesignacion;
	private Integer cantidadHorasExtra;

	public EmpleadoTemporario(String nombre, String direccion, String estadoCivil, LocalDate fechaNacimiento, Float sueldoBasico, LocalDate fechaFinDesignacion, Integer cantidadHorasExtra) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.setFechaFinDesignacion(fechaFinDesignacion);
		this.setCantidadHorasExtra(cantidadHorasExtra);
	}

	public LocalDate getFechaFinDesignacion() {
		return fechaFinDesignacion;
	}

	public void setFechaFinDesignacion(LocalDate fechaFinDesignacion) {
		this.fechaFinDesignacion = fechaFinDesignacion;
	}

	public int  getCantidadHorasExtra() {
		return cantidadHorasExtra;
	}

	public void setCantidadHorasExtra(Integer cantidadHorasExtra) {
		this.cantidadHorasExtra = cantidadHorasExtra;
	}
	
	public Float getRetencionHoraExtra() {
		return 5f * this.getCantidadHorasExtra();
	}
	
	public Float getRetencionMayor50() {
		Float monto = 0f;
		if (this.edad() > 50) {
			monto = 25f;
		}
		return monto;
	}

	@Override
	public Float calcularSueldoBruto() {
		return this.getSueldoBasico() * this.getCantidadHorasExtra();
	}

	@Override
	public Float calcularRetenciones() {
		return this.getRetencionHoraExtra() + this.getRetencionJubilacion() + this.getRetencionMayor50() + this.getRetencionObraSocial();
	}
	
	@Override
	public String getConceptos() {
		ArrayList<String> conceptos = new ArrayList<String>();
		conceptos.add(String.format("Sueldo Básico por Hora $ %.2f", this.getSueldoBasico()));
		conceptos.add(String.format("Horas Extra %d", this.getCantidadHorasExtra()));
		conceptos.add(String.format("Retención Horas Extra ($ %.2f)", this.getRetencionHoraExtra()));
		conceptos.add(String.format("Retención Aportes Jubilatorios ($ %.2f)", this.getRetencionJubilacion()));
		conceptos.add(String.format("Retención Mayor de 50 Años ($ %.2f)", this.getRetencionMayor50()));
		conceptos.add(String.format("Retención Obra Social ($ %.2f)", this.getRetencionObraSocial()));
		conceptos.add(String.format("Total Bruto $ %.2f", this.calcularSueldoBruto()));
		conceptos.add(String.format("Total Retenido ($ %.2f)", this.calcularRetenciones()));
		conceptos.add(String.format("Total Neto $ %.2f", this.calcularSueldoNeto()));
		return String.join("\n", conceptos);
	}
	
	@Override
	public Float getPorcentajeJubilacion() {
		return 0.10f;
	}

	@Override
	public Float getPorcentajeObraSocial() {
		return 0.10f;
	}

}
