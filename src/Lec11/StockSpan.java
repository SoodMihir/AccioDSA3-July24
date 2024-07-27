package Lec11;

import java.util.Stack;

public class StockSpan {
	class Pair {
		int val;
		int idx;

		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}

	static int[] stockSpan(int[] prices) {

		Stack<Integer> stack = new Stack<>();
		// store idx of greater elements on left

		int n = prices.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			int curr_price = prices[i];

			while (!stack.isEmpty() && prices[stack.peek()] <= curr_price) {
				// remove smaller or equal elements from the stack
				stack.pop();
			}

			if (stack.isEmpty()) {
				// current element is the greatest element so far
				// no elements greater than current element was found on left side
				res[i] = i + 1;
			} else {
				// we found a greater element on the left side
				// all the elements between the greater element on left and i
				// are included in the span
				res[i] = i - stack.peek();
			}
			stack.push(i);
		}
		return res;
	}
}
