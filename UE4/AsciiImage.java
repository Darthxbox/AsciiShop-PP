class AsciiImage
{
	private String[] lineArray = new String[1000];
	private int width;
	private int height;
	private int hCount = 0;
	private char cTarget = 'o';
	private int xTarget = 0;
	private int yTarget = 0;
	int readCommand = 0;
	String action = "";

	public AsciiImage()
	{
		this.width = 0;
		this.height = 0;
	}

	public String getActionCommand()
	{
		
		          return action;
	}

	public boolean addLine(String line)
	{

		if(height == 1 && line.length() < 1)
		{
			return false;
		}
		else
		{
			if(hCount==0)
			{
				String parts[] = line.split(" ");
				readCommand = Integer.parseInt(parts[1]);

			}
			else if(hCount==1)
			{
				width = line.length();
				lineArray[height] = line;
				height++;
			}
			else if(hCount >= 2 && line.length() != width)
			{
				action = line;
				height = readCommand;

				if(action.contains("unique"))
				{
					System.out.println(getUniqueChars());
					System.out.println(toString());
					System.out.println(getWidth()+" "+getHeight());
				}
				else if(action.contains("transpose"))
				{
					transpose();
					System.out.println(getHeight()+" "+getWidth());
				}
				else if(action.contains("flip-v"))
				{
					flipV();
					System.out.println(getWidth()+" "+getHeight());
				}
				else if(action.contains("fill"))
				{
					String temp[] = action.split(" ");
					if(action.contains("fill"))
					{
					cTarget = lineArray[1].charAt(3);
					}
					fill(Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),temp[3].charAt(0));
					System.out.println(getWidth()+" "+getHeight());
				}
				else
				{
					System.out.println("INPUT MISMATCH");
					
				}
			}
			else if (hCount >= 2)
			{
				lineArray[height] = line;
				height++;
			}
			else if (height>readCommand)
			{
				return false;
			}
			hCount++;
			return true;
		}
	}


	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public String toString()
	{
		String line = "";
		for(int i = 0; i<=height-1; i++)
		{
			if(i==height-1)
				line += lineArray[i];
			else
				line += lineArray[i]+"\n";
		}
		return line;
	}

	public int getUniqueChars()
	{

		int uniqueChars = 0;
		String buffer = "";
		for(int i = 1; i<height; i++)
		{
			if(lineArray[i]!=null)
			{
				for (int j = 0; j < width; j++) {
					if (!buffer.contains(String.valueOf(lineArray[i].charAt(j)))) {
						buffer += lineArray[i].charAt(j);
						uniqueChars++;
					}

				}

			}
		}
		return uniqueChars;
	}

	public void flipV()
	{
		for(int i = getHeight()-1; i >= 0; i--)
		{
			for(int j = 0; j < getWidth(); j++)
			{
				System.out.print(lineArray[i].charAt(j));
			}
			System.out.println("");
		}
	}

	public void transpose()
	{
		char a[][] = new char[getHeight()][getWidth()];

		for(int i = 0; i < getHeight(); i++)
		{
			for(int j = 0; j < getWidth(); j++)
			{
				a[i][j] = lineArray[i].charAt(j);
			}
		}



		for(int i = 0; i < getWidth(); i++)
		{
			for(int j = 0; j < getHeight(); j++)
			{
				System.out.print(a[j][i]);
			}
			System.out.println("");
		}

	}

	public void fill(int x, int y, char c)
	{

		if(x<0) return;
		if(y<1) return;
		if(x>=getWidth()) return;
		if(y>=getHeight()) return;
		if (lineArray[y].charAt(x) == c) {

			lineArray[y] = lineArray[y].substring(0, x) + c + lineArray[y].substring(x+1);
			fill(x, y - 1, c);
			if(x<getWidth()){fill(x + 1, y, c);}
			fill(x, y + 1, c);
			fill(x - 1, y, c);
		}
	}
}
