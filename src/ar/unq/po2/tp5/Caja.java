package ar.unq.po2.tp5;

public class Caja implements Agencia {
	
	private Inventario inventario;
	private Float totalAPagar;

	public Caja(Inventario inventario) {
		this.setInventario(inventario);
		this.setTotalAPagar(0.0f);
	}

	private Inventario getInventario() {
		return inventario;
	}

	private void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
	public Float getTotalAPagar() {
		return totalAPagar;
	}

	public void setTotalAPagar(Float totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	
	public void registrar(Producto producto) {
		if (this.getInventario().hayDisponibilidad(producto)) {
			this.setTotalAPagar(this.getTotalAPagar() + producto.getPrecio());
			this.getInventario().decrementarCantidad(producto);
		} else {
			System.out.println("El producto solicitado no está disponible");
		}
	}

	@Override
	public void registrarPago(Factura factura) {
		this.setTotalAPagar(this.getTotalAPagar() + factura.getMonto());
	}

}
