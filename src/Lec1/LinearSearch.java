package Lec1;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 7, 9, 13, 18 };
		int target = 90;
		int idx = linearSearch(arr, target);
		System.out.println(target + " is at " + idx + " index");
	}

	private static int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
