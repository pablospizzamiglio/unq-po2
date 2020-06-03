package ar.unq.po2.tp03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectangleTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCreation() {
		Point origin = new Point(2, 2);
		int base = 2;
		int height = 4;
		Rectangle rectangle = new Rectangle(origin, base, height);
		assertEquals(origin.getX(), rectangle.getOrigin().getX());
		assertEquals(origin.getY(), rectangle.getOrigin().getY());
		assertEquals(origin.getX(), rectangle.getPointA().getX());
		assertEquals(origin.getY() + height, rectangle.getPointA().getY());
		assertEquals(origin.getX() + base, rectangle.getPointB().getX());
		assertEquals(origin.getY() + height, rectangle.getPointB().getY());
		assertEquals(origin.getX() + base, rectangle.getPointC().getX());
		assertEquals(origin.getY(), rectangle.getPointC().getY());
	}
	
	@Test
	void testArea() {
		Point origin = new Point(2, 2);
		int base = 2;
		int height = 4;
		Rectangle rectangle = new Rectangle(origin, base, height);
		assertEquals(base * height, rectangle.calculateArea());
	}
	
	@Test
	void testPerimeter() {
		Point origin = new Point(2, 2);
		int base = 2;
		int height = 4;
		Rectangle rectangle = new Rectangle(origin, base, height);
		assertEquals(2 * (base + height), rectangle.calculatePerimeter());
	}
	
	@Test
	void testVertical() {
		Point origin = new Point(2, 2);
		int base = 2;
		int height = 4;
		Rectangle rectangle = new Rectangle(origin, base, height);
		assertEquals(true, rectangle.isVertical());
	}
	
	@Test
	void testHorizontal() {
		Point origin = new Point(2, 2);
		int base = 2;
		int height = 4;
		Rectangle rectangle = new Rectangle(origin, base, height);
		assertEquals(false, rectangle.isHorizontal());
	}

}
