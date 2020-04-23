package ar.unq.po2.tp3;

public class Square extends Rectangle {

	public Square(Point origin, int side) {
		super(origin, side, side);
	}
	
	@Override
	public boolean isHorizontal() {
		return this.getBase() == this.getHeight();
	}
	
	@Override
	public boolean isVertical() {
		return this.isHorizontal();
	}

}
