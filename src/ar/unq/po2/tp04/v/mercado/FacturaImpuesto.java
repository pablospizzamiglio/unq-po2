package ar.unq.po2.tp04.v.mercado;

public class FacturaImpuesto extends Factura {
	
	private Float tasaDeServicio;

	public FacturaImpuesto(Float tasaDeServicio) {
		this.setTasaDeServicio(tasaDeServicio);
	}
	
	private Float getTasaDeServicio() {
		return tasaDeServicio;
	}

	private void setTasaDeServicio(Float tasaDeServicio) {
		this.tasaDeServicio = tasaDeServicio;
	}
	
	public Float getMonto() {
		return this.getTasaDeServicio();
	}

}
