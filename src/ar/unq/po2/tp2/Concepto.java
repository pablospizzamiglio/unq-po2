package ar.unq.po2.tp2;

public abstract class Concepto {
	
	private String descripcion;
	private Float valor;
	
	public Concepto(String descripcion, Float valor) {
		this.setDescripcion(descripcion);
		this.setValor(valor);
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Float getValor() {
		return valor;
	}
	
	private void setValor(Float valor) {
		this.valor = valor;
	}
	
	public abstract Float aplicar(Float monto);

}
