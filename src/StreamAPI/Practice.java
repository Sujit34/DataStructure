package StreamAPI;

import StreamAPI.models.Person;
import StreamAPI.models.Transaction;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
	public static void main(String[] args) {
		LongestString();
	}

	/*
	 * Write a Java program to calculate the average of a list of integers using
	 * streams.
	 */
	public static void AverageOfAListOfIntegers() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		double res = list.stream().mapToDouble(Integer::doubleValue)
				.average().orElse(0.0);
		System.out.println(res);
	}

	/*
	 * Write a Java program to convert a list of strings to uppercase or lowercase
	 * using streams.
	 */
	public static void ConvertAListOfStringsToUppercaseOrLowerCase() {
		List<String> list = new ArrayList<String>();
		list.add("aBc");
		list.add("aBc");
		list.add("aBc");

		list.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
		list.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
	}

	/*
	 * Write a Java program to calculate the sum of all even, odd numbers in a list
	 * using streams.
	 */
	public static void CalculateTheSumOfAllEvenOddNumbersInAList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		int evenSum = list.stream().filter(x -> x % 2 == 0)
				.mapToInt(Integer::intValue).sum();
		int oddSum = list.stream().filter(x -> x % 2 == 1)
				.mapToInt(Integer::intValue).sum();
	}

	/*
	 * Write a Java program to remove all duplicate elements from a list using
	 * streams.
	 */
	public static void RemoveAllDuplicateElementsFromAList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(3);

		list.stream().distinct().collect(Collectors.toList());
	}

	/*
	 * Write a Java program to count the number of strings in a list that start with
	 * a specific letter using streams.
	 */
	public static void CountTheNumberOfStringsInAListThatStartWithASpecificLetter() {
		List<String> list = new ArrayList<String>();
		list.add("aBc");
		list.add("bBc");
		list.add("cBc");
		char c = 'a';
		list.stream().filter(x -> x.startsWith(String.valueOf(c))).count();
	}

	/*
	 * Write a Java program to sort a list of strings in alphabetical order,
	 * ascending and descending using streams.
	 */
	public static void SortAListOfStringsInAlphabeticalOrder() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("acb");
		list.add("abd");

		list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	/*
	 * Write a Java program to find the maximum and minimum values in a list of
	 * integers using streams.
	 */
	public static void FindTheMaximumAndMinimumValuesInAList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		int max = list.stream().max((x, y) -> Integer.compare(x, y)).orElse(null);
		int min = list.stream().min((x, y) -> Integer.compare(x, y)).orElse(null);
	}

	/*
	 * Write a Java program to find the second smallest and largest elements in a
	 * list of integers using streams.
	 */
	public static void FindTheSecondSmallestAndLargestElementsInAList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);

		int secondSmallest = list.stream().distinct().sorted().skip(1)
				.findFirst().orElse(null);
		int largest = list.stream().distinct().sorted((x, y) -> Integer.compare(y, x))
				.skip(1).findFirst().orElse(null);

	}
	
	/*Find the longest string in a list of strings using Java streams*/
	
	public static void LongestString() {
		List<String> strings = Arrays
	              .asList("apple", "banana", "cherry", "date", "grapefruit");
		
		String longestString = strings.stream()
				.max(Comparator.comparingInt(s->s.length())).toString();
	}
	
	/*Calculate the average age of a list of Person objects using Java streams*/
	public static void AverageAge() {
		List<Person> persons = Arrays.asList(
			    new Person("Alice", 25),
			    new Person("Bob", 30),
			    new Person("Charlie", 35)
			);
		persons.stream().mapToInt(Person::getAge).average().orElse(0);
	}
	
	/*Check if a list of integers contains a prime number using Java streams*/
	public static void isContainsPrimeNumber() {
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);		
		boolean containsPrime = numbers.stream().anyMatch(Practice::isPrime);
	}
	public static boolean isPrime(int number) {
		if(number<=1) return false;
		for(int i=0;i<Math.sqrt(i);i++) {
			if(number%i==0)return false;
		}
		return true;
	}
	
	
	/*Merge two sorted lists into a single sorted list using Java streams*/
	public static void SortedInASingle() {
		List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
		List<Integer> mergeList = Stream.concat(list1.stream(), list2.stream())
				.sorted().collect(Collectors.toList());		
	}
	
	/*Find the intersection of two lists using Java streams*/
	
	public static void IntersectionOfTwoList() {
		List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
		List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
		List<Integer> intersectionOfList = list1.stream()
				.filter(list2::contains).collect(Collectors.toList());
	}
	
	/* Remove duplicates from a list while preserving the order using Java streams */
	public static void RemoveDuplicate() {
		List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
		List<Integer> numbersWithoutDuplicates = numbersWithDuplicates.stream()
				.distinct().collect(Collectors.toList());		
	}
	
	/*Given a list of transactions, find the sum of transaction amounts for each day 
	 * using Java streams
	 */
	public static void Transactions() {
		List<Transaction> transactions = Arrays.asList(
			    new Transaction("2022-01-01", 100),
			    new Transaction("2022-01-01", 200),
			    new Transaction("2022-01-02", 300),
			    new Transaction("2022-01-02", 400),
			    new Transaction("2022-01-03", 500)
			);
		transactions.stream().collect(Collectors.groupingBy(Transaction::getDate,
						Collectors.summingInt(Transaction::getAmount)));
				
	}
	/*Find the kth smallest element in an array using Java streams*/
	
	public static void KthSmallestElement() {
		int[] array = {4, 2, 7, 1, 5, 3, 6};
		int k = 3;
		Arrays.stream(array).sorted().skip(k-1).findFirst().orElse(-1);
	}
	
	/*Given a list of strings, find the frequency of each word using Java streams*/
	
	public static void FrequencyOfEachWord() {
		List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", 
                "banana", "apple");
		Map<String,Long> frequencyOfWord = words.stream()
				.collect(Collectors.groupingBy(Function.identity(),
						Collectors.counting()));
	}
	
	/*Implement a method to partition a list into two groups based on a predicate using Java streams*/
	public static void PartitionedList() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean,List<Integer>> partioned = numbers.stream()
				.collect(Collectors.partitioningBy(x->x%2==0));
		List<Integer> evenPartition = partioned.get(true);
		List<Integer> oddPartition = partioned.get(false);
	}
	

	/* Implement a method to calculate the Fibonacci sequence using Java streams*/
	public static void Fibonacci(){
		Stream.iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
				.limit(20)
				.map(fib -> fib[0])
				.forEach(System.out::println);
	}





	/* Count the occurrences of each number*/
	public static void occurrencesOfEachNumber(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 7, 8, 9, 9);
		Map<Integer, Long> frequencyMap = numbers.stream()
				.collect(Collectors
						.groupingBy(Function.identity(), Collectors.counting()) //count occurrences and save in a map structure
				);

	}

	/* Filter out non-duplicate numbers */
	public static void NonDuplicateNumber(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 7, 8, 9, 9);
		numbers.stream()
				.collect((Collectors.groupingBy(Function.identity(),Collectors.counting()))) // Count occurrences in Map
				.entrySet().stream() //convert map entries back to stream
				.filter(x->x.getValue()>1) // keep the duplicate numbers
				.map(Map.Entry::getKey) // get the duplicate numbers
				.collect(Collectors.toList());
	}
}
