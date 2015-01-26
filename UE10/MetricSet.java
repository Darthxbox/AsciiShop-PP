import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MetricSet<E> extends LinkedHashSet<E> 
{
	
	//Konstruktor ohne Parameter
	public MetricSet() { }
	
	//Initalisierung
	public MetricSet(Collection<? extends E> c) 
	{
		addAll(c);
	}
	
	//MetricSet mit minimalen "distance" von Elementen zu e
	public MetricSet<E> search(E e, Metric<? super E> m) 
	{
	
		if (e == null) { return null; }
		
		Iterator<E> ai = this.iterator();
		if (!ai.hasNext()) { return null; }
		
		E eImage = ai.next();
		E next = null;
		MetricSet<E> metricS = new MetricSet<E>();
		metricS.add(eImage);
		
		while (ai.hasNext()) 
		{
			next = ai.next();
			
			if (m.distance(e, next) < m.distance(e, eImage)) 
			{
				eImage = next;
				metricS = new MetricSet<E>();
				metricS.add(eImage);
			}
			
			else if (m.distance(e, next) == m.distance(e, eImage)) 
			{
				metricS.add(next);
			}
		}
		
		return metricS;
	}
}
