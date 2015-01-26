public class CreateOperation implements Operation {
	
	AsciiImage ai;
	AsciiImage m;
	//Erzeugt neues Ascii-Bild mit Uebergabewerten von Factory
	public CreateOperation(int width, int height, String charset) 
	{
		this.ai = new AsciiImage(width, height, charset);
	}
	
	//Gibt Ascii-Bild zurueck
	public AsciiImage execute(AsciiImage img) throws OperationException 
	{
		m = img;
		return ai;
	}
	
}
