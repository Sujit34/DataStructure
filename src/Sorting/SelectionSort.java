package Sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		selectionSort(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void selectionSort(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			// Find the minimum element in unsorted array
			int min =arr[i];
			int index = i;
			for(int j = i;j<arr.length;j++) {
				if(arr[j]<min) {
					min=arr[j];
					index= j;
				}
			}
			//Swap the found minimum element with the first element
			arr[index] = arr[i];
			arr[i] = min;
			
		}
	}

}
