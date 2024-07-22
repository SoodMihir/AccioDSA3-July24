package Lec8;

import java.util.HashMap;

public class SubarraySumEqualsK {
	static int solve(int N, int[] Arr, int K) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int res = 0;
		for (int a : Arr) {
			sum += a;
			if (map.containsKey(sum - K)) {
				res += map.get(sum - K);
			}
			int curr_freq = map.getOrDefault(sum, 0) + 1;
			map.put(sum, curr_freq);
		}

		return res;
	}
}
