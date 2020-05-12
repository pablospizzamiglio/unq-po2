package ar.unq.po2.tp03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.po2.tp03.Counter;

class CounterTest {

	private Counter counter;
	
	@BeforeEach
	void setUp() throws Exception {
		this.counter = new Counter();
		this.counter.addNumber(1);
		this.counter.addNumber(3);
		this.counter.addNumber(5);
		this.counter.addNumber(7);
		this.counter.addNumber(9);
		this.counter.addNumber(1);
		this.counter.addNumber(1);
		this.counter.addNumber(1);
		this.counter.addNumber(1);
		this.counter.addNumber(4);
	}

	@Test
	void testEvenOccurrences() {
		assertEquals(1, this.counter.getEvenOccurrences());
	}
	
	@Test
	void testOddOccurrences() {
		assertEquals(9, this.counter.getOddOccurrences());
	}
	
	@Test
	void testMultiplesOf3() {
		assertEquals(2, this.counter.getMultiples(3));
	}
	
	@Test
	void testMultiplesOf0() {
		assertEquals(0, this.counter.getMultiples(0));
	}

}
