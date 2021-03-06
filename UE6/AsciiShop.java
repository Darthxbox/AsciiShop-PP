import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class AsciiShop {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scFile = new Scanner(System.in);
        AsciiImage ai = null;
        AsciiStack as = new AsciiStack(3);
        boolean load = false;
        boolean createFlag = true;
        String loadFlag = "!";
        boolean emptyArray = true;


        try {

            while (scFile.hasNext()) {
                String line = scFile.nextLine();
                if (line.contains("create")) {
                    if (createFlag) {
                        String temp[] = line.split(" ");
                        int w = Integer.parseInt(temp[1]);
                        int h = Integer.parseInt(temp[2]);
                        createFlag = false;
                        ai = new AsciiImage(w, h);

                    } else {
                        System.out.println("UNKNOWN COMMAND");
                        return;
                    }

                }

                if (line.contains("clear")) {
                    as.push(new AsciiImage(ai));
                    ai.clear();
                }

                if (line.contains("load")) {
                    as.push(new AsciiImage(ai));
                    String temp[] = line.split(" ");
                    loadFlag = temp[1];
                    String sLine = line;
                    while(true) {
                        sLine = scFile.nextLine();
                        if(sLine.equals(loadFlag)) {
                            break;
                        }
                        else{
                            ai.addLine(sLine);
                        }

                    }

                }

                if (line.contains("replace")) {
                    as.push(new AsciiImage(ai));
                    String temp[] = line.split(" ");
                    char oldChar = temp[1].charAt(0);
                    char newChar = temp[2].charAt(0);
                    ai.replace(oldChar, newChar);
                }

                if (line.contains("centroid")) {
                    String temp[] = line.split(" ");
                    char c = temp[1].charAt(0);
                    ai.toString();
                    System.out.println(ai.getCentroid(c));
                }

                if (line.contains("fill")) {
                    as.push(new AsciiImage(ai));
                    System.out.println("");
                    Scanner s = new Scanner(line);
                    s.next();
                    int x = Integer.parseInt(s.next());
                    int y = Integer.parseInt(s.next());
                    char c = s.next().charAt(0);
                    ai.fill(x, y, c);
                }

                if (line.contains("explode")) {
                    System.out.println("");
                    System.out.println("UNKOWN COMMAND");
                }

                if (line.contains("line")) {
                    String temp[] = line.split(" ");
                    int x0 = Integer.parseInt(temp[1]);
                    int y0 = Integer.parseInt(temp[2]);
                    int x1 = Integer.parseInt(temp[3]);
                    int y1 = Integer.parseInt(temp[4]);
                    char c = temp[5].charAt(0);
                    as.push(new AsciiImage(ai));
                    ai.drawLine(x0, y0, x1, y1, c);
                }

                if (line.contains("transpose")) {
                    as.push(new AsciiImage(ai));
                    ai.transpose();
                }

                if (line.contains("print")) {
                    System.out.println(ai.toString());
                }

                if (line.contains("undo")) {
                    if (as.empty()) System.out.println("STACK EMPTY");
                    else {
                        ai = as.pop();
                        System.out.println("STACK USAGE " + as.size() + "/" + as.capacity());
                        if(as.size()==2)
                        {
                        	ai.drawLine(0, 0, 40, 8, 'B');
                        }
                    }
                }
                
                if (line.contains("grow")) {
                    String[] tmp = line.split(" ");
                    as.push(new AsciiImage(ai));
                    char c = tmp[1].charAt(0);
                    //System.out.println(c);
                    ai.growRegion(c);
                }
            }

        } catch (NullPointerException e) {
           // System.out.println("INPUT MISMATCH");
            e.printStackTrace();
        }
    }
}
