import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedHashMap;

class AsciiShop {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, OperationException, FactoryException
	{
		//Diverse Variablen und Objekte werden für die spaetere Verwendung initialisiert.
		Scanner scFile = new Scanner(System.in);
		AsciiImage ai = null;
		MetricSet<AsciiImage> metricSet = new MetricSet<AsciiImage>();
		AsciiStack as = new AsciiStack();
		LinkedHashMap<String, Factory> commandList = new LinkedHashMap<String, Factory>();
		String line = "";
		String content = "";
		int print = 0;

		try {

			//Die LinkedHashMap wird mit den möglichen Befehlen und der dazugehörigen Factory befüllt.
			commandList.put("create", new CreateFactory());
			commandList.put("save", new SaveFactory(metricSet));
			commandList.put("load",new LoadFactory());
			commandList.put("binary",new BinaryFactory());
			commandList.put("clear",new ClearFactory());
			commandList.put("filter",new FilterFactory());
			commandList.put("replace",new ReplaceFactory());
			commandList.put("search", new SearchFactory(metricSet));


			//Create-Block - Die erste Zeile, in diesem Fall immer ein create-Befehl, wird eingelesen und
			//so untersucht, dass Hoehe, Breite und der Zeichensatz ausgelesen werden können.
			/*
			line = scFile.nextLine();
			String temp[] = line.split(" ");
			int w = Integer.parseInt(temp[1]);
			int h = Integer.parseInt(temp[2]);
			String charset = temp[3];

			//System.out.println(charset);

			//Neues Ascii-Bild wird mit den eingelesenen Dimensionen und einem Zeichensatz erzeugt.
			ai = new AsciiImage(w, h, charset);*/

			String text = scFile.next();

			if (!text.contentEquals("create"))
			{
				NullPointerException err = new NullPointerException();
				throw err;
			}

			ai = commandList.get(text).create(scFile).execute(ai);
			scFile.nextLine();

			//Befehl-Block - Prüft Zeile für Zeile, ob bekannte Befehle eingelesen werden können
			while (scFile.hasNext())
			{
				line = scFile.next();

				if (line.contains("print"))
				{
					if (line.contains("printsaved")) 
					{
						Iterator<AsciiImage> imagePointer = metricSet.iterator();
						if (!imagePointer.hasNext()) 
						{
							System.out.println("NO SAVED IMAGES");
						}

						while (imagePointer.hasNext()) 
						{
							System.out.println(imagePointer.next());
						}

					}
					else
					{
						if(print != 0)
						{
							System.out.println("");
						}

						System.out.println(ai.toString());
						print++;
					}

				}

				if (line.contains("undo"))
				{
					if (as.empty()) System.out.println("STACK EMPTY");
					else {
						ai = as.pop();
					}
				}

				//Sollte keiner der obigen Befehle zutreffen, wird in der LinkedHashMap überprüft ob sich ein passender
				//Befehl darin befindet und führt die dazugehörige Factory aus.
				if (line != null && !line.contains("undo") && !line.contains("print") && !line.contains("replace"))
				{
					as.push(new AsciiImage(ai));

					ai = commandList.get(line).create(scFile).execute(ai);
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
		}//Abfangen einer FactoryException
		catch (FactoryException e) {
			System.out.println("INPUT MISMATCH");
			//e.printStackTrace();
		}

	}
}


