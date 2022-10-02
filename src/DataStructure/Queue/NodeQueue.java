package DataStructure.Queue;

public class NodeQueue {
	private Node front=null;
	private Node rear=null;
	
	public void enqueue(String s) {
		if(s == null) return ;
		if(isEmpty()) {
			front = rear = new Node(s,null);			
		}
		else {
			Node newNode =  new Node(s,null);
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public String dequeue() {
		if(isEmpty()) return "Empty";
		String s = peek();
		front = front.next;
		return s;
	}
	
	public String peek() {
		if(isEmpty()) return "Empty";
		return front.data;
		
	}
	
	public boolean isEmpty() {
	  return front == null;	
	}
	
	public static void main(String[] args) {

		NodeQueue theQueue = new NodeQueue(); 
		theQueue.enqueue("1");		
		theQueue.enqueue("2");		
		theQueue.enqueue("3");		
		theQueue.enqueue("4");		
		theQueue.enqueue("5");		
		
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("Removed " + theQueue.dequeue());				
		}
		
		System.out.println("Is the queue empty? " + theQueue.isEmpty());
	}
	
	class Node {
		 private String data;
		 private Node next;
		 Node(String data, Node next) {
			 this.data = data;
			 this.next = next;
		 }
	}


}
