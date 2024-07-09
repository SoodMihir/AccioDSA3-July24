package Lec2;

public class Search2D {
	public static boolean SearchA2DMatrixStairCase(int[][] mat, int x) {
		// Write your code here
		int r = 0;
		int c = mat[0].length - 1;
		while (r < mat.length && c >= 0) {
			if (mat[r][c] == x) {
				return true;
			} else if (mat[r][c] > x) {
				// go to left dirn
				c--;
			} else {
				// go to bottom dirn
				r++;
			}
		}
		return false;
	}

	public static boolean SearchA2DMatrix(int[][] mat, int x) {
		// Write your code here
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; i++) {
			int[] arr = mat[i];
			if (binarySearch(arr, x)) {
				return true;
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return false;
	}
}
