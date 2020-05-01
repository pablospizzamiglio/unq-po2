package ar.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventarioTest {
	
	Inventario inventario;
	Producto queso;
	Producto jamon;

	@BeforeEach
	void setUp() throws Exception {
		this.queso = new ProductoCooperativa("Queso", 100.0f);
		this.jamon = new Producto("Jamon",  110.0f);
		this.inventario = new Inventario();
	}

	@Test
	void testIncrementar() {
		assertEquals(true, this.inventario.hayProductos());
		this.inventario.incrementarCantidad(this.jamon);
		assertEquals(1, this.inventario.numeroProductos());
		assertEquals(1, this.inventario.cantidad(this.jamon));
	}
	
	@Test
	void testDecrementar() {
		assertEquals(true, this.inventario.hayProductos());
		this.inventario.incrementarCantidad(this.jamon);
		assertEquals(1, this.inventario.numeroProductos());
		assertEquals(1, this.inventario.cantidad(this.jamon));
		this.inventario.decrementarCantidad(this.jamon);
		assertEquals(1, this.inventario.numeroProductos());
		assertEquals(0, this.inventario.cantidad(this.jamon));
		this.inventario.decrementarCantidad(this.jamon);
		assertEquals(0, this.inventario.cantidad(this.jamon));
	}

}
