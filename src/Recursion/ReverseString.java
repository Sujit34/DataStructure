package Recursion;

public class ReverseString {
	public static int count = 0;
	public static String reverse = "";
	
	public static void main(String[] args) {
		reverseString("recursion");		
	}	

	public static void reverseString(String str) {	
		
		if(str == null || str.equals("")) {
			return ;
		}
		else
		{			
			reverseString(str.substring(1));	
			System.out.print(str.charAt(0));
			
		}		
	}
}

