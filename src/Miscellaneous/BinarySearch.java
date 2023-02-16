package Miscellaneous;

public class BinarySearch {
	public static int recursiveBinarySearch(int array[], int low, int high, int searchValue) {

		int mid = (low + high) / 2;
		int index = -1;

		if (low > high)
			return index;

		if (array[mid] == searchValue)
			return mid;
		else if (array[mid] > searchValue)
			return recursiveBinarySearch(array, low, mid - 1, searchValue);
		else if (array[mid] < searchValue)
			return recursiveBinarySearch(array, mid + 1, high, searchValue);
		;
		return index;
	}

	public static int iterativeBinarySearch(int array[], int searchValue) {

		int index = -1;
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == searchValue)
				return mid;
			else if (array[mid] > searchValue)
				high = mid - 1;
			else if (array[mid] < searchValue)
				low = mid + 1;
		}
		return index;
	}

	public static void main(String[] args) {
		int arr[] = { -1, 0, 3, 5, 9, 10 };
		System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 12));
		System.out.println(iterativeBinarySearch(arr, 12));
	}
}
