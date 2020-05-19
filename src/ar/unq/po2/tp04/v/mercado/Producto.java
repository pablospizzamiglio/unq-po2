package ar.unq.po2.tp04.v.mercado;

public class Producto implements Pagable {
	
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
		this.setCantidad(this.getCantidad() - 1);
	}
	
	public boolean hayDisponibilidad() {
		return this.getCantidad() > 1;
	}
	
	@Override
	public void registrarEnCaja(Caja caja) {	
		if (this.hayDisponibilidad()) {
			caja.incrementarTotalAPagar(this.getPrecio());
		} else {
			System.out.println("El producto solicitado no está disponible");
		}
	}

}
