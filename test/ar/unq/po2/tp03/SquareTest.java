package ar.unq.po2.tp03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquareTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCreation() {
		Point origin = new Point(2, 2);
		int side = 2;
		Square rectangle = new Square(origin, side);
		assertEquals(origin.getX(), rectangle.getOrigin().getX());
		assertEquals(origin.getY(), rectangle.getOrigin().getY());
		assertEquals(origin.getX(), rectangle.getPointA().getX());
		assertEquals(origin.getY() + side, rectangle.getPointA().getY());
		assertEquals(origin.getX() + side, rectangle.getPointB().getX());
		assertEquals(origin.getY() + side, rectangle.getPointB().getY());
		assertEquals(origin.getX() + side, rectangle.getPointC().getX());
		assertEquals(origin.getY(), rectangle.getPointC().getY());
	}
	
	@Test
	void testArea() {
		Point origin = new Point(2, 2);
		int side = 2;
		Square square = new Square(origin, side);
		assertEquals(side * side, square.calculateArea());
	}
	
	@Test
	void testPerimeter() {
		Point origin = new Point(2, 2);
		int side = 2;
		Square square = new Square(origin, side);
		assertEquals(2 * (side + side), square.calculatePerimeter());
	}
	
	@Test
	void testVertical() {
		Point origin = new Point(2, 2);
		int side = 2;
		Square square = new Square(origin, side);
		assertEquals(true, square.isVertical());
	}
	
	@Test
	void testHorizontal() {
		Point origin = new Point(2, 2);
		int side = 2;
		Square square = new Square(origin, side);
		assertEquals(true, square.isHorizontal());
	}

}
