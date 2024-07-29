package Lec13;

import java.util.*;

class StackQueue {

	Stack<Integer> main;
	Stack<Integer> aux;

	StackQueue() {
		main = new Stack<>();
		aux = new Stack<>();
	}

	void Push(int a) { // Enqueue- O(1)
		main.push(a);
	}

	int Pop() { // Dequeue - O(N)
		if (main.size() == 0) {
			return -1;
		}

		// shift all the elements to aux stack
		while (main.size() > 1) {
			aux.push(main.pop());
		}
		// remove the 1 element
		int data = main.pop();

		// shift all elements back to main stack
		while (aux.size() > 0) {
			main.push(aux.pop());
		}
		return data;
	}
}

public class ImplementQueueUsingStackEnQueueO1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StackQueue s = new StackQueue();
		int q = scanner.nextInt();

		while (q-- > 0) {
			int queryType = scanner.nextInt();
			if (queryType == 1) {
				int a = scanner.nextInt();
				s.Push(a);
			} else if (queryType == 2) {
				System.out.print(s.Pop() + " ");
			}
		}
	}
}
