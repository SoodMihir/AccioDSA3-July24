package Lec3;

public class RotatedSorted {
	public int search(final int[] a, int target) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == target) {
				return mid;
			} else if (a[lo] <= a[mid]) { // left part sorted
				if (a[lo] <= target && target < a[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else { // right part is sorted
				if (a[mid] < target && target <= a[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}
}
