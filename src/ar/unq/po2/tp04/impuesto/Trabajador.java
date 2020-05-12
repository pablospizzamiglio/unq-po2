package ar.unq.po2.tp04.impuesto;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	
	private List<Ingreso> ingresos;

	public Trabajador() {
		this.setIngresos(new ArrayList<Ingreso>());
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	private void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}
	
	public void agregarIngreso(Ingreso ingreso) {
		this.getIngresos().add(ingreso);
	}
	
	public Double getTotalPercibido() {
		return this.getIngresos().stream()
				.map(i -> i.getMontoPercibido())
				.reduce(Double.valueOf(0), (x, y) -> x + y);
	}

	public Double getMontoImponible() {
		return this.getIngresos().stream()
				.map(i -> i.getMontoImponible())
				.reduce(Double.valueOf(0), (x, y) -> x + y);
	}
	
	public Double getImpuestoAPagar() {
		return this.getMontoImponible() * Double.valueOf(0.02);
	}
	
}
