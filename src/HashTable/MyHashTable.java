package HashTable;

import java.util.LinkedList;

import java.util.Iterator;

public class MyHashTable {
	private static final int initial_Size = 20;
	private int tableSize;
	private LinkedList[] table;
	
	MyHashTable(){
		this(initial_Size);
	}
	
	MyHashTable(int tableSize){
		this.tableSize = tableSize;
		table = new LinkedList[tableSize];	
	}
	
	private class Entry{
		private Object key;
		private Object value;
		
		Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
		
		public String toString() {
			return key.toString() + "->" + value.toString();
		}
	}
	
	
	private int hash(int hashCode) {
		return Math.abs( hashCode % tableSize);
	}
	
	
	
	private boolean ContainKey(Object key) {
		if(key==null) return false;
		
		int hashCode = key.hashCode();
		int hashValue = hash(hashCode);
		
		if(table[hashValue] == null) return false;
		
		Iterator it = table[hashValue].iterator();

		while(it.hasNext()) {
			Entry e = (Entry) it.next();
			if(e.key.equals(key)) return true;			
		}
		
		return false;	
	}
	
	
	private void insert(Object key, Object value) {
		if(key == null) return;
		
		int hashCode = key.hashCode();
		int hashValue = hash(hashCode);
		
		Entry e = new Entry(key,value);
		
		boolean keyAlreadyInUse = false; 	
				
		if(table[hashValue]!=null) {
			Iterator it = table[hashValue].iterator();
			
			while(it.hasNext()) {
				e = (Entry) it.next();
				if(e.key.equals(key)) {
					e.value = value;
					keyAlreadyInUse = true;				
				}
			}
		}
		
		if(!keyAlreadyInUse) {
			if(table[hashValue] == null) {
				table[hashValue] = new LinkedList();
			}
			table[hashValue].add(e);
		}		
	}
	
	
	
	private Object get(Object key) {
		if(key == null) return null;
		if(!ContainKey(key)) return null;
		
		int hashCode = key.hashCode();
		int hashValue = hash(hashCode);	
		
		Entry e= null;
		Iterator it = table[hashValue].iterator();
		while(it.hasNext()) {
			e = (Entry) it.next();
			if(e.key.equals(key)) {
				return e.value;
			}
		}
		return null;
	}
	
	
	
	private Object remove(Object key) {
		if(key == null) return null;
		if(!ContainKey(key)) return null;
		
		int hashCode = key.hashCode();
		int hashValue = hash(hashCode);		
		
		Entry e =null;
		int IndexTable =-1;
		Object value = null;
		Iterator it = table[hashValue].iterator();
		
		while(it.hasNext()) {
			e = (Entry) it.next();
			if(e.key.equals(key)) {
				IndexTable = table[hashValue].indexOf(e);
				value = e.value;
			}
		}
		
		if(IndexTable == -1) return null;
		else {
			
			table[hashValue].remove(IndexTable);
			return value;
		}
	}
	
	public static void main(String[] args) {
		MyHashTable myHashTable = new MyHashTable();
		myHashTable.insert("Tom", "Tom....");
		System.out.println(myHashTable.get("Tom"));
		myHashTable.insert("Bob", "Bob....");
		System.out.println(myHashTable.get("Bob"));		
		myHashTable.remove("Bob");
		System.out.println(myHashTable.get("Bob"));
	}
	
	
}
