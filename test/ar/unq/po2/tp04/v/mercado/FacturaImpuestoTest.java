package ar.unq.po2.tp04.v.mercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp04.v.mercado.AgenciaRecaudadora;
import ar.unq.po2.tp04.v.mercado.Caja;
import ar.unq.po2.tp04.v.mercado.Factura;
import ar.unq.po2.tp04.v.mercado.FacturaImpuesto;

class FacturaImpuestoTest {
	
	Factura factura;
	Caja caja;

	@BeforeEach
	void setUp() throws Exception {
		this.factura = new FacturaImpuesto(200.5f);
		this.caja = new Caja(new AgenciaRecaudadora());
	}

	@Test
	void testGetMonto() {
		assertEquals(200.5f, this.factura.getMonto());
	}
	
	@Test 
	void testRegistrarEnCaja() {
		this.factura.registrarEnCaja(this.caja);
		assertEquals(200.5f, this.caja.getTotalAPagar());
	}
	

}
