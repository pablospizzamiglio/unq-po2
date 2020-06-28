package ar.unq.po2.tp07.cartapoker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {
	
	Carta unaCarta;
	Carta otraCarta;

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testConstructor() {
		// SUT
		this.unaCarta = new Carta("P", 1);
		
		// verificación
		assertNotNull(this.unaCarta);
	}
	
	@Test
	void testGetValor() {
		// set up
		this.unaCarta = new Carta("P", 1);
		
		// SUT
		Integer resultado = this.unaCarta.getValor();
		
		// verificación
		assertEquals(1, resultado);
	}
	
	@Test
	void testGetPalo() {
		// set up
		this.unaCarta = new Carta("P", 1);
		
		// SUT
		String resultado = this.unaCarta.getPalo();
		
		// verificación
		assertEquals("P", resultado);
	}

	@Test
	void testCartasSonDelMismoPalo() {
		// set up
		this.unaCarta = new Carta("P", 1);
		this.otraCarta = new Carta("P", 10);
		
		// SUT
		Boolean resultado = this.unaCarta.mismoPalo(this.otraCarta);
		
		// verificación
		assertTrue(resultado);
	}
	
	@Test
	void testCartasNoSonDelMismoPalo() {
		// set up
		this.unaCarta = new Carta("P", 1);
		this.otraCarta = new Carta("D", 10);
		
		// SUT
		Boolean resultado = this.unaCarta.mismoPalo(this.otraCarta);
		
		// verificación
		assertFalse(resultado);
	}
	
	@Test
	void testUnaCartaMayorValorQueOtra() {
		// set up
		this.unaCarta = new Carta("P", 10);
		this.otraCarta = new Carta("D", 1);
		
		// SUT
		Boolean resultado = this.unaCarta.esDeMayorValor(this.otraCarta);
		
		// verificación
		assertTrue(resultado);
	}
	
	@Test
	void testUnaCartaMenorValorQueOtra() {
		// set up
		this.unaCarta = new Carta("P", 1);
		this.otraCarta = new Carta("D", 10);
		
		// SUT
		Boolean resultado = this.unaCarta.esDeMayorValor(this.otraCarta);
		
		// verificación
		assertFalse(resultado);
	}

}
