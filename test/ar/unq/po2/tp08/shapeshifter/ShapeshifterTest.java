package ar.unq.po2.tp08.shapeshifter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShapeshifterTest {
	
	private Shapeshifter shapeshifter;

	@BeforeEach
	void setUp() throws Exception {
		this.shapeshifter = new Shapeshifter(1);
	}

	@Test
	void testConstructor() {
		// verify
		assertNotNull(this.shapeshifter);
	}
	
	@Test
	void testDeepest() {
		// SUT
		Integer actual = this.shapeshifter.deepest();
		// verify
		assertEquals(0, actual);
	}
	
	@Test
	void testFlat() {
		// SUT
		IShapeshifter actual = this.shapeshifter.flat();
		// verify
		assertEquals(this.shapeshifter, actual);
	}
	
	@Test
	void testValues() {
		// SUT
		List<Integer> actual = this.shapeshifter.values();
		// verify
		assertEquals(List.of(1), actual);
	}

	@DisplayName("Example A from TP")
	@Test
	void testCompose() {
		// set up
		IShapeshifter another = new Shapeshifter(2);
		// SUT
		IShapeshifter composite = this.shapeshifter.compose(another);
		// verify
		assertNotNull(composite);
		assertEquals(1, composite.deepest());
		assertEquals(List.of(1, 2), composite.values());
	}
	
}
