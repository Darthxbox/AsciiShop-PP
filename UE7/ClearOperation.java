public class ClearOperation implements Operation {
	
	//Konstruktor
	public ClearOperation() { }

	//Erzeugt ein neues Bild aus dem Uebergebenen
	@Override
	public AsciiImage execute(AsciiImage ai) throws OperationException {
		return new AsciiImage(ai.getWidth(), ai.getHeight(), ai.getCharset());
	}
	
}
