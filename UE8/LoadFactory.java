import java.util.Scanner;

public class LoadFactory implements Factory {
	
	public LoadFactory() { }
	
	@Override
	public Operation create(Scanner scanner) throws FactoryException 
	{
		String content = "";
		String sLine= "";
		String loadFlag = "";
		
		if (scanner.hasNext())
		{
			loadFlag = scanner.next();
		}
		else 
		{
			FactoryException err = new FactoryException();
			throw err;
		}
		
		scanner.nextLine();
		
		while (scanner.hasNextLine()) 
		{
			sLine = scanner.nextLine();
			if (sLine.contains(loadFlag))
			{
				//System.out.println("Load-Flag gefunden!");
				break;
			}
			content += sLine + "\n";
		}
		return new LoadOperation(content);
		}
}
