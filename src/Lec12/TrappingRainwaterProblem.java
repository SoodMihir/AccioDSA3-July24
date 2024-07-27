package Lec12;

public class TrappingRainwaterProblem {
	public void TappingWater(int[] arr, int n) {
		int[] lmax = new int[n]; // prefix max
		lmax[0] = -1;
		for (int i = 1; i < n; i++) {
			lmax[i] = Math.max(lmax[i - 1], arr[i - 1]);
		}
		int[] rmax = new int[n]; // suffix max
		rmax[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			rmax[i] = Math.max(rmax[i + 1], arr[i + 1]);
		}

		int totalWater = 0;
		for (int i = 0; i < n; i++) {
			// go on each building
			int currHt = arr[i];

			// look to left and get max
			int lht = lmax[i];
			// look to right and get max
			int rht = rmax[i];

			int blockingHt = Math.min(lht, rht);
			if (currHt < blockingHt) {
				// only store water when current height is less than blocking ht
				totalWater += (blockingHt - currHt);
			}
		}
		System.out.println(totalWater);
	}
}
