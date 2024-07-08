package Lec1;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 6, 8, 9, 11, 15 };
		int target = 15;
		int idx = binarySearch(arr, target);
		int idx1 = binarySearchRecursive(arr, target, 0, arr.length - 1);
		System.out.println(target + " is at " + idx1 + " index");

	}

	private static int binarySearchRecursive(int[] arr, int target, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] > target) {
			return binarySearchRecursive(arr, target, lo, mid - 1);
		} else {
			// arr[mid]<target
			return binarySearchRecursive(arr, target, mid + 1, hi);
		}
	}

	private static int binarySearch(int[] arr, int target) {
		int lo = 0; // start idx
		int hi = arr.length - 1; // end idx
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2; // mid idx of SS
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				// search on right side
				lo = mid + 1;
			} else {
				// arr[mid]>target
				// search on left side
				hi = mid - 1;
				
			}
		}
		return -1;
	}

}
