import java.util.Iterator;

public class SaveOperation implements Operation 
{
	//Variabeln
	MetricSet<AsciiImage> saved;
	boolean check = false;
	
	//Konstruktor
	public SaveOperation(MetricSet<AsciiImage> saved) 
	{
		this.saved = saved;
	}
	
	//Speicher Eingabe auf Ascii-Bild
	public AsciiImage execute(AsciiImage img) throws OperationException 
	{
	
		
		Iterator<AsciiImage> ai = saved.iterator();
		
		while (ai.hasNext()) 
		{
			if (ai.next().equals(img)) 
			{
				check = !check;
			}
		}
		if (!check) 
		{
			saved.add(img);
		}
		
		return new AsciiImage(img);
	}
	
	//Gibt das gerade gespeicherte zurueck
	public MetricSet<AsciiImage> getSaved() 
	{
		return saved;
	}
}
