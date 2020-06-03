package ar.unq.po2.tp03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class PointTest {

	@Test
	void testPointCreationWithoutParameters() {
		Point point = new Point();
		assertEquals(0, point.getX());
		assertEquals(0, point.getY());
	}
	
	@Test
	void testPointCreationWithParameters() {
		int x = 10;
		int y = 20;
		Point point = new Point(x, y);
		assertEquals(x, point.getX());
		assertEquals(y, point.getY());
	}
	
	@Test
	void testPointSummation() {
		Point pointA = new Point(10, 20);
		Point pointB = new Point(5, 5);
		Point pointAPlusPointB = pointA.plus(pointB);
		assertEquals(15, pointAPlusPointB.getX());
		assertEquals(25, pointAPlusPointB.getY());
	}

}
