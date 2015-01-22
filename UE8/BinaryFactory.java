import java.util.Scanner;

public class BinaryFactory implements Factory {
	
	public BinaryFactory() {}

	char grenze;
	
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
