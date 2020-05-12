package ar.unq.po2.tp04.supermercado;

public class ProductoPrimeraNecesidad extends Producto {
	
	private Double descuento;

	public ProductoPrimeraNecesidad(String nombre, Double precioBase, Boolean esPrecioCuidado, Double descuento) {
		super(nombre, precioBase, esPrecioCuidado);
		this.setDescuento(descuento);
	}
	
	public Double getPrecio() {
		return this.getPrecioBase() * (Double.valueOf(1) - this.getDescuento() / 100);
	}
	
	public Double getDescuento() {
		return descuento;
	}

	private void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

}
