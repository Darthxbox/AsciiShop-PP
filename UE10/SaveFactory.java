import java.util.Scanner;

public class SaveFactory implements Factory 
{
	//Variabeln
	MetricSet<AsciiImage>	saved;
	
	//Neues Element fuer die Collection MetricSet
	public SaveFactory(MetricSet<AsciiImage> saved) 
	{
		this.saved = saved;
	}

	//neue Save-Operation
	public Operation create(Scanner scanner) throws FactoryException 
	{
		return new SaveOperation(this.saved);
	}
}
