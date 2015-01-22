import java.util.Arrays;

public class MedianOperation implements Operation {
	
	public MedianOperation() {}
	
	@Override
	public AsciiImage execute(AsciiImage img) throws OperationException 
	{
		String charSet = img.getCharset();
		String s = "";
		int[] helperArray = new int[10];
		
		AsciiImage aiNew = new AsciiImage(img);
		
		
		for (int y = 0; y < img.getHeight(); y++) 
		{
			for (int x = 0; x < img.getWidth(); x++) 
			{
				for (int y1 = y - 1; y1 <= (y + 1); y1++) 
				{
					for (int x1 = x - 1; x1 <= (x + 1); x1++) 
					{
						if ((x1 < 0) || (y1 < 0) || (x1 == img.getWidth()) || (y1 == img.getHeight())) 
						{
							s += charSet.charAt(charSet.length() - 1);
						}
						else 
						{
							s += img.getPixel(x1, y1);
						}	
					}
				}
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
