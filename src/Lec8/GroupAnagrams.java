package Lec8;

import java.util.*;

public class GroupAnagrams {
	static void printAnagramsTogether(String wordArr[], int size) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (String word : wordArr) {
			String sortedWord = getSortedString(word);
			if (map.containsKey(sortedWord)) {
				// add it into the map
				map.get(sortedWord).add(word);
			} else {
				map.put(sortedWord, new ArrayList());
				map.get(sortedWord).add(word);
			}
		}

		List<ArrayList<String>> sortValues = new ArrayList<>();
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			sortValues.add(entry.getValue());
		}
		Collections.sort(sortValues, (a, b) -> {
			String first = a.get(0);
			String second = b.get(0);
			return first.compareTo(second);
		});

		for (List<String> list : sortValues) {
			for (String word : list) {
				System.out.print(word + " ");
			}
		}

	}

	private static String getSortedString(String word) {
		char[] char_arr = word.toCharArray();
		Arrays.sort(char_arr);
		return new String(char_arr);
	}

}
