package ar.unq.po2.tp04.v.mercado;

public class FacturaServicio extends Factura {
	
	private Float costoUnidadConsumida;
	private Integer unidadesConsumidas;
	
	public FacturaServicio(Float costoUnidadConsumida, Integer unidadesConsumidas) {
		this.setCostoUnidadConsumida(costoUnidadConsumida);
		this.setUnidadesConsumidas(unidadesConsumidas);
	}

	private Float getCostoUnidadConsumida() {
		return costoUnidadConsumida;
	}
	
	private void setCostoUnidadConsumida(Float costoUnidadConsumida) {
		this.costoUnidadConsumida = costoUnidadConsumida;
	}
	
	private Integer getUnidadesConsumidas() {
		return unidadesConsumidas;
	}
	
	private void setUnidadesConsumidas(Integer unidadesConsumida) {
		this.unidadesConsumidas = unidadesConsumida;
	}

	@Override
	public Float getMonto() {
		return this.getCostoUnidadConsumida() * this.getUnidadesConsumidas();
	}

}
