import java.util.Scanner;

class AsciiShop{

	public static void main(String[] args)
	{
		Scanner scFile = new Scanner(System.in);
		AsciiImage ai = new AsciiImage();

		while (scFile.hasNext())
		{
			ai.addLine(scFile.nextLine());
		}

	}
}

