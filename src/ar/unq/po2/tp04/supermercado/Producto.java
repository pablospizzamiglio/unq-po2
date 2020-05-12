package ar.unq.po2.tp04.supermercado;

public class Producto {
	
	private String nombre;
	private Double precioBase;
	private Boolean esPrecioCuidado;

	public Producto(String nombre, Double precioBase) {
		this.setNombre(nombre);
		this.setPrecioBase(precioBase);
		this.setEsPrecioCuidado(false);
	}

	public Producto(String nombre, Double precioBase, Boolean esPrecioCuidado) {
		this.setNombre(nombre);
		this.setPrecioBase(precioBase);
		this.setEsPrecioCuidado(esPrecioCuidado);
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected Double getPrecioBase() {
		return precioBase;
	}

	protected void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	protected void setEsPrecioCuidado(Boolean esPrecioCuidado) {
		this.esPrecioCuidado = esPrecioCuidado;
	}
	
	public Boolean esPrecioCuidado() {
		return esPrecioCuidado;
	}
	
	public Double getPrecio() {
		return this.getPrecioBase();
	}
	
	public void aumentarPrecio(Double incremento) {
		this.setPrecioBase(this.getPrecioBase() + incremento);
	}

}
