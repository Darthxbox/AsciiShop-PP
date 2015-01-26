import java.util.Scanner;

public class ClearFactory implements Factory {
	
	//Konstruktor
	public ClearFactory() { }
	
	//Methode fuer Operation mit Scanner-Objekt
	@Override
	public Operation create(Scanner scanner) throws FactoryException { return new ClearOperation(); }
}
