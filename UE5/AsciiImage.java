class AsciiImage
{
	private char[][] lineArray = null;
	private int width;
	private int height;
	private int hCount = 0;
	private char cTarget = 'o';
	private int xTarget = 0;
	private int yTarget = 0;
	boolean load = false;


	public AsciiImage(int width, int height)
	{
		this.width = width;
		this.height = height;
		lineArray = new char[width][height];
	}

	public void init()
	{
		String line = "";
		for(int i = 0; i < width; i++)
		{
			line += ".";
		}

		for(int j=0; j < height; j++)
			addLine(line);
	}

	public boolean addLine(String line)
	{
		if(hCount < height && line.length()==width)
		{
			for(int i = 0; i < width; i++)
			{
				lineArray[i][hCount] = line.charAt(i);
			}
			hCount++;
		}
		return true;

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

		for(int i = 0; i<hCount; i++)
		{
			for(int j = 0; j<width; j++)
			{
				line += lineArray[j][i];
			}
			if(i < height-1) line += "\n";
		}
		//line += "\n";

		return line;
	}

	public void clear()
	{
		for(int i = 0; i<height; i++)
		{
			for(int j = 0; j<width; j++)
			{
				lineArray[j][i] = '.';
			}
		}
	}

	public char getPixel(int x, int y)
	{
		return lineArray[x][y];
	}

	public void drawLine(int x0, int y0, int x1, int y1, char c)
	{
		boolean switchFlag = false;
		double y = (double) y0;
		int deltaX = x1-x0;
		int deltaY = y1-y0;
		double k = (double) deltaY / (double) deltaX;
		int yHelp;

		if(x0 >= x1)
		{
			int temp = x0;
			x0 = x1;
			x1 = temp;
		}

		if(y0 > y1)
		{
			int temp = y0;
			y0 = y1;
			y1 = temp;
			y = (double) y0;
		}

		if(Math.abs(deltaY) > Math.abs(deltaX))
		{
			int temp = x0;
			x0 = y0;
			y0 = temp;

			temp = x1;
			x1 = y1;
			y1 = temp;

			deltaX = x1-x0;
			deltaY = y1-y0;
			k = (double) deltaY / (double) deltaX;
			y = (double) y0;

			do
			{
				yHelp =  (int) Math.round(y);
				lineArray[yHelp][x0] = c;
				x0++;
				y += k;
			}
			while(x0 <= x1);

			return;
		}


		do
		{
			yHelp =  (int) Math.round(y);
			lineArray[x0][yHelp] = c;
			x0++;
			y += k;
		}
		while(x0 <= x1);
	}

	public void transpose()
	{
		int m = hCount;
		int n = getWidth();

		char transpose[][] = new char[m][n];

		for (int newHeight = 0 ; newHeight < n ; newHeight++ )
		{
			for (int newWidth = 0 ; newWidth < m; newWidth++ )
			{
				char c = lineArray[newHeight][newWidth];
				transpose[newWidth][newHeight] = c;
			}
		}

		lineArray = new char[m][n];
		width = m;
		hCount = n;
		height = n;

		for (int newHeight = 0 ; newHeight < n ; newHeight++ )
		{
			for (int newWidth = 0 ; newWidth < m; newWidth++ )
			{
				char c = transpose[newWidth][newHeight];
				lineArray[newWidth][newHeight] = c;
				//System.out.print(c);
			}
		}
	}

	public void replace(char oldChar, char newChar)
	{
		for(int i = 0; i < hCount; i++)
		{
			for(int j = 0; j < getWidth(); j++)
			{
				if(lineArray[j][i]==oldChar)
				{
					lineArray[j][i] = newChar;
				}
			}
		}
	}

	public void fill(int x, int y, char c)
	{
		
		if(x<0) return;
		if(y<0) return;
		if(x>=getWidth()) return;
		if(y>=hCount) return;
		if (lineArray[y][x] == c) {

			lineArray[y][x] = c;
			fill(x, y - 1, c);
			if(x<getWidth()){fill(x + 1, y, c);}
			fill(x, y + 1, c);
			fill(x - 1, y, c);
		}
	}
}
