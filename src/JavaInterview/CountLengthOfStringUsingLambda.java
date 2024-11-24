package JavaInterview;

import java.util.stream.Stream;

public class CountLengthOfStringUsingLambda {
	public static void main(String[] args) {

		length len = (str) -> {
			// return str.length();

			int count = 0;
			while (!str.isEmpty()) {
				count++;
				str = str.substring(1);
			}
			return count;
		};
		System.out.println(len.len("aaaaa"));
	}

	interface length {
		int len(String str);
	}
}
