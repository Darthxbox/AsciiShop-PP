public class AsciiStack {
	private AsciiStackNode head = null;
	
	public AsciiStack() { this.head = null; }
	
	public int size() { return this.head.size(); }
	
	public boolean empty() { return this.head == null; }
	
	public AsciiImage peek() { return this.head.getImage(); }

	public AsciiImage pop() 
	{
		if (this.head == null) return null;
		AsciiStackNode an = this.head;
		this.head = this.head.next;
		
		return an.getImage();
	}
	
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
