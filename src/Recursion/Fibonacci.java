package Recursion;

public class Fibonacci {
	public static int fib = 1,sum1=1,sum2;
	public static void main(String[]args) {
		System.out.println(fibonacci(6));		
	}
	
	public static int fibonacci(int n) {
		
		if(n==0 ||n==1)	return sum2=1;
		else  return fibonacci(n-1) + fibonacci(n-2);
		/*else {
			fibonacci(n-1);
			fib =  sum1+ sum2;
			sum1 = sum2;
			sum2 = fib;
			
			return fib;
		}*/
	}
}