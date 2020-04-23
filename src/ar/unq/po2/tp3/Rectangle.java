package ar.unq.po2.tp3;

public class Rectangle {
	
	private Point origin;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private int base;
	private int height;

	public Rectangle(Point origin, int base, int height) {
		this.setOrigin(origin);
		this.setBase(base);
		this.setHeight(height);
		this.calculateVertices();
	}

	public Point getOrigin() {
		return origin;
	}

	private void setOrigin(Point origin) {
		this.origin = origin;
	}
	
	public Point getPointA() {
		return pointA;
	}

	private void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	private void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	private void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	private void calculateVertices() {
		this.setPointA(new Point(this.getOrigin().getX(), this.getOrigin().getY() + this.getHeight()));
		this.setPointB(new Point(this.getOrigin().getX() + this.getBase(), this.getOrigin().getY() + this.getHeight()));
		this.setPointC(new Point(this.getOrigin().getX() + this.getBase(), this.getOrigin().getY()));
	}
	
	public boolean isHorizontal() {
		return this.getBase() > this.getHeight();
	}
	
	public boolean isVertical() {
		return this.getBase() < this.getHeight();
	}
	
	public Integer calculateArea() {
		return this.getBase() * this.getHeight();
	}
	
	public Integer calculatePerimeter() {
		return 2 * (this.getBase() + this.getHeight());
	}

}
