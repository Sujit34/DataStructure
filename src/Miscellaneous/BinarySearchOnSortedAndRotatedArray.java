package Miscellaneous;

public class BinarySearchOnSortedAndRotatedArray {

	public static int pivotedBinarySearch(int arr[], int target) {
		int pivotIndex = findPivot(arr, 0, arr.length - 1);
		if (arr[pivotIndex] == target)
			return pivotIndex;
		if (pivotIndex == -1)
			return binarySearch(arr, 0, arr.length - 1, target);
		if (arr[0] <= target)
			return binarySearch(arr, 0, pivotIndex - 1, target);
		return binarySearch(arr, pivotIndex + 1, arr.length - 1, target);
	}

	public static int findPivot(int arr[], int low, int high) {

		int mid = (low + high) / 2;

		if (high < low)
			return -1; // array is not rotated.
		if (high == low)
			return low;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return mid - 1;
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

	public static int binarySearch(int array[], int low, int high, int target) {

		int mid = (low + high) / 2;
		int index = -1;

		if (low > high)
			return index;

		if (array[mid] == target)
			return mid;
		else if (array[mid] > target)
			return binarySearch(array, low, mid - 1, target);
		else if (array[mid] < target)
			return binarySearch(array, mid + 1, high, target);
		return index;
	}

	public static void main(String args[]) {
		int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 3;
		System.out.println("Index of the element is : " + pivotedBinarySearch(arr, target));
	}
}

/*
 
 Follow the steps mentioned below to implement the idea:  

-Find out the pivot point using binary search. We will set the low pointer as the first array index and high with the last array index.
	-From the high and low we will calculate the mid value. 
	-If the value at mid-1 is greater than the one at mid, return that value as the pivot.
	-Else if the value at the mid+1 is less than mid, return mid value as the pivot.
	-Otherwise, if the value at low position is greater than mid position, consider the left half. Otherwise, consider the right half.
-Divide the array into two sub-arrays based on the pivot that was found.
-Now call binary search for one of the two sub-arrays.
	-If the element is greater than the 0th element then search in the left array
	-Else search in the right array.
-If the element is found in the selected sub-array then return the index
-Else return -1.

 */
