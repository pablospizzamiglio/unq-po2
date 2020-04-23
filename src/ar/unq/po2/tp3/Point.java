package ar.unq.po2.tp3;

public class Point {
	
	private int x;
	private int y;

	public Point() {
		this.setX(0);
		this.setY(0);
	}
	
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Point plus(Point other) {
		return new Point(this.getX() + other.getX(), this.getY() + other.getY());
	}

}
