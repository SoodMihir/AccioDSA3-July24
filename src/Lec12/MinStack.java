package Lec12;

import java.util.Stack;

public class MinStack {
	class Pair {
		int val;
		int minVal;

		Pair(int v, int mv) {
			this.val = v;
			this.minVal = mv;
		}
	}

	Stack<Pair> s;

	MinStack() {
		s = new Stack<Pair>();
	}

	void push(int x) {
		int minVal = s.isEmpty() ? x : Math.min(x, s.peek().minVal);
		Pair np = new Pair(x, minVal);
		s.push(np);
	}

	int pop() {
		if (s.isEmpty()) {
			return -1;
		}
		return s.pop().val;
	}

	int getMin() {
		if (s.isEmpty()) {
			return -1;
		}
		return s.peek().minVal;
	}
}
