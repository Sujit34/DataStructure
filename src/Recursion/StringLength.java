package Recursion;

public class StringLength {
	public static int len = 0;
	public static void main(String[] args) {
		System.out.println(length("recursion"));
	}
	public static int length(String str) {
		
		// My solution		
		
		if(str == null || str.equals("")) {
			return len;
		}
		else {
			//len++;
			length(str.substring(1));
			return ++len; //len++ will give wrong answer.
			//return len;
		}
		
		
		
		//Teacher solution
		/*
		if(str == null || str.equals("")) {
			return 0;
		}
		else
		{			
			return 1+ length(str.substring(1));		
			
		}
		*/		
	}
}

