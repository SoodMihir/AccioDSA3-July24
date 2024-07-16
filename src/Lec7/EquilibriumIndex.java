package Lec7;

public class EquilibriumIndex {
	static int findEquilibriumIndex(int[] a) {
		int n = a.length;
		if (n == 1) {
			return 0;
		}
		int[] pre = new int[n];
		pre[0] = 0;
		for (int i = 1; i < n; i++) {
			pre[i] = pre[i - 1] + a[i - 1];
		}
		int[] suff = new int[n];
		suff[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			suff[i] = suff[i + 1] + a[i + 1];
		}
		for (int i = 0; i < n; i++) {
			if (pre[i] == suff[i]) {
				return i;
			}
		}
		return -1;
	}
}
