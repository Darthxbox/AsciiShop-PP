import java.util.Scanner;

public class FilterFactory implements Factory 
{
	//Hilfsvariable zur Scanner-Zerlegung
	String filter = "";
	
	//Konstruktor
	public FilterFactory() { }
	
	//Prueft welcher bzw ob ein guelter Filter-Befehl eingelesen wurde. Anschließend wird der entsprechende Filter angewandt.
	@Override
	public Operation create(Scanner scanner) throws FactoryException 
	{
		filter = scanner.next();
		if(filter.contentEquals("median")) 
		{
			return new MedianOperation();
			
		}
		else
		{
			FactoryException err = new FactoryException();
			throw err;
		}
		
	}
	
	
}
