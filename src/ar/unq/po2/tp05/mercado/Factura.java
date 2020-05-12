package ar.unq.po2.tp05.mercado;

public abstract class Factura implements Pagable {

	public abstract Float getMonto();
	
	public void registrarEnCaja(Caja caja) {
		caja.incrementarTotalAPagar(this.getMonto());
		caja.notificarAgencia(this);
	}

}
