package Lec13;

import java.util.*;
 
class Node {
	int val;
	Node next;

	Node(int val) {
		this.val = val;
		this.next = null;
	}
}

class Queue {
	Node head;
	Node tail;
	int size;

	Queue() {
		head = null;
		tail = null;
		size = 0;
	}

	public void add(int value) {
		Node nn = new Node(value);

		// attach new node at the tail
		if (tail == null) {
			head = tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}

		size++;
	}

	public int remove() {
		if (head == null) {
			return -1;
		} else if (head == tail) {
			// only 1 element present in the LL
			int data = head.val;
			head = tail = null;
			size--;
			return data;
		} else {
			// more than 1 node present in the LL
			Node first = head;
			head = head.next;
			size--;
			return first.val;
		}
	}

	public int peek() {
		if (head == null) {
			return -1;
		} else {
			return head.val;
		}
	}

	public int getSize() {
		return this.size;
	}
}

public class QueueUsingLL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue q = new Queue();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int op = sc.nextInt();
			if (op == 1) {
				int x = sc.nextInt();
				q.add(x);
			} else if (op == 2) {
				System.out.println(q.remove());
			} else if (op == 3)
				System.out.println(q.peek());
			else if (op == 4)
				System.out.println(q.getSize());
		}
	}
}
