package ar.unq.po2.tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTest {
	
	Caja caja;
	Producto queso;
	Producto jamon;
	Factura edesur;
	Factura abl;

	@BeforeEach
	void setUp() throws Exception {
		this.queso = new ProductoCooperativa("Queso", 100.0f);
		this.jamon = new Producto("Jamon",  110.0f);
		
		this.edesur = new FacturaServicio(0.5f, 1000);
		this.abl = new FacturaImpuesto(650.0f);
		
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
	void testTotalAPagarProductos() {		
		this.caja.registrar(queso);
		this.caja.registrar(jamon);
		assertEquals(200.0f, caja.getTotalAPagar());
	}
	
	@Test
	void testTotalAPagarProductoNoDisponible() {	
		this.caja.registrar(queso);
		this.caja.registrar(jamon);
		Producto zapato = new Producto("Zapato", 400.0f);
		this.caja.registrar(zapato);
		assertEquals(200.0f, caja.getTotalAPagar());
	}
	
	@Test
	void testTotalAPagarFacturas() {		
		this.caja.registrarPago(edesur);
		this.caja.registrarPago(abl);
		assertEquals(1150.0f, caja.getTotalAPagar());
	}
	
}
