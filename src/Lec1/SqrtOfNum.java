package Lec1;

public class SqrtOfNum {
	public static int sqrt(int A) {
		int lo = 1;
		int hi = 10000;
		int ans = 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int sq = mid * mid;
			if (sq == A) {
				return mid;
			} else if (sq < A) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return ans;
	}

}
