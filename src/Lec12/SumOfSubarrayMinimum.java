package Lec12;

import java.util.Stack;

public class SumOfSubarrayMinimum {
	public long minSubarraySum(int n, int a[]) {
		int[] nseli = nextSmallerOnLeftIndexes(a, n);
		int[] nseri = nextSmallerOnRightIndexes(a, n);
		long sum = 0L;
		int mod = (int) (1e9 + 7);

		for (int i = 0; i < n; i++) {
			int no_greater_l = i - nseli[i] - 1;
			int no_greater_r = nseri[i] - i - 1;

			long eleMinSubCount = (((1 + no_greater_l) % mod) * ((1 + no_greater_r) % mod) % mod);
			sum = (sum + (eleMinSubCount * a[i]) % mod) % mod;
		}
		return sum;
	}

	public int[] nextSmallerOnLeftIndexes(int[] arr, int n) {
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop(); // remove greater elements from left
			}
			if (stack.isEmpty()) {
				res[i] = -1;
			} else {
				res[i] = stack.peek();
			}
			stack.push(i);
		}
		return res;
	}

	public int[] nextSmallerOnRightIndexes(int[] arr, int n) {
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				res[stack.pop()] = i; // greater element present in stack so i is the ans
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			res[stack.pop()] = n; // n is the index for elements which are not having nser in the arr
		}
		return res;
	}
}
