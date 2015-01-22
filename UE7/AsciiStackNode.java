public class AsciiStackNode {
		
		public AsciiStackNode next;
		public AsciiImage ai;
		
		public AsciiStackNode(AsciiImage image, AsciiStackNode next) 
		{
			ai = new AsciiImage(image);
			next = next;
		}
		
		public int size() 
		{
			if (this.next == null) return 1;
			{
			return this.next.size() + 1;
			}
			
		}	
		
		public AsciiStackNode getNext() { return this.next; }
		
		public AsciiImage getImage() { return this.ai; }
	}