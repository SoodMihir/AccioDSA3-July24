package Lec11;

import java.util.Stack;

public class LargestAreaHistogram {
	public static long maximumArea(long hist[], int n) {
		long max_area = 0L;
		Stack<Integer> stack = new Stack<>();
		// Stack will store the indexes of the unprocessed previous elements smaller
		// than current element

		for (int i = 0; i <= n; i++) {
			// check if current bar is blocking for any previous bigger bar
			while (stack.size() != 0 && (i == n || (hist[i] < hist[stack.peek()]))) {
				int nsri = i; // current element is blocking from right
				long ht = hist[stack.pop()]; // blocked element is the height
				int nsli = stack.isEmpty() ? -1 : stack.peek();
				// -1 if no elements present on left side -> -1 index will block from left side
				// stack.peek() index will block from left as it will definitely contain a
				// smaller element than ht

				long curr_area = ht * (nsri - nsli - 1);
				max_area = Math.max(max_area, curr_area);
			}
			stack.push(i); // add curr idx in stack for further evaluations
		}
		return max_area;
	}
}
