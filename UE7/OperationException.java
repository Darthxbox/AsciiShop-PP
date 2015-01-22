public class OperationException extends Exception 
{
	//Exception mit und ohne Meldung.
	public OperationException() { }
	public OperationException(String meldung) { super(meldung); }
}
