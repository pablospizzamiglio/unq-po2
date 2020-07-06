package ar.unq.po2.tp10.cuenta;

public class CajaAhorro extends CuentaBancaria {

	public CajaAhorro(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super(historialDeMovimientos, notificador, saldo);
	}

	@Override
	public Boolean puedeExtraer(Integer monto) {
		return this.saldo >= monto;
	}	

}
