package Recursion;

import java.util.LinkedList;
import java.util.List;

public class FindMin {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(1); list.add(2);list.add(3);
		list.add(4); list.add(5);list.add(6);
		
		if(list == null || list.isEmpty()) return;
		System.out.println(recFindMin(list,0));	
		
		System.out.println(recurFindMin(list));	
	}
	
	//without modifing the list
	private static Integer recFindMin(List<Integer> list,int index) {
		Integer first= list.get(index);
		if(index==(list.size()-1)) return first;
		int recFind = recFindMin(list,index+1);
		return recFind < first? recFind : first;		
	}
	
	//modifing the list
		private static Integer recurFindMin(List<Integer> list) {
			Integer first= list.remove(0);
			if(list.isEmpty()) return first;
			int recFind = recurFindMin(list);
			return recFind < first? recFind : first;		
		}

}
