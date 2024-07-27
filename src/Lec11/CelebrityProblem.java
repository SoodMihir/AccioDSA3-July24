package Lec11;

import java.util.Stack;

public class CelebrityProblem {
	int findCelebrity(int M[][], int n) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.push(i);
		}
		while (stack.size() > 1) {
			int p1 = stack.pop();
			int p2 = stack.pop();
			if (M[p1][p2] == 1) {
				// p1 know p2 -> p1 is eliminated
				stack.push(p2);
			} else {
				// p1 !-> p2 -> p2 is eliminated as p1 doesnt know p2
				stack.push(p1);
			}
		}
		int celebrity = stack.pop();
		// check is everyone knows this p
		for (int r = 0; r < n; r++) {
			if (r != celebrity && M[r][celebrity] != 1) {
				// someone doesnt know
				return -1;
			}
		}

		// check if this p knows someone
		for (int c = 0; c < n; c++) {
			if (M[celebrity][c] != 0) {
				// this person knows c
				return -1;
			}
		}
		return celebrity;
	}
}
