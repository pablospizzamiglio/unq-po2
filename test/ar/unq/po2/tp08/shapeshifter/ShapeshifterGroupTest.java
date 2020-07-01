package ar.unq.po2.tp08.shapeshifter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShapeshifterGroupTest {
	
	private IShapeshifter singleA;
	private IShapeshifter singleB;
	private IShapeshifter shapeshifter;

	@BeforeEach
	void setUp() throws Exception {
		this.singleA = new Shapeshifter(1);
		this.singleB = new Shapeshifter(2);
		this.shapeshifter = new ShapeshifterGroup(List.of(this.singleA, this.singleB));
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
		assertEquals(1, actual);
	}
	
	@Test
	void testFlat() {
		// SUT
		IShapeshifter flat = this.shapeshifter.flat();
		// verify
		assertNotNull(flat);
		assertNotEquals(0, flat.deepest());
		assertEquals(this.shapeshifter.values(), flat.values());
	}
	
	@Test
	void testValues() {
		// SUT
		List<Integer> actual = this.shapeshifter.values();
		// verify
		assertEquals(List.of(1, 2), actual);
	}
	
	@Test
	void testCompose() {
		IShapeshifter single3 = new Shapeshifter(3);
		IShapeshifter single4 = new Shapeshifter(4);
		IShapeshifter shapeshifter2 = new ShapeshifterGroup(List.of(single3, single4));
		// SUT
		IShapeshifter composite = this.shapeshifter.compose(shapeshifter2);
		// verify
		assertNotNull(composite);
		assertEquals(2, composite.deepest());
		assertEquals(List.of(1, 2, 3, 4), composite.values());
	}
	
	@DisplayName("Example C from TP")
	@Test
	void testMultipleComposition() {
		// set up
		IShapeshifter single3 = new Shapeshifter(3);
		IShapeshifter shapeshifter123 = this.shapeshifter.compose(single3);
		IShapeshifter single5 = new Shapeshifter(5);
		IShapeshifter single6 = new Shapeshifter(6);
		IShapeshifter shapeshifter56 = new ShapeshifterGroup(List.of(single5, single6));
		// SUT
		IShapeshifter composite = shapeshifter123.compose(shapeshifter56);
		// verify
		assertNotNull(composite);
		assertEquals(3, composite.deepest());
		assertEquals(List.of(1, 2, 3, 5, 6), composite.values());
	}

}
