public final class AsciiPoint {
	
	final int x;
	final int y;

	public AsciiPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getY() {
	
		return y;
	}
	
	public int getX() {
	
		return x;
	}

	@Override
	public String toString() {
	
		return "(" + x + "," + y + ")";
	}
	
}
