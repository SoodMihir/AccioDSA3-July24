package Lec3;

public class PeakElement {
	public int findPeak(int arr[], int n) {
		if (n == 1) {
			return 0;
		}

		// Check if corner elements are peak
		if (arr[0] > arr[1]) {
			// left corner is the peak
			return 0;
		} else if (arr[n - 1] > arr[n - 2]) {
			// right corner is the peak
			return n - 1;
		}

		int lo = 1;
		int hi = n - 2;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				// mid is the peak element
				return mid;
			} else if (arr[mid] < arr[mid + 1]) {
				// next is greater than current
				// Answer will be on right side
				lo = mid + 1;
			} else if (arr[mid - 1] > arr[mid]) {
				// prev is greater than mid
				// Answer will be on left side
				hi = mid - 1;
			}
		}
		return 0;
	}
}
