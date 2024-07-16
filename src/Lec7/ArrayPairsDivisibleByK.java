package Lec7;

import java.util.HashMap;
import java.util.Map;

public class ArrayPairsDivisibleByK {
	public boolean arrayPairs(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a : arr) { // for(int i=0;i<arr.length;i++) -> int a = arr[i]
			int r = a % k;
			int freq = map.getOrDefault(r, 0) + 1;
			map.put(r, freq);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int rem = entry.getKey();
			int count = entry.getValue();

			if (rem == 0) {
				// remainder=0 need to handle specially
				if (count % 2 == 1) { // count needs to be even{
					return false;
				}
			} else {
				int opposite = k - rem;
				int countOfOpposite = map.getOrDefault(opposite, -1);
				if (count != countOfOpposite) {
					return false;
				}
			}
		}
		return true;
	}
}
