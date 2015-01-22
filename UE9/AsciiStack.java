public class AsciiStack {
	
	//Knoten-Variable
	private AsciiStackNode head = null;
	
	//Konstruktor mit leerem Head-Knoten.
	public AsciiStack() { this.head = null; }
	
	//Gibt die aktuelle Groesse des Stacks zurueck.
	public int size() { return this.head.size(); }
	
	//Prueft ob der Stack leer ist.
	public boolean empty() { return this.head == null; }
	
	//Gibt das erste eingefuegte Bild-Element zurueck
	public AsciiImage peek() { return this.head.getImage(); }

	//Gibt das letzt eingefuegte Bild-Element des Stacks zurueck und entfernt es aus diesem.
	public AsciiImage pop() 
	{
		if (this.head == null) return null;
		AsciiStackNode an = this.head;
		this.head = this.head.next;
		
		return an.getImage();
	}
	
	//Fuegt dem Stack ein neues Bild-Element hinzu.
	public void push(AsciiImage img) {
	
		if (this.head == null) 
		{
		this.head = new AsciiStackNode(img, null);
		}
		else 
		{
		this.head = new AsciiStackNode(img, this.head);
		}
	}

	
}
