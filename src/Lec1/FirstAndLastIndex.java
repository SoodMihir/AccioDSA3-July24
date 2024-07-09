package Lec1;

public class FirstAndLastIndex {
	public static void findPosition(int a[], int n, int k) {
		int first = first(a, n, k);
		int last = last(a, n, k);
		System.out.println(first + " " + last);
	}

	public static int first(int[] a, int n, int target) {
		int lo = 0;
		int hi = n - 1;
		int first = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == target) {
				first = mid;
				hi = mid - 1; // better ans on left
			} else if (a[mid] > target) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return first;
	}

	public static int last(int[] a, int n, int target) {
		int lo = 0;
		int hi = n - 1;
		int last = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == target) {
				last = mid;
				lo = mid + 1; // better ans on right
			} else if (a[mid] > target) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return last;
	}

}
