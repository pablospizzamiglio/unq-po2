package ar.unq.po2.tp04.v.mercado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp04.v.mercado.AgenciaRecaudadora;
import ar.unq.po2.tp04.v.mercado.Caja;
import ar.unq.po2.tp04.v.mercado.Factura;
import ar.unq.po2.tp04.v.mercado.FacturaServicio;

class FacturaServicioTest {
	
	Factura factura;
	Caja caja;

	@BeforeEach
	void setUp() throws Exception {
		this.factura = new FacturaServicio(2.5f, 100);
		this.caja = new Caja(new AgenciaRecaudadora());
	}

	@Test
	void testGetMonto() {
		assertEquals(250.0f, this.factura.getMonto());
	}
	
	@Test 
	void testRegistrarEnCaja() {
		this.factura.registrarEnCaja(this.caja);
		assertEquals(250.0f, this.caja.getTotalAPagar());
	}
	

}
