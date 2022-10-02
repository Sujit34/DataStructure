package DataStructure.Stack;

public class NodeStack {
	private Node top = null;
	
	public void push(String val) {
		if(val == null) return;
		
		Node newNode = new Node(val,top);
		top = newNode;		
	
	}
	
	public String pop() {
		if(top!=null) {
			String s= peek();
			top=top.next;
			return s;
		}
		else return null;
		
	}
	
	public String peek() {
		if(top!=null) {
			return top.data;
		}
		else return null;
		
	}
	
	public static void main(String[] args) {
		NodeStack stack = new NodeStack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");
		System.out.println("Popping..."+stack.pop());
		System.out.println("Peeking..."+stack.peek());
		System.out.println("Popping..."+stack.pop());		
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
