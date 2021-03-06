import java.util.Scanner;


public class BarPlot
{

  static String repeat(char c, int n)
  {
    String s_repeat = "";
    for(int i=0; i<=n; i++)
      {
	s_repeat += c;
      }
    return s_repeat;
  }
 
 
  static String drawLabel(String label, int n)
  {
    String cutString = "";
  
    if(label.length() > n)
      {
	cutString = label.substring(0, n);
      }
    else
      {
	int i_length = n - label.length();
	cutString = label;
	for(int i = 0;i <=i_length;i++)
	  {
	    cutString += " ";
	  }
      }
    return cutString;
  }
  
  static String drawBar(String label, int value)
  {
    int i_diff = 30 - value;
    String s_blanks = "";
    for(int i = 0; i<i_diff;i++)
    {
      s_blanks += " ";
    }
    String s_bar = drawLabel(label, 8)+"|"+repeat('#',value-1)+s_blanks+"|";
    return s_bar;
  }
  
  static String drawBar(String label, double value)
  {
    double d_barLength = 30 * value;
    int i_barLength = (int) Math.floor(d_barLength);
    int i_diff = 30 - i_barLength; 
    String s_blanks = "";
    for(int i = 0; i<i_diff-1;i++)
    {
      s_blanks += " ";
    }
    if(value >= 0.5)
    {
    	    i_barLength = i_barLength-1;
    }
    String s_bar = drawLabel(label, 8)+"|"+repeat('#',i_barLength)+s_blanks+"|";
    return s_bar;
  }
  
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    double d_value;
    int i_value;
    while (sc.hasNext()) {
	String aLine = sc.nextLine();
	String[] parts = aLine.split(" ");
	String label = parts[0];
	String value = parts[1];
	
		try  
		{  
			d_value = Double.parseDouble(value);  
		}  
		catch(NumberFormatException nfe)  
		{  
			System.out.println("INPUT ERROR");
	  	  	  break;  
	  	}  
	
	
	if(d_value < 1.0)
	{
	  System.out.println(drawBar(label, d_value));
	}
	else
	{
	  i_value = Integer.parseInt(value);
	  	
	  	
	  	if(i_value > 30)
	  	  {
	  	  	  System.out.println("INPUT ERROR");
	  	  	  break;
	  	  }
	  System.out.println(drawBar(label, i_value));
	}
      }
  }
}