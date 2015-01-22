public class ClearOperation implements Operation {
	
	public ClearOperation() {
	}

	@Override
	public AsciiImage execute(AsciiImage img) throws OperationException {
		return new AsciiImage(img.getWidth(), img.getHeight(), img.getCharset());
	}
	
}
