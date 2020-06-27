package ar.unq.po2.tp06.ayudando.al.soberano;

public class CajaDeAhorro extends CuentaBancaria {

	private int limite;

	public CajaDeAhorro(String titular, int limite) {
		super(titular);
		this.limite = limite;
	}

	public int getLimite() {
		return this.limite;
	}

	@Override
	public Boolean puedeExtraer(int monto) {
		return this.getSaldo() >= monto && this.getLimite() >= monto;
	}

}
