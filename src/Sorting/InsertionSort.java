package Sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		insertionSort(arr);

		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void insertionSort(int arr[]) {
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = i - 1;
 
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = value;
        }
		
	}

}
