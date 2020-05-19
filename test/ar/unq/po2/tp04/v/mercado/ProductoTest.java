package ar.unq.po2.tp04.v.mercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp04.v.mercado.Producto;

class ProductoTest {
	
	Producto producto;

	@BeforeEach
	void setUp() throws Exception {
		this.producto = new Producto("Jamón Serrano", 200.0f);
	}

	@Test
	void testIncrementarCantidad() {
		assertEquals(0, this.producto.getCantidad());
		this.producto.incrementarCantidad();
		assertEquals(1, this.producto.getCantidad());
	}
	
	@Test
	void testDecrementarCantidad() {
		assertEquals(0, this.producto.getCantidad());
		this.producto.incrementarCantidad();
		assertEquals(1, this.producto.getCantidad());
		this.producto.decrementarCantidad();
		assertEquals(0, this.producto.getCantidad());
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(200.0f, this.producto.getPrecio());
	}
	
	@Test
	void testGetNombre() {
		assertEquals("Jamón Serrano", this.producto.getNombre());
	}

}
