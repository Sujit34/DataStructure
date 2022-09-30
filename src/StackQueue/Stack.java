package StackQueue;

public class Stack {
	private SinglyLinkedList list;
	private SinglyLinkedList.Node top;
	
	Stack(){
		list = new SinglyLinkedList();		
	}
	
	public void push(String s) {
		top = list.addFirst(s);
	}
	
	public String peek() {
		if(top!=null) {
			return top.data;
		}
		else return null;
		
	}
	
	public String pop() {
		
		if(top!=null) {
			String s = peek();
			top = top.next;	
			return s;
		}
		else return null;
		
	}
	
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");
		System.out.println("Popping..."+stack.pop());
		System.out.println("Peeking..."+stack.peek());
		System.out.println("Popping..."+stack.pop());	
	}
}

 class SinglyLinkedList {
	
	Node header = null;
	
	SinglyLinkedList(){		
		header = new Node();
	}	
	
	
	Node addFirst(String s) {
		if(s == null) return null;
		
		Node newNode = new Node();
		newNode.data = s;
		
		newNode.next = header.next;
		header.next = newNode;
		
		return newNode;
	}	
	
	public class Node{
		String data;
		Node next;
	}

}


