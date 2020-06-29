package ar.unq.po2.tp07.pokerjugadas;

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
		this.unaCarta = new Carta(CartaPalo.PICA, CartaValor.AS);
		
		// verificación
		assertNotNull(this.unaCarta);
	}
	
	@Test
	void testGetValor() {
		// set up
		this.unaCarta = new Carta(CartaPalo.PICA, CartaValor.AS);
		
		// SUT
		CartaValor resultado = this.unaCarta.getValor();
		
		// verificación
		assertEquals(CartaValor.AS, resultado);
	}
	
	@Test
	void testGetPalo() {
		// set up
		this.unaCarta = new Carta(CartaPalo.PICA, CartaValor.AS);
		
		// SUT
		CartaPalo resultado = this.unaCarta.getPalo();
		
		// verificación
		assertEquals(CartaPalo.PICA, resultado);
	}

	@Test
	void testCartasSonDelMismoPalo() {
		// set up
		this.unaCarta = new Carta(CartaPalo.PICA, CartaValor.AS);
		this.otraCarta = new Carta(CartaPalo.PICA, CartaValor.DIEZ);
		
		// SUT
		Boolean resultado = this.unaCarta.mismoPalo(this.otraCarta);
		
		// verificación
		assertTrue(resultado);
	}
	
	@Test
	void testCartasNoSonDelMismoPalo() {
		// set up		
		this.unaCarta = new Carta(CartaPalo.PICA, CartaValor.AS);
		this.otraCarta = new Carta(CartaPalo.DIAMANTE, CartaValor.DIEZ);
		
		// SUT
		Boolean resultado = this.unaCarta.mismoPalo(this.otraCarta);
		
		// verificación
		assertFalse(resultado);
	}
	
	@Test
	void testUnaCartaMayorValorQueOtra() {
		// set up
		this.unaCarta = new Carta(CartaPalo.PICA, CartaValor.AS);
		this.otraCarta = new Carta(CartaPalo.DIAMANTE, CartaValor.DIEZ);
		
		// SUT
		Boolean resultado = this.unaCarta.esDeMayorValor(this.otraCarta);
		
		// verificación
		assertTrue(resultado);
	}
	
	@Test
	void testUnaCartaMenorValorQueOtra() {
		// set up
		this.unaCarta = new Carta(CartaPalo.PICA, CartaValor.DIEZ);
		this.otraCarta = new Carta(CartaPalo.DIAMANTE, CartaValor.AS);
		
		// SUT
		Boolean resultado = this.unaCarta.esDeMayorValor(this.otraCarta);
		
		// verificación
		assertFalse(resultado);
	}

}
