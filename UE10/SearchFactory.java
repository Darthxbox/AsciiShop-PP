import java.util.Scanner;

public class SearchFactory implements Factory
{
	//Variabeln
	MetricSet<AsciiImage> saved;
	String text = null;
	
	//Konstruktor
	public SearchFactory(MetricSet<AsciiImage> saved) 
	{
		this.saved = saved;
	}
	
	//neue Suche
	public Operation create(Scanner scanner) throws FactoryException 
	{
		if (scanner.hasNext()) 
		{
			text = scanner.next();
			
			if (text.contentEquals("pixelcount")) 
			{
				return new SearchOperation(saved, new PixelCountMetric());
			}
			else
				if (text.contentEquals("uniquechars")) 
				{
					return new SearchOperation(saved, new UniqueCharsMetric());
				}
				else 
				{
					FactoryException err = new FactoryException();
					throw err;
				}
		}
		FactoryException err = new FactoryException();
		throw err;
	}
	
}
