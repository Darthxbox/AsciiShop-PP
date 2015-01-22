import java.util.Arrays;

public class MedianOperation implements Operation {
	
	//Konstruktor
	public MedianOperation() {}
	
	@Override
	public AsciiImage execute(AsciiImage ai) throws OperationException 
	{
		//Variabeln
		String charSet = ai.getCharset();
		String s = "";
		int[] helperArray = new int[9];
		
		AsciiImage aiNew = new AsciiImage(ai);
		
		
		for (int y = 0; y < ai.getHeight(); y++) 
		{
			for (int x = 0; x < ai.getWidth(); x++) 
			{
				for (int y1 = y - 1; y1 <= (y + 1); y1++) 
				{
					for (int x1 = x - 1; x1 <= (x + 1); x1++) 
					{
						if ((x1 < 0) || (y1 < 0) || (x1 == ai.getWidth()) || (y1 == ai.getHeight())) 
						{
							s += charSet.charAt(charSet.length() - 1);
						}
						else 
						{
							s += ai.getPixel(x1, y1);
						}	
					}
				}
				
				//Auf neues Bild anwenden.
				for (int i = 0; i < 9; i++) 
				{
					helperArray[i] = charSet.lastIndexOf(s.charAt(i) + "");
				}
				
				
				Arrays.sort(helperArray);
				
				aiNew.setPixel(x, y, charSet.charAt(helperArray[4]));
				s = "";
			}
		}
		return aiNew;
	}
	
}
