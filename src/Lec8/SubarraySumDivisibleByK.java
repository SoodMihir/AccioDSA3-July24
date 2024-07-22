package Lec8;

import java.util.HashMap;

public class SubarraySumDivisibleByK {
	public static int subarrayDivisbleByK(int arr[], int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// remainder vs count
		map.put(0, 1);
		int rem = 0;
		int res = 0;
		for (int a : arr) {
			rem = (rem + a % k + k) % k; // Done to handle -ve cases
			if (map.containsKey(rem)) {
				res += map.get(rem);
			}
			int curr = map.getOrDefault(rem, 0);
			map.put(rem, curr + 1);
		}
		return res;
	}
}
