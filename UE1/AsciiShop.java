import java.util.Scanner;
import java.io.File;

public class AsciiShop
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int origin_c_width = 0;
    boolean b_equal = true;
    int count_height = 0;
    int count_width = 0;
    
     while (sc.hasNext()) {
	String aLine = sc.nextLine();
	  if (origin_c_width == 0)
	  {
	    origin_c_width = aLine.length();
	  }
          count_width = aLine.length();
          if(count_width != origin_c_width)
          {
	     b_equal = false;
          }
          count_height++;
      }
      
      if(b_equal)
      {
      System.out.println(count_width+" "+count_height);
      }
      else
      {
       System.out.println("INPUT MISMATCH");
      }
  }

}