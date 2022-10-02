package DataStructure.LinkedList;

public class DoublyLinkedList {
	
	Node header ;
	
	DoublyLinkedList(){
		header = new Node();
	}
	
	void addFirst(String s) {
		if(s == null) return;
		
		Node newNode = new Node();
		newNode.data = s;
		newNode.next = header.next;
		newNode.previous = header;
		
		if(header.next != null){
			header.next.previous = newNode;
		}
		
		header.next = newNode;	
	}
	
	void addLast(String s) {
		Node newNode = new Node();
		newNode.data = s;
		
		Node current = header;
		
		while(current.next!=null) {
			current = current.next;			
		}
		
		current.next = newNode;
		newNode.previous = current;
		
	}
	
	void removeLast() {			
		
		if(header.next == null) return;
		
		Node current = header;
		while(current.next!=null) {
			current = current.next;
		}
		Node previous = current.previous;
		previous.next = null;
		current.previous = null;
		
	}
	
	boolean search(String s) {
		if(s== null) return false;
		Node current = header.next;
		while(current!=null) {
			if(current.data.equals(s)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	void PrintNodes() {
		Node current = header;
		
		while(current.next!=null) {
			current=current.next;
			System.out.print(current.data+" ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast("Rich");
		list.PrintNodes();
		list.removeLast();
		list.PrintNodes();
		list.addFirst("Bob");
		list.addFirst("Harry");
		list.addFirst("Steve");
		list.PrintNodes();
		list.removeLast();
		list.PrintNodes();
		System.out.println(list.search("Harry"));
		System.out.println(list.search("Bob"));
		list.addLast("Tom");
		list.PrintNodes();
	}
	
	
	
	private class Node{
		String data;
		Node next;
		Node previous;
	}

}
