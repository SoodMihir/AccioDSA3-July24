package Lec2;

public class FloorOfRotated {
	public static int searchFloor(int[] a, int b) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == b) {
				return mid;
			} else if (a[mid] > b) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo - 1;
	}

}
