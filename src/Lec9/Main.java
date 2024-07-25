package Lec9;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cap = sc.nextInt(), q = sc.nextInt();
		String[] queries = new String[q];
		for (int i = 0; i < q; i++) {
			String s = sc.next();
			if (s.equals("GET"))
				s += " " + sc.nextInt();
			else
				s += " " + sc.nextInt() + " " + sc.nextInt();
			queries[i] = s;
		}
		sc.close();
		LRUCache lruCache = new LRUCache(cap);
		for (String s : queries) {
			String[] arr = s.split(" ");
			if (arr.length == 3)
				lruCache.set(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			else
				System.out.println(lruCache.get(Integer.parseInt(arr[1])));
		}
	}
}

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	Node() {
		this.key = -1;
		this.value = -1;
		this.prev = null;
		this.next = null;
	}

	Node(int k, int v) {
		this.key = k;
		this.value = v;
		this.prev = null;
		this.next = null;
	}
}

class LRUCache {
	Node dh; // dummyHead
	Node dt; // dummyTail
	HashMap<Integer, Node> map; // map for fetching the key and corresponding data in O(1)
	int capacity; // max capacity of the cache

	// your code here
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.dh = new Node();
		this.dt = new Node();
		this.dh.next = this.dt;
		this.dt.prev = this.dh;

	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node node = map.get(key); // we opened the app
		moveToHead(node);
		return node.value;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			// app is already present in the cache
			Node node = map.get(key); // open the app
			node.value = value;
			moveToHead(node);
		} else {
			// we are adding a new app in the cache
			Node nn = new Node(key, value);
			if (map.size() == this.capacity) { // the cache is full
				Node removed_node = dt.prev;
				map.remove(removed_node.key); // remove node from cache
				removeLast();
			}
			map.put(key, nn);
			addToHead(nn);
		}
	}

	private void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;

		nextNode.prev = prevNode;
		prevNode.next = nextNode;

		node.prev = null;
		node.next = null;
	}

	private void removeLast() {
		Node removedNode = dt.prev;
		Node prev = removedNode.prev;
		
		prev.next = dt;
		dt.prev = prev;
		
		removedNode.next = null;
		removedNode.prev = null;
	}

	private void moveToHead(Node node) {
		removeNode(node);
		addToHead(node);
	}
	
	private void addToHead(Node node) {
		
		Node prevHead = dh.next;
		prevHead.prev = node;
		node.next = prevHead;

		dh.next = node;
		node.prev = dh;
	}
}