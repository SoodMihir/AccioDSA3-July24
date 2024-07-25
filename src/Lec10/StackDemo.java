package Lec10;

import java.util.Stack;

public class StackDemo {

	class Pair{
		int k;
		int v;
		String name;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(5);
		stack.push(10);
		System.out.println(stack.peek());
		stack.push(2);
		stack.push(1);
		System.out.println(stack);
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		stack.pop();
		stack.pop();
		System.out.println(stack);
	}

}
