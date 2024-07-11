package Lec3;

public class SearchInBitonicArray {
	private static int findPeakIdx(int[] arr, int n) {
		int lo = 0;
		int hi = n - 1;
		if (arr.length == 1) {
			return arr[0];
		} else if (arr.length == 2) {
			if (arr[0] > arr[1])
				return 0;
			else
				return 1;
		}
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
				return mid;
			} else {
				if (mid == 0) {
					if (arr[mid] < arr[mid + 1]) {
						lo = mid + 1;
					} else {
						return mid;
					}
				} else if (mid == n - 1) {
					if (arr[mid] > arr[mid - 1]) {
						return mid;
					} else {
						hi = mid - 1;
					}
				} else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
					// Increasing side
					lo = mid + 1;
				} else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					// Decreasing side
					hi = mid - 1;
				}
			}
		}
		return lo;
	}

	private static int BSIncreasing(int[] arr, int lo, int hi, int target) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}

	private static int BSDecreasing(int[] arr, int lo, int hi, int target) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}

	static int findElement(int arr[], int n, int target) {
		int peakIdx = findPeakIdx(arr, n);
		int left = BSIncreasing(arr, 0, peakIdx, target);
		if (left != -1) {
			return left;
		}
		return BSDecreasing(arr, peakIdx, n - 1, target);
	}
}
