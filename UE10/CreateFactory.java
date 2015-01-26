import java.util.Scanner;

public class CreateFactory implements Factory 
{
	//Variabeln
	boolean error = false;
	String charset = null;
	int width = 0;
	int height = 0;
	
	//Konstruktor
	public CreateFactory() { }
	
	//Neue Create-Funktion, prueft ebenfalls Eingaben.
	public Operation create(Scanner scanner) throws FactoryException 
	{
	
		
		
		
		if (scanner.hasNextInt()) 
		{	
			width = scanner.nextInt();
			if (width <= 0)
				{ 
					error = true; 
				}	
		}
		else 
		{
			error = true;	
		}
		
		if (scanner.hasNextInt() && !error) 
		{
			height = scanner.nextInt();
			if ((height <= 0) && !error) 
				{ 
					error = true; 
				}
		}
		else
		{
			error = true;
		}
		
		if (scanner.hasNext() && !error) 
		{
			charset = scanner.next();
		}
		
		else 
		{
			error = true;	
		}
		
		if (error == true) 
		{
			FactoryException err = new FactoryException();
			throw err;
		}
		return new CreateOperation(width, height, charset);
	}
}
