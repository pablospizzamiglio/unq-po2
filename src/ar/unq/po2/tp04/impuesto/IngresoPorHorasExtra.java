package ar.unq.po2.tp04.impuesto;

public class IngresoPorHorasExtra extends Ingreso {
	
	private Integer cantidadHorasExtra;

	public IngresoPorHorasExtra(String mes, String concepto, Double monto, Integer cantidadHorasExtra) {
		super(mes, concepto, monto);
		this.setCantidadHorasExtra(cantidadHorasExtra);
	}
	
	public Integer getCantidadHorasExtra() {
		return cantidadHorasExtra;
	}

	private void setCantidadHorasExtra(Integer cantidadHorasExtra) {
		this.cantidadHorasExtra = cantidadHorasExtra;
	}
	
	@Override
	public Double getMontoImponible() {
		return Double.valueOf(0);
	}

}
