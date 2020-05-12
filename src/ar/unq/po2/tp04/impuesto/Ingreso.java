package ar.unq.po2.tp04.impuesto;

public class Ingreso {
	
	private String mes;
	private String concepto;
	private Double montoPercibido;

	public Ingreso(String mes, String concepto, Double montoPercibido) {
		this.setMes(mes);
		this.setConcepto(concepto);
		this.setMontoPercibido(montoPercibido);
	}

	public String getMes() {
		return mes;
	}

	protected void setMes(String mes) {
		this.mes = mes;
	}

	public String getConcepto() {
		return concepto;
	}

	protected void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Double getMontoPercibido() {
		return montoPercibido;
	}

	protected void setMontoPercibido(Double monto) {
		this.montoPercibido = monto;
	}
	
	public Double getMontoImponible() {
		return this.getMontoPercibido();
	}

}
