package Test;
import java.util.*;

public class AmexTest {
	public static void main(String ars[]) {
		retfunc("ABC ABC DEF DEF DEF",2);
	}
	public static void retfunc(String str, int n){
		
		String[] arrayOfStrings = str.split("\\s+"); // split on space
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		
		for(int i=0;i<arrayOfStrings.length;i++) {
			if(!hashMap.containsKey(arrayOfStrings[i])) {
				hashMap.put(arrayOfStrings[i], 1);
			}
			else {
				hashMap.put(arrayOfStrings[i],hashMap.get(arrayOfStrings[i])+1);
			}			
		}
		
		
		// sort the hashmap according to value
		
		List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
		
		//loop over hashmap to insert each entry in the list
		
		for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
			list.add(entry);
		}
		
		//sort the list using the comparator
		
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
				return entry2.getValue().compareTo(entry1.getValue());
			}
			
		});
		
		//insert into the linkedhashMap
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, Integer> entry : list){
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		
		int count=0;
		for(Map.Entry<String, Integer> entry : linkedHashMap.entrySet()){
			System.out.println(entry.getKey()+ " " +entry.getValue());
			count++;
			if(count ==n)break;
		}
		
				
	}

}
