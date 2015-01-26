import java.util.Iterator;

public class SearchOperation implements Operation {
	
	MetricSet<AsciiImage> saved;
	Metric<AsciiImage> m;
	
	//Konstruktor
	public SearchOperation(MetricSet<AsciiImage> saved, Metric<AsciiImage> m) {
		this.saved = saved;
		this.m = m;
	}
	
	//minimale "distance"-Funktion
	public AsciiImage execute(AsciiImage img) throws OperationException 
	{
		if (this.saved == null)
		{
			OperationException err = new OperationException();
			throw err;
		}
		
		MetricSet<AsciiImage> metricS = saved.search(img, this.m);
		
		if (metricS == null) 
		{
			OperationException err = new OperationException();
			throw err;
		}
		
		Iterator<AsciiImage> ai = metricS.iterator();
		
		return new AsciiImage(ai.next());
	}
	
}
