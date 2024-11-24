package JavaInterview;

import java.util.*;

public class HashMapSortingBasedOnValue {
	public static void main(String[] args) {
		// Create a HashMap
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("John", 25);
		hashMap.put("Alice", 30);
		hashMap.put("Bob", 20);
		hashMap.put("Eve", 35);

		// Convert the HashMap to a List of Map.Entry objects
		List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>();
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			entryList.add(entry);
		}

		// Sort the List based on the values using a custom comparator
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
				return entry1.getValue().compareTo(entry2.getValue());
			}
		});

		// Create a new LinkedHashMap to store the sorted entries
		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : entryList) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		// Display the sorted HashMap
		for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}
}
