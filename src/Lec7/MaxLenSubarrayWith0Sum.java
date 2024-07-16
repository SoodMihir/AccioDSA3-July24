package Lec7;

import java.util.HashMap;

public class MaxLenSubarrayWith0Sum {
	public int maxLen(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0, -1);
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				int lastIdx = map.get(sum);
				int currLen = i - lastIdx;
				len = Math.max(len, currLen);
			} else {
				map.put(sum, i);
			}
		}
		return len;
	}
}
