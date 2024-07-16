package Lec6;

import java.util.HashMap;

public class FirstElementToOccurKTimes {
	public void firstElementToOccurKTimes(int[] nums, int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
//			1) use containsKey(nums[i]) before using get
//			int freq = map.get(nums[i])+1;
//			2) use getOrDefault
			int freq = map.getOrDefault(nums[i], 0);
			freq++;
			map.put(nums[i],freq);
			if(freq == k) {
				System.out.println(nums[i]);
				return;
			}
		}
		System.out.println(-1);
	}
}
