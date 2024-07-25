package Lec10;

import java.util.Stack;

public class ExtraBrackets {
	public boolean ExtraBrackets(String exp) {
		Stack<Character> stack = new Stack<>();
		for (char ch : exp.toCharArray()) {
			if (ch != ')') {
				// non closing bracket char can be directly added
				stack.push(ch);
			} else {
				// we are on )
				// if top element on stack is ( -> no expression in between
				if (stack.peek() == '(') {
					return true; // extra brackets found
				} else {
					// remove the extra expressions
					while (stack.peek() != '(') {
						stack.pop();
					}
					stack.pop(); // remove the extra (
				}
			}
		}
		return false;
	}
}
