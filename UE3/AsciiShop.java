import java.util.Scanner;

public class AsciiShop{

	
	private static char cTarget = 'c';
	
	
	private static int iLength = 0;
	private static int iCount = 0;
	private static int iRead = 0;

	public static void main(String[] args)
	{
		Scanner FileScanner = new Scanner(System.in);
		String[] StringBild = new String[1000];
		String eingabe = "";
		String[] cmd = new String[10];

		int iLengthCur = 0;
		int fill = 0;
		
		
		boolean bEqual = true;
		boolean bError = false;

		while (FileScanner.hasNext())
		{

			StringBild[iCount] = FileScanner.nextLine();
			//System.out.println(StringBild[iCount]);
			if(iRead == 0)
			{
				String sInput = StringBild[iCount];
				String[] parts = sInput.split(" ");
				if(parts[0].contains("read"))
				{
					iRead = Integer.parseInt(parts[1]);
				}
				else{ bEqual=false; }


				// if(parts[0] != "read"){ System.out.println("INPUT ERROR"); break;}
				// else{iRead = Integer.parseInt(parts[1]);}
			}

			if (iLength == 0 && iCount == 1)
			{
				iLength = StringBild[iCount].length();
			}
			iLengthCur = StringBild[iCount].length();

			if(iLengthCur != iLength)
			{
				if(StringBild[iCount].contains("fill"))
				{
					eingabe = StringBild[iCount];
					cmd[fill] = eingabe;
					fill++;
				}
				else if(iCount==0)
				{

				}
				else
				{
					bEqual = false;
				}
			}

			iCount++;

		}
		if(bEqual)
		{
			for(int j = 0; j<fill; j++){
				String[] parts = cmd[j].split(" ");

				try{
					int x = Integer.parseInt(parts[1]);
					int y = Integer.parseInt(parts[2]);
					char c = parts[3].charAt(0);
					if(y > iRead)
					{
						System.out.println("OPERATION FAILED");
						bError=true;
					}
					else if(iRead > iCount)
					{
						System.out.println("INPUT MISMATCH");
						bError=true;

					}
					else{
						if(y==0){y++;}
						cTarget = StringBild[y].charAt(x);
						fill(StringBild,x,y,c);
						
					}
				}catch(NumberFormatException e){System.out.println("INPUT MISMATCH");bError = true;}
			}

			if(!bError)
			{
			for(int i = 1; i<=iLength-3;i++)
						{
							System.out.println(StringBild[i]);
			}System.out.println(iLength + " "+ iRead);
			}
		}
		else
		{
			System.out.println("INPUT MISMATCH");
	}}

	public static void fill(String[] image, int x, int y, char c)
	{
		if(x<0) return;
		if(y<1) return;
		if(x>=iLength) return;
		if(y>=iRead) return;
		if (image[y].charAt(x) == cTarget) {

			image[y] = image[y].substring(0, x) + c + image[y].substring(x+1);
			fill(image, x, y - 1, c);
			if(x<iLength){fill(image, x + 1, y, c);}
			fill(image, x, y + 1, c);
			fill(image, x - 1, y, c);
		}

	}
}
