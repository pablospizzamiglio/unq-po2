package ar.unq.po2.tp04.v.mercado;

public class AgenciaRecaudadora implements Agencia {

	public AgenciaRecaudadora() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registrarPago(Factura factura) {
		System.out.println(String.format("El pago de su factura fue registrado existosamente con un monto de $ %.2f", factura.getMonto()));		
	}

}
