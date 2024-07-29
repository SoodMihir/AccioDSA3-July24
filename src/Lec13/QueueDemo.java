package Lec13;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
//		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> queue = new LinkedList<>();

		// Enqueue - O(1)
		queue.add(10);
		queue.offer(20);
		queue.add(30);
		queue.offer(40);

		// size - O(1)
		System.out.println(queue.size());

		// return the first value - O(1)
		System.out.println(queue.peek());

		System.out.println("____________");

		// Dequeue - O(1)
		System.out.println(queue.remove());
		System.out.println(queue);

		System.out.println(queue.poll());
		System.out.println(queue);
	}

}
