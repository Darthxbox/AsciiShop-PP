public class BinaryOperation implements Operation {
	
	//Variabeln
	char grenze;
	String zeichenFolge = "";
	
	//Konstruktor
	public BinaryOperation(char grenze) { this.grenze = grenze;}
	
	//Methode zur Umwandlung in Binaerbild. Dabei wird nur die spezielle Helligkeitspalette angewendet.
	@Override
	public AsciiImage execute(AsciiImage ai) throws OperationException 
	{
	
		AsciiImage aiNew = new AsciiImage(ai);
		zeichenFolge = ai.getCharset();
		int sWert = zeichenFolge.lastIndexOf(grenze + "");
		
		if (!zeichenFolge.contains(grenze + ""))
		{
			OperationException err = new OperationException();
			throw err;
		}
		
		for (int i = 0; i < ai.getHeight(); i++) 
		{
			for (int j = 0; j < ai.getWidth(); j++) 
			{
				if (zeichenFolge.lastIndexOf(ai.getPixel(j, i) + "") < sWert)
				{
					aiNew.setPixel(j, i, zeichenFolge.charAt(0));	
				}
				else 
				{
					aiNew.setPixel(j, i, zeichenFolge.charAt(zeichenFolge.length() - 1));
				}
			}
		}
		//System.out.println(ai.toString()+"======="+aiNew.toString());
		return aiNew;
	}
}
