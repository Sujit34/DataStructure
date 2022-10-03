package Recursion;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};		
		System.out.println(recSearch(arr,4,0,arr.length-1));
		System.out.println(recSearch(arr,14,0,arr.length-1));
	}
	
	private static boolean recSearch(int[] arr, int x, int lower, int upper) {
		if(lower>upper)return false;
		int mid = (lower+upper)/2;
		if(arr[mid]==x) return true;
		if(x<arr[mid])
			return recSearch(arr,x,lower,mid-1);
		else 
			return recSearch(arr,x,mid+1,upper);
	}
}

