public class AsciiStackNode {
		
		//Variabeln
		public AsciiStackNode next;
		public AsciiImage ai;
		
		//Konstruktor mit Bild und Pointer
		public AsciiStackNode(AsciiImage ai, AsciiStackNode next) 
		{
			ai = new AsciiImage(ai);
			next = next;
		}
		
		//Gibt die Gesamtgroeße zurueck
		public int size() 
		{
			if (this.next == null) return 1;
			{
			return this.next.size() + 1;
			}
			
		}	
		//Springt zum naechsten Nachfolgerknoten
		public AsciiStackNode getNext() { return this.next; }
		
		//Gibt das Bild des aktuellen Knotens zurueck
		public AsciiImage getImage() { return this.ai; }
	}