import  java.util.ArrayList;

class AsciiImage {

    private char[][] lineArray = null;
    private int width;
    private int height;
    private int hCount = 0;
    private char cTarget = 'o';
    private int xTarget = 0;
    private int yTarget = 0;
    boolean load = false;

    public AsciiImage(int width, int height) {
        this.width = width;
        this.height = height;
        lineArray = new char[height][width];
        clear();
    }

    public AsciiImage(AsciiImage img) {
        this(img.getWidth(), img.getHeight());
    }

    public AsciiPoint getCentroid(char c) {
        int x = 0;
        int y = 0;
        int count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                  if(lineArray[i][j]==c)
                  {
                      y += i;
                      x += j;
                      count++;
                  }
            }
        }
        
        double sX = (double) x / (double) count;
        double sY = (double) y / (double) count;
        AsciiPoint aP = new AsciiPoint( (int) Math.round(sX), (int) Math.round(sY));
        return aP;
    }

    public boolean addLine(String line) {


        if (hCount < height && line.length() == width) {
            for (int i = 0; i < width; i++) {
                lineArray[hCount][i] = line.charAt(i);
            }
            hCount++;
        }
        return true;

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.height; i++) {
            s = s + String.valueOf(lineArray[i]) + '\n';
        }
       // System.out.println(height+","+width);
        return s;
    }

    public void clear() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                lineArray[i][j] = '.';
            }
        }
    }

    public void setPixel(int x, int y, char c) {
        lineArray[y][x] = c;
    }

    public void setPixel(AsciiPoint p, char c) {
        setPixel(p.getX(), p.getY(), c);
    }

    public char getPixel(int x, int y) {
        return lineArray[y][x];
    }

    public char getPixel(AsciiPoint p) {
        return lineArray[p.getY()][p.getY()];
    }

    public void drawLine(int x0, int y0, int x1, int y1, char c) {

        double dx = x1 - x0;
        double dy = y1 - y0;
        boolean switchFlag = false;

        if (Math.abs(dy) > Math.abs(dx)) {
            switchFlag = true;

            int tmpInt;
            tmpInt = x0;
            x0 = y0;
            y0 = tmpInt;

            tmpInt = x1;
            x1 = y1;
            y1 = tmpInt;

            double tmpDouble;
            tmpDouble = dx;
            dx = dy;
            dy = tmpDouble;
        }

        if (x1 < x0) {
            int tmpInt;
            tmpInt = x0;
            x0 = x1;
            x1 = tmpInt;

            tmpInt = y0;
            y0 = y1;
            y1 = tmpInt;
        }

        double steigung = dy / dx;

        for (double x = x0, y = y0; x <= x1; x++, y += steigung) {
            if (switchFlag) {
                this.setPixel((int) Math.round(y), (int) Math.round(x), c);
            }
            else {
                this.setPixel((int) Math.round(x), (int) Math.round(y), c);
            }
        }

    }

    public void transpose() {
        char[][] helperImage = new char[width][height];

        for (int i = 0; i < width; i++) {
            for (int a = 0; a < height; a++) {
                helperImage[i][a] = lineArray[a][i];
            }
        }

        //Dreieckstausch
        int newWidth= this.height;
        height = width;
        this.width = newWidth;
        lineArray = helperImage;
    }

    public void growRegion(char c) {

        ArrayList<AsciiPoint> al = new ArrayList<AsciiPoint>();

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(lineArray[i][j]==c)
                {
                    AsciiPoint ap = new AsciiPoint(j,i);
                    al.add(ap);
                }
            }
        }

        int x, y;
        for (int i = 0; i < al.size(); i++) {
            x = al.get(i).getX();
            y = al.get(i).getY();
            if (((y + 1) < this.getHeight()) && (this.getPixel(x, y + 1) == '.')) this.setPixel(x, y + 1, c);
            if (((y - 1) >= 0) && (this.getPixel(x, y - 1) == '.')) this.setPixel(x, y - 1, c);
            if (((x + 1) < this.getWidth()) && (this.getPixel(x + 1, y) == '.')) this.setPixel(x + 1, y, c);
            if (((x - 1) >= 0) && (this.getPixel(x - 1, y) == '.')) this.setPixel(x - 1, y, c);
        }
    }

    public void replace(char oldChar, char newChar) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (lineArray[i][j] == oldChar) {
                    lineArray[i][j] = newChar;
                }
            }
        }
    }

    public void fill(int x, int y, char c) {

        char previousChar = this.getPixel(x, y);
        this.setPixel(x, y, c);

        if (previousChar == c) return;

        // search left
        if (((x - 1) >= 0) && previousChar == this.getPixel(x - 1, y)) {
            this.fill(x - 1, y, c);
        }

        // search right
        if (((x + 1) < this.width) && previousChar == this.getPixel(x + 1, y)) {
            this.fill(x + 1, y, c);
        }

        // search above
        if (((y - 1) >= 0) && previousChar == this.getPixel(x, y - 1)) {
            this.fill(x, y - 1, c);
        }

        // search below
        if (((y + 1) < this.height) && previousChar == this.getPixel(x, y + 1)) {
            this.fill(x, y + 1, c);
        }
    }
}
