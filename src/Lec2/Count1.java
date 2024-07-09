package Lec2;

public class Count1 {
	static int count1(int size, int arr[]) {
		int lastIdx = -1;
		int lo = 0;
		int hi = size - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == 1) {
				lastIdx = mid;
				lo = mid + 1; // search for better ans on right side
			} else { // arr[mid]==0
				hi = mid - 1;
			}
		}

		return lastIdx + 1;
	}
}
