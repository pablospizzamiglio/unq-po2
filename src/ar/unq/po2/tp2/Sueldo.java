package ar.unq.po2.tp2;

import java.util.ArrayList;

public abstract class Sueldo {
	
	private ArrayList<Concepto> beneficios;
	private ArrayList<Concepto> retenciones;
	
	
	public Sueldo(ArrayList<Concepto> beneficios, ArrayList<Concepto> retenciones) {
		this.setBeneficios(beneficios);
		this.setRetenciones(retenciones);
	}
	
	public abstract Float getBase();
	
	public ArrayList<Concepto> getBeneficios() {
		return beneficios;
	}

	private void setBeneficios(ArrayList<Concepto> beneficios) {
		this.beneficios = beneficios;
	}

	public ArrayList<Concepto> getRetenciones() {
		return retenciones;
	}

	private void setRetenciones(ArrayList<Concepto> retenciones) {
		this.retenciones = retenciones;
	}

	public Float calcularSueldoBruto(Float sueldoBase) {
		Float beneficios = 0.0f;
		for (Concepto beneficio : this.getBeneficios()) {
			beneficios += beneficio.aplicar(sueldoBase);
		}
		return sueldoBase + beneficios;
	}

	public Float calcularRetenciones(Float sueldoBase) {
		Float sueldoBruto = this.calcularSueldoBruto(sueldoBase);
		Float retenciones = 0.0f;
		for (Concepto beneficio : this.getRetenciones()) {
			retenciones += beneficio.aplicar(sueldoBruto);
		}
		return sueldoBruto - retenciones;
	}

}
