package ar.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	
	private Inventario inventario;
	private List<Producto> productos;

	public Caja(Inventario inventario) {
		this.setInventario(inventario);
		this.setProductos(new ArrayList<Producto>());
	}

	private Inventario getInventario() {
		return inventario;
	}

	private void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	private List<Producto> getProductos() {
		return productos;
	}

	private void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void registrar(Producto producto) {
		if (this.getInventario().hayDisponibilidad(producto)) {
			this.getProductos().add(producto);
			this.getInventario().decrementarCantidad(producto);
		} else {
			System.out.println("El producto solicitado no está disponible");
		}
	}
	
	public void anular(Producto producto) {
		if (this.getProductos().contains(producto)) {
			this.getProductos().remove(producto);
			this.getInventario().incrementarCantidad(producto);
		} else {
			System.out.println("No puede anular un producto que no fue registrado");
		}
	}
	
	public Float calcularMontoTotal() {
		return this.getProductos().stream()
				.map(producto -> producto.getPrecio())
				.reduce(0.0f, (x, y) -> x + y);
	}

}
