package ar.unq.po2.tp5;

public class Caja {
	
	private Agencia agencia;
	private Float totalAPagar;

	public Caja(Agencia agencia) {
		this.setAgencia(agencia);
		this.setTotalAPagar(0.0f);
	}

	public Agencia getAgencia() {
		return agencia;
	}

	private void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Float getTotalAPagar() {
		return totalAPagar;
	}

	private void setTotalAPagar(Float totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	
	public void incrementarTotalAPagar(Float monto) {
		this.setTotalAPagar(this.getTotalAPagar() + monto);
	}
	
	public void registrar(Pagable pagable) {
		pagable.registrarEnCaja(this);
	}
	
	public void notificarAgencia(Factura factura) {
		this.getAgencia().registrarPago(factura);
	}

}
