package JavaInterview;

import java.util.*;

public class HashMapSortingBasedOnValue {
	public static void main(String[] args){
		HashMap<String, Integer> departmentWithStudentCounts = new HashMap<>();
		departmentWithStudentCounts.put("EEE", 120);
		departmentWithStudentCounts.put("ME", 110);
		departmentWithStudentCounts.put("CSE", 120);
		departmentWithStudentCounts.put("CE", 130);
		departmentWithStudentCounts.put("ETE", 30);

		var sortedValue = sortByValue(departmentWithStudentCounts);
		Iterator<Map.Entry<String,Integer>> iterator = sortedValue.entrySet().iterator();
		while (iterator.hasNext()){
			var entry = iterator.next();
			System.out.println(entry.getKey() + "   " + entry.getValue());
		}


	}

	public static LinkedHashMap<String,Integer> sortByValue(HashMap<String,Integer> departmentWithStudentCounts){
		//insert the entries into List
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(departmentWithStudentCounts.entrySet());

		// initially sort based on value. If values are equal then sort based on key
		entries.sort((x,y)->{
			int valueComparison = x.getValue().compareTo(y.getValue());
			if(valueComparison!=0) return valueComparison;
			else return x.getKey().compareTo(y.getKey());
		});

		//insert into LikedHashMap.
		LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
		entries.forEach(x->linkedHashMap.put(x.getKey(),x.getValue()));

		return linkedHashMap;

	}

}
