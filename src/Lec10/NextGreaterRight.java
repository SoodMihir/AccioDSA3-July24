package Lec10;

import java.util.Stack;

public class NextGreaterRight {
	public static long[] nextLargerElement(long[] arr, int n) {
		long[] ngr = new long[n];

		Stack<Integer> stack = new Stack<>(); // potential greater elements
		// we will store the indexes of elements in stack

		for (int i = 0; i < n; i++) {

			// check in stack if arr[i] is ngr for any element
			while (stack.size() != 0 && arr[stack.peek()] < arr[i]) {
				// arr[i] is the ngr for top element
				int prevEleIdx = stack.pop();
				ngr[prevEleIdx] = arr[i];
			}

			stack.push(i);
		}

		// if stack is not empty, some elements are there without ngr
		while (stack.size() > 0) {
			int prevEleIdx = stack.pop();
			ngr[prevEleIdx] = -1;
		}
		
		return ngr;
	}
}
