import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.LinkedHashMap;

class AsciiShop {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, OperationException, FactoryException
	{
		Scanner scFile = new Scanner(System.in);
		AsciiImage ai = null;
		AsciiStack as = new AsciiStack();
		LinkedHashMap<String, Factory> commandList = new LinkedHashMap<String, Factory>();
		String line = "";
		String content = "";
	
		try {

			commandList.put("load",new LoadFactory());
			commandList.put("binary",new BinaryFactory());
			commandList.put("clear",new ClearFactory());
			commandList.put("filter",new FilterFactory());
			commandList.put("replace",new ReplaceFactory());
			
			line = scFile.nextLine();
			String temp[] = line.split(" ");
			int w = Integer.parseInt(temp[1]);
			int h = Integer.parseInt(temp[2]);
			String charset = temp[3];
			//System.out.println(charset);
			ai = new AsciiImage(w, h, charset);
			

			while (scFile.hasNext())
			{
				line = scFile.next();

				if (line.contains("print")) {
					System.out.println(ai.toString());
				}

				if (line.contains("undo")) {
					if (as.empty()) System.out.println("STACK EMPTY");
					else {
						ai = as.pop();
					}
				}

				
				if (line != null && !line.contains("undo") && !line.contains("print") && !line.contains("replace"))
				{
					as.push(new AsciiImage(ai));
					ai = commandList.get(line).create(scFile).execute(ai);
				}

			}

		} catch (NullPointerException e) {
			System.out.println("INPUT MISMATCH");
			//e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("INPUT MISMATCH");
		}
		catch (OperationException e){
			System.out.println("OPERATION FAILED");
		}
		
	}
}


