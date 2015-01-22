import java.util.Scanner;

public class FilterFactory implements Factory 
{
	
	public FilterFactory() { }
	
	@Override
	public Operation create(Scanner scanner) throws FactoryException 
	{
		if (!scanner.next().contentEquals("median")) 
		{
			FactoryException err = new FactoryException();
			throw err;
		}
		return new MedianOperation();
	}
}
