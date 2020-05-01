package ar.unq.po2.tp5;

public class FacturaImpuesto implements Factura {
	
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
