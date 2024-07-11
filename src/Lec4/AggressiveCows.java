package Lec4;

import java.util.Arrays;

public class AggressiveCows {
	public static int aggressiveCows(int stalls[], int cows) {
		int n = stalls.length;
		Arrays.sort(stalls);
		int minDis = 0;
		int maxDis = stalls[n - 1] - stalls[0];
		int ans = -1;
		while (minDis <= maxDis) {
			int midDis = minDis + (maxDis - minDis) / 2;
			if (isPossible(stalls, midDis, cows)) {
				ans = midDis;
				minDis = midDis + 1;
			} else {
				maxDis = midDis - 1;
			}
		}
		return ans;
	}

	private static boolean isPossible(int[] stalls, int currDis, int totalCows) {
		int noOfCowsPlaced = 1;
		int posn = stalls[0]; // position of last placed cow
		for (int i = 1; i < stalls.length; i++) {
			if (posn + currDis <= stalls[i]) {
				// -> Curr distance is sufficient to place a cow
				noOfCowsPlaced++;
				posn = stalls[i];
			}
		}
		return noOfCowsPlaced >= totalCows;
	}
}
