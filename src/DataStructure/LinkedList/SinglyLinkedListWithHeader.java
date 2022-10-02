package DataStructure.LinkedList;

//addFirst
//addLast
//search
//insert in any position
//size
//remove any value
//printNodes

public class SinglyLinkedListWithHeader {
	
	Node header = null;
	
	SinglyLinkedListWithHeader(){		
		header = new Node();
	}
	
	boolean search(String s) {
		if(s == null) return false;
		
		Node temp = header.next;
		
		while(temp!=null) {
			String data = temp.data;
			if(data.equals(s)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	void addFirst(String s) {
		if(s == null) return;
		
		Node newNode = new Node();
		newNode.data = s;
		
		newNode.next = header.next;
		header.next = newNode;
		
	}
	
	void addLast(String s) {
		if(s == null) return;
		Node newNode = new Node();
		newNode.data = s;
		
		Node temp= header;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		temp.next=newNode;		
	}
	
	int size() {
		Node temp =header.next;
		if(temp == null) return 0;
		int count =0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	void insert(String s, int pos) {
		if(s == null) return;
		
		int size = size();
		
		if(pos < 0 || pos > size) 
			throw new IllegalArgumentException("Unacceptable position for new node");
		
		if(pos==0)addFirst(s);
		
		else if(pos==size)addLast(s);
		
		else {
			Node newNode = new Node();
			newNode.data =s;
			
			if(header.next == null) header.next = newNode;
			else {
				Node temp = header.next;		
				
				int count = 1;
				while(count<pos) {
					temp=temp.next;
					count++;
				}
				
				Node last = temp.next;
				temp.next = newNode;
				newNode.next = last;
			}
		}
		
	}
	
	void remove(String s) {
		if(s == null) return;
		
		Node temp = header.next;
		Node previous = header;
		
		while(temp!=null) {
			if(temp.data.equals(s)) {
				previous.next = temp.next;
			}
			previous = temp;
			temp = temp.next;
		}
	}
  
	void printNodes() {
		Node temp = header.next;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	public static void main(String[] args) {
		String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
		SinglyLinkedListWithHeader sll = new SinglyLinkedListWithHeader();
		
		for(int i = stringData.length -1; i >= 0; i--) {
			sll.addFirst(stringData[i]);
		}
		boolean foundCharles = sll.search("Charles");
		System.out.println("Found Charles? " + foundCharles);
		
		sll.printNodes();
		
		sll.addFirst("Frank");
		sll.remove("David");
		sll.printNodes();
		sll.addLast("Francesca");
		sll.printNodes();
		System.out.println(sll.size());
		sll.insert("Becky", 0);
		sll.printNodes();
		sll.insert("Bobby", sll.size());
		sll.printNodes();
		sll.insert("Bubba", sll.size()-1);
		sll.printNodes();
	}
	
	
	public class Node{
		String data;
		Node next;
	}

}

