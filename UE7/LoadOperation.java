import java.util.Scanner;

public class LoadOperation implements Operation {
	
	//Variabeln
	String data = "";
	String errChar = "illegal character";
	
	//Konstruktor
	public LoadOperation(String data) { this.data = data; }
	
	@Override
	public AsciiImage execute(AsciiImage img) throws OperationException 
	{
		Scanner sc = new Scanner(data);
		String s;
		int y = 0;
		AsciiImage aiNew = new AsciiImage(img);
		
		//Pixel werden auf Zeichen gesetzt und dabei mit dem verfuegbaren Zeichensatz verglichen
		while (sc.hasNextLine()) 
		{
			s = sc.nextLine();

			for (int i = 0; i < aiNew.getWidth(); i++) 
			{
			if (!aiNew.getCharset().contains(s.charAt(i) + "")) 
			{
				OperationException err = new OperationException(errChar);
				throw err;
			}
			
			aiNew.setPixel(i, y, s.charAt(i));
			}
			y++;
		}
		//System.out.println(y;aiNew.getHeight);
		
		//Vergleich mit create-Dimension
		if (y > aiNew.getHeight())
		{
			OperationException err = new OperationException("Too less data input!");
				throw err;
		}
			
		if (y < aiNew.getHeight()) 
		{
		OperationException err = new OperationException("Too much data input!");
				throw err;
		}
		return aiNew;
	}
}
