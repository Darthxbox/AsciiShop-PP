import java.util.Scanner;

public class BinaryFactory implements Factory {
	
	//Variabeln
	char grenze;
	
	//Konstruktor
	public BinaryFactory() {}

	
	//Vorbedingungen fuer die BinaerOperation
	@Override
	public Operation create(Scanner scanner) throws FactoryException {
		FactoryException err = new FactoryException();	
		if (scanner.hasNext()) 
		{
			grenze = scanner.next().charAt(0);
		}
		else 
		{
			throw err;
		}
		BinaryOperation bO = new BinaryOperation(grenze);
		return bO;
	}
	
}
