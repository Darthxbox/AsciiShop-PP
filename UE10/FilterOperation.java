public abstract class FilterOperation implements Operation {
	
	//Konstruktor
	public FilterOperation() { }
	

	//Wendet den Filter an und gibt das dadurch resultierende Bild zurueck.
	@Override
	public AsciiImage execute(AsciiImage ai) throws OperationException {
	
		String zeichensatz = ai.getCharset();
		String s = "";
		AsciiImage aiNew = new AsciiImage(ai);
		
		int[] helperArray = new int[9];
		
		
		for (int y = 0; y < ai.getHeight(); y++) 
		{
			for (int x = 0; x < ai.getWidth(); x++) 
			{
				for (int y1 = y - 1; y1 <= (y + 1); y1++) 
				{
					for (int x1 = x - 1; x1 <= (x + 1); x1++) 
					{
						if ((y1 < 0) || (x1 < 0) || (y1 == ai.getHeight()) || (x1 == ai.getWidth())) 
						{
							s += zeichensatz.charAt(zeichensatz.length() - 1);
						}
						else
						{
							s += ai.getPixel(x1, y1);	
						}
					}
				}
				
				//Auf neues Bild anwenden.
				for (int i = 0; i < 9; i++) {
					helperArray[i] = zeichensatz.lastIndexOf(s.charAt(i) + "");
				}
				
				aiNew.setPixel(x, y, zeichensatz.charAt(filter(helperArray)));
				s = "";
			}
		}
		return aiNew;
	}
	
	//Wendet den neuen Filter mit Helligkeitswerten an. Uebergeben werden die Werte fuer die Helligkeit.
	public abstract int filter(int[] values);
	
}
