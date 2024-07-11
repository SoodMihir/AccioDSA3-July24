package Lec3;

public class PeakIndex {
	public int peakIndexInMountainArray(int[] A) {
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] < A[mid + 1]) {
				// Increasing side -> Move towards right
				lo = mid + 1;
			} else {
				// Decreasing side -> Move towards left
				hi = mid;
			}
		}
		return lo;
	}
}
