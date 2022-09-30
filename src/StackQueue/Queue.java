package StackQueue;

public class Queue {
	
	private SinglyLinkedListForQueue list;
	private SinglyLinkedListForQueue.Node front;
	private SinglyLinkedListForQueue.Node rear;
	
	Queue(){
		list = new SinglyLinkedListForQueue();
	}	
	
	
	public void enqueue(String s) {	
		if(isEmpty()) {
			front = rear = list.addFirst(s);			
		}
		else {
			rear = list.addLast(s);
		}
		
	}
	
	public String dequeue() {
		if(isEmpty()) return "Empty";
		SinglyLinkedListForQueue.Node temp = front;
		front = front.next;
		return temp.data;
	}
	
	public String peek() {
		if(isEmpty()) return "Empty";
		return front.data;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	
	public static void main(String[] args) {
		Queue theQueue = new Queue();
		theQueue.enqueue("1"); 
		theQueue.enqueue("2");
		theQueue.enqueue("3");
		theQueue.enqueue("4");
		theQueue.enqueue("5");
		
		
		
		for(int i = 0; i < 5; ++i) {
			System.out.println("Removed " + theQueue.dequeue());
		}
		System.out.println("Is the queue empty? " + theQueue.isEmpty());
	}

}

class SinglyLinkedListForQueue {
	
	Node header = null;
	
	SinglyLinkedListForQueue(){		
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
	
	Node addLast(String s) {
		if(s == null) return null;
		Node newNode = new Node();
		newNode.data = s;
		
		Node temp= header;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		temp.next=newNode;	
		
		return newNode;
	}
	
	public class Node{
		String data;
		Node next;
	}

}
