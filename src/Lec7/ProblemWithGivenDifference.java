package Lec7;

import java.util.HashSet;

public class ProblemWithGivenDifference {
	public int givenDifference(int[] A, int n, int B) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : A) {
			if (set.contains(num + B) || set.contains(num - B)) {
				return 1;
			}
			set.add(num);
		}
		return 0;
	}
}
