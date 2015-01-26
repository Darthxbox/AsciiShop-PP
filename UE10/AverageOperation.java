import java.util.Arrays;

public class AverageOperation extends FilterOperation {
	
	//Variabeln
	float wert = 0;
	
	//Konstruktor
	public AverageOperation() {}
	
	
	//Berechnet den Durchschnitt der Werte und gibt diesen zurueck.
	@Override
	public int filter(int[] values) 
	{
		wert = 0;

		for(int i : values)
		{
			wert += i;
		}
		
		wert = (wert / values.length);
		int neu = Math.round(wert);
		
		return neu;
		
	}
	
}
