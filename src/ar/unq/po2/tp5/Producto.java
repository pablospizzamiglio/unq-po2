package ar.unq.po2.tp5;

public class Producto {
	
	private String nombre;
	private Integer cantidad;
	private Float precio; 
	
	public Producto(String nombre, Float precio) {
		this.setNombre(nombre);
		this.setCantidad(0);
		this.setPrecio(precio);
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	public void incrementarCantidad() {
		this.setCantidad(this.getCantidad() + 1);
	}
	
	public void decrementarCantidad() {
		if (this.getCantidad() > 0) {
			this.setCantidad(this.getCantidad() - 1);
		} else {
			System.out.println("Cantidad insuficiente de " + this.getNombre());
		}
	}

}
