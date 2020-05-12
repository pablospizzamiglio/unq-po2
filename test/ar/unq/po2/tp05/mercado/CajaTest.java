package ar.unq.po2.tp05.mercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp05.mercado.Agencia;
import ar.unq.po2.tp05.mercado.AgenciaRecaudadora;
import ar.unq.po2.tp05.mercado.Caja;
import ar.unq.po2.tp05.mercado.Factura;
import ar.unq.po2.tp05.mercado.FacturaImpuesto;
import ar.unq.po2.tp05.mercado.FacturaServicio;
import ar.unq.po2.tp05.mercado.Producto;
import ar.unq.po2.tp05.mercado.ProductoCooperativa;

class CajaTest {
	
	Caja caja;
	Producto queso;
	Producto jamon;
	Producto zapato;
	Factura edesur;
	Factura abl;

	@BeforeEach
	void setUp() throws Exception {
		this.queso = new ProductoCooperativa("Queso", 100.0f);
		this.queso.incrementarCantidad();
		this.queso.incrementarCantidad();
		this.jamon = new Producto("Jamon",  110.0f);
		this.jamon.incrementarCantidad();
		this.jamon.incrementarCantidad();
		this.zapato = new Producto("Zapato", 400.0f);
		
		this.edesur = new FacturaServicio(0.5f, 1000);
		this.abl = new FacturaImpuesto(650.0f);
		
		Agencia agencia = new AgenciaRecaudadora();
	
		this.caja = new Caja(agencia);
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
		this.caja.registrar(zapato);
		assertEquals(200.0f, caja.getTotalAPagar());
	}
	
	@Test
	void testTotalAPagarFacturas() {		
		this.caja.registrar(edesur);
		this.caja.registrar(abl);
		assertEquals(1150.0f, caja.getTotalAPagar());
	}
	
}
