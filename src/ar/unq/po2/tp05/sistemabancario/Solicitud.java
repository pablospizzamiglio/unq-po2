package ar.unq.po2.tp05.sistemabancario;

public abstract class Solicitud {
	
	private Cliente solicitante;
	private Float monto;
	private Integer plazoEnMeses;
	
	public Solicitud(Cliente solicitante, Float monto, Integer plazoEnMeses) {
		this.setSolicitante(solicitante);
		this.setMonto(monto);
		this.setPlazoEnMeses(plazoEnMeses);
	}

	public Cliente getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Cliente solicitante) {
		this.solicitante = solicitante;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Integer getPlazoEnMeses() {
		return plazoEnMeses;
	}

	public void setPlazoEnMeses(Integer plazoEnMeses) {
		this.plazoEnMeses = plazoEnMeses;
	}
	
	public Float cuotaMensual() {
		return this.getMonto() / this.getPlazoEnMeses();
	}
	
	public abstract Boolean esAceptable();

}
 