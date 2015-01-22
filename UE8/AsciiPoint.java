public final class AsciiPoint {
	
	//Variabeln
	final int x;
	final int y;

	//Knostruktor
	public AsciiPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Gibt Y zurueck
	public int getY() {
	
		return y;
	}
	
	//Gibt X zurueck
	public int getX() {
	
		return x;
	}

	//Gibt den Punkt mittels dessen Koordinaten X & Y als String zurueck.
	@Override
	public String toString() {
	
		return "(" + x + "," + y + ")";
	}
	
}
