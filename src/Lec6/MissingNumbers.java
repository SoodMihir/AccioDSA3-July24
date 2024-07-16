package Lec6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MissingNumbers {
	static void missingNumbers(int n, int arr[], int m, int brr[]) {
		// O(n)
		HashMap<Integer, Integer> freq1 = new HashMap<>();
		// map of element vs freq
		for (int i = 0; i < n; i++) {
			int freq;
			if (freq1.containsKey(arr[i])) { // the number was already in the hashmap
				freq = freq1.get(arr[i]) + 1;
			} else {
				freq = 1;
			}
			freq1.put(arr[i], freq);
		}

		// O(m)
		HashMap<Integer, Integer> freq2 = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int freq;
			if (freq2.containsKey(brr[i])) { // the number was already in the hashmap
				freq = freq2.get(brr[i]) + 1;
			} else {
				freq = 1;
			}
			freq2.put(brr[i], freq);
		}

		// keySet returns all the keys - - O(m* logm)
		ArrayList<Integer> keys = new ArrayList<>(freq2.keySet());
		Collections.sort(keys);

		// compare the keys - O(m)
		for (int k : keys) {
			if (freq1.containsKey(k)) {
				if (freq1.get(k) == freq2.get(k)) {
					// do not print
				} else {
					// freq is different in both of the maps
					System.out.print(k + " ");
				}
			} else {
				// key missing in A1
				System.out.print(k + " ");
			}
		}

		// TC: O(n)+O(m)+O(m*lgm) + O(m) = O(m*lgm)
	}
}
