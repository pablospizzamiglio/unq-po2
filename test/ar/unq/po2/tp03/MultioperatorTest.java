package ar.unq.po2.tp03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp03.Multioperator;

class MultioperatorTest {

	private Multioperator multioperator;
	
	@BeforeEach
	void setUp() throws Exception {
		this.multioperator = new Multioperator();
		this.multioperator.addNumber(1);
		this.multioperator.addNumber(3);
		this.multioperator.addNumber(5);
		this.multioperator.addNumber(7);
		this.multioperator.addNumber(9);
		this.multioperator.addNumber(1);
		this.multioperator.addNumber(1);
		this.multioperator.addNumber(1);
		this.multioperator.addNumber(1);
		this.multioperator.addNumber(4);
	}

	@Test
	void testSummation() {
		assertEquals(33, this.multioperator.summation());
	}
	
	@Test
	void testSubstraction() {
		assertEquals(-33, this.multioperator.subtraction());
	}
	
	@Test
	void testMultiplaction() {
		assertEquals(3780, this.multioperator.multiplication());
	}

}
