package ar.unq.po2.tp04.supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	
	private String nombre;
	private String direccion;
	private List<Producto> productos;

	public Supermercado(String nombre, String direccion) {
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setProductos(new ArrayList<Producto>());
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	private void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Integer getCantidadDeProductos() {
		return this.getProductos().size();
	}
	
	public void agregarProducto(Producto producto) {
		this.getProductos().add(producto);
	}
	
	public Double getPrecioTotal() {
		return this.getProductos().stream()
				.map(p -> p.getPrecio())
				.reduce(Double.valueOf(0), (x, y) -> x + y);
	}

}
