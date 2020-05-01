package ar.unq.po2.tp5;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
	
	private List<Producto> productos;

	public Inventario() {
		this.setProductos(new ArrayList<Producto>());
	}

	private List<Producto> getProductos() {
		return productos;
	}

	private void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public boolean hayProductos() {
		return this.getProductos().isEmpty();
	}
	
	public Integer numeroProductos() {
		return this.getProductos().size();
	}
	
	public Boolean hayDisponibilidad(Producto producto) {
		return this.cantidad(producto) > 0;
	}
	
	private Integer buscar(Producto producto) {
		return this.getProductos().indexOf(producto);
	}
	
	public Integer cantidad(Producto producto) {
		Integer index = this.buscar(producto);
		Integer cantidad = 0;
		if (index != -1) {
			cantidad = this.getProductos().get(index).getCantidad();
		}
		return cantidad;
	}
	
	public void incrementarCantidad(Producto producto) {
		Integer index = this.buscar(producto);
		if (index == -1) {
			producto.incrementarCantidad();
			this.getProductos().add(producto);
		} else {
			this.getProductos().get(index).incrementarCantidad();
		}
	}

	
	public void decrementarCantidad(Producto producto) {
		Integer index = this.buscar(producto);
		if (index != 1) {
			this.getProductos().get(index).decrementarCantidad();
		}
	}

}
