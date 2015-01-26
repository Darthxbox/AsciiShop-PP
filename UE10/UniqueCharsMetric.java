public class UniqueCharsMetric implements Metric<AsciiImage> 
{
	int zahl = 0;
	public int distance(AsciiImage i1, AsciiImage i2) 
	{
		zahl = Math.abs(i1.getUniqueChars() - i2.getUniqueChars());
		return zahl;
	}
}
