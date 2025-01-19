package StreamAPI;

import StreamAPI.models.Department;
import StreamAPI.models.Employee;
import StreamAPI.models.Student;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basics {
	public static void main(String[] args) {

		/* Filtering Elements with filter() */
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		/* Transforming Elements with map() */
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		List<Integer> nameLengths = names.stream().map(String::length).collect(Collectors.toList());

		/* Looping through Elements with forEach() */
		List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");
		names1.stream().forEach(System.out::println);

		/* Combining Elements with reduce() */
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
		int sum = numbers1.stream().reduce(0, (a, b) -> a + b);

		/* Distinct Elements: Return distinct elements in a stream */
		List<Integer> numbers2 = Arrays.asList(1, 2, 2, 3, 3, 3);
		List<Integer> distinctNumbers = numbers2.stream().distinct().collect(Collectors.toList());

		/* Sorting Elements: Return a sorted stream */
		List<Integer> numbers3 = Arrays.asList(5, 2, 8, 1, 7);
		List<Integer> sortedNumbers = numbers3.stream().sorted().collect(Collectors.toList());

		/* Limiting Elements: Limit the number of elements in the stream */
		List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> limitedNumbers = numbers4.stream().limit(5).collect(Collectors.toList());

		/* Skipping Elements: Skip the first ’n’ elements in the stream. */
		List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> skippedNumbers = numbers5.stream().skip(5).collect(Collectors.toList());

		/* Matching Elements: Check if elements match a condition. */
		List<String> names3 = Arrays.asList("Alice", "Bob", "Charlie");
		boolean containsA = names3.stream().anyMatch(name -> name.contains("A"));
		boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
		boolean noneContainZ = names.stream().noneMatch(name -> name.contains("Z"));

		/* Transform and Flatten */
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));

		// Nested list into a single list
		Stream<Integer> flattenedStream = nestedList.stream().flatMap(integers -> integers.stream());
		flattenedStream.forEach(System.out::println);

		List<String> words = Arrays.asList("Hello", "World", "Java", "Streams");
		Stream<String> characters = words.stream().flatMap(word -> Arrays.stream(word.split(""))).distinct();
		characters.forEach(System.out::println);

		/* Debugging or monitoring */
		Stream<Integer> numbers6 = Stream.of(1, 2, 3, 4, 5);
		// Use peek to print each number before performing an operation
		numbers6.peek(n -> System.out.println("Processing: " + n)).map(n -> n * 2).forEach(System.out::println);

		/*** Grouping and Summarizing Data ***/

		List<Employee> employees = Arrays.asList(
				new Employee("ABC", "ABC", 1000000),
				new Employee("DEF", "DEF", 1000000),
				new Employee("XYZ", "XYZ", 1000000)
		);

		/* Group Employees by Department and Count */
		Map<String, Long> employeeCountByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		/* Find the Highest Paid Employee in Each Department */
		Map<String, Optional<Employee>> highestPaidByDept = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

		/* Calculate Average Salary by Department */
		Map<String, Double> averageSalaryByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));


		List<Student> students = Arrays.asList(
				new Student(101,"ABC","abc@gmail.com", 3.90,
							Arrays.asList("1111111111","2222222222"))
		);

		/*Partition Students into Passing and Failing*/
		double PASS_THRESHOLD = 3.0;
		Map<Boolean, List<Student>> passingFailing = students.stream()
				 .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
		
		
		

	}
}
