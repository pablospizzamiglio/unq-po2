package ar.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {
	
	Caja caja;
	Producto queso;
	Producto jamon;

	@BeforeEach
	void setUp() throws Exception {
		this.queso = new ProductoCooperativa("Queso", 100.0f);
		this.jamon = new Producto("Jamon",  110.0f);
		
		Inventario inventario = new Inventario();
		inventario.incrementarCantidad(queso);
		inventario.incrementarCantidad(queso);
		inventario.incrementarCantidad(queso);
		inventario.incrementarCantidad(jamon);
		inventario.incrementarCantidad(jamon);
		inventario.incrementarCantidad(jamon);
		inventario.incrementarCantidad(jamon);
		
		this.caja = new Caja(inventario);
	}

	@Test
	void testCalcularMonto() {		
		this.caja.registrar(queso);
		this.caja.registrar(jamon);
		assertEquals(200.0f, caja.calcularMontoTotal());
	}
	
	@Test
	void testCalcularMontoProductoNoDisponible() {	
		this.caja.registrar(queso);
		this.caja.registrar(jamon);
		Producto zapato = new Producto("Zapato", 400.0f);
		this.caja.registrar(zapato);
		assertEquals(200.0f, caja.calcularMontoTotal());
	}
	
	@Test
	void testAnularRegistro() {		
		this.caja.registrar(queso);
		this.caja.registrar(jamon);
		assertEquals(200.0f, caja.calcularMontoTotal());
		this.caja.anular(jamon);
		assertEquals(90.0f, caja.calcularMontoTotal());
		this.caja.anular(queso);
		assertEquals(0.0f, caja.calcularMontoTotal());
		this.caja.anular(queso);
		assertEquals(0.0f, caja.calcularMontoTotal());
	}

}
