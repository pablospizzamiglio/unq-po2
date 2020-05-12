package ar.unq.po2.tp05.mercado;

public class ProductoCooperativa extends Producto {

	public ProductoCooperativa(String nombre, Float precio) {
		super(nombre, precio);
	}
	
	@Override
	public Float getPrecio() {
		return super.getPrecio() * 0.9f;
	}

}
