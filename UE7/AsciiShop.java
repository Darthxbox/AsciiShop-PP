import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class AsciiShop {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, OperationException 
    {
    	//Diverse Variablen und Objekte werden für die spaetere Verwendung initialisiert. 
        Scanner scFile = new Scanner(System.in);
        AsciiImage ai = null;
        AsciiStack as = new AsciiStack();
        boolean load = false;
        boolean createFlag = true;
        String loadFlag = "!";
        boolean emptyArray = true;
        String content = "";

        try {

        	//Liest die Eingabe bis zum Ende
            while (scFile.hasNext()) {
            	    
                String line = scFile.nextLine();
                
                //Create-Block - Die erste Zeile, in diesem Fall immer ein create-Befehl, wird eingelesen und
		//so untersucht, dass Hoehe, Breite und der Zeichensatz ausgelesen werden können.
                if (line.contains("create")) {
                    if (createFlag) {
                        String temp[] = line.split(" ");
                        int w = Integer.parseInt(temp[1]);
                        int h = Integer.parseInt(temp[2]);
                        String charset = temp[3];
                        createFlag = false;
                       //System.out.println(charset);
                        ai = new AsciiImage(w, h, charset);

                    } else {
                        System.out.println("UNKNOWN COMMAND");
                        return;
                    }

                }

                //Abfrage der Befehle
                
                //Löschen bzw. alles auf Punkt (.) setzen
                if (line.contains("clear")) {
                    as.push(new AsciiImage(ai));
                    ai = new ClearOperation().execute(ai);
                }
                
                //Wende den Filter and
                if (line.contains("filter")) 
                {
                	String temp[] = line.split(" ");
                	if(!temp[1].equals("median"))
                	{
                		System.out.println("INPUT MISMATCH");
                		break;
                	}
			as.push(new AsciiImage(ai));
			ai = new MedianOperation().execute(ai);							
		}

		//Laden eines Ascii-Bildes mittels Start und Endpunkt (loadFlag)
                if (line.contains("load")) { 	
                    as.push(new AsciiImage(ai));
                    String temp[] = line.split(" ");
                    loadFlag = temp[1];
                    content = "";
                    String sLine = line;
                    while(true) {
                        sLine = scFile.nextLine();
                        if(sLine.equals(loadFlag)) {
                            break;
                        }
                        else{
                            content += sLine;
                        }
                        content += "\n";
                    }
                    //System.out.println(content);
                    	ai = new LoadOperation(content).execute(ai);
                }

                //Ersetzt alle gesuchten Zeichen mit einem neuen Zeichen
                if (line.contains("replace")) {
                    as.push(new AsciiImage(ai));
                    String temp[] = line.split(" ");
                    char oldChar = temp[1].charAt(0);
                    char newChar = temp[2].charAt(0);
                    ai.replace(oldChar, newChar);
                }

                //Ausgabe des Ascii-Bildes
                if (line.contains("print")) {
                    System.out.println(ai.toString());
                }

                //Änderung rueckgaengig machen
                if (line.contains("undo")) {
                    if (as.empty()) System.out.println("STACK EMPTY");
                    else {
                        ai = as.pop();
                    }
                }

            }

       //Abfangen einer NullPointerException
		} catch (NullPointerException e) {
			System.out.println("INPUT MISMATCH");
			//e.printStackTrace();
		}//Abfangen einer ArrayIndexOutOfBoundsException
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("INPUT MISMATCH");
			//e.printStackTrace();
		}//Abfangen einer OperationException
		catch (OperationException e){
			System.out.println("OPERATION FAILED");
			//e.printStackTrace();
		}
    }
}
