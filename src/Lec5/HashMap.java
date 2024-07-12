package Lec5;

import java.util.ArrayList;

public class HashMap {
	class Node {
		int key;
		int val;
		Node next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	private int size; // n
	private ArrayList<Node> buckets;
	private double loadFactor = 2.0;

	HashMap() {
		this(4);
	}

	HashMap(int cap) {
		buckets = new ArrayList<>();
		size = 0;
		for (int i = 0; i < cap; i++) {
			buckets.add(null);
		}
	}

	public int get(int key) {
		int bucNum = hashfun(key);
		Node node = buckets.get(bucNum); // gives the head node of the ll
		while (node != null) {
			if (node.key == key) {
				return node.val;
			}
			node = node.next;
		}
		return -1; // data is not found
	}

	public int size() {
		return this.size;
	}

	public void put(int key, int val) {
		int bucNum = hashfun(key);
		Node node = buckets.get(bucNum);
		if (node == null) {
			// the bucket is empty -> Insert the first node
			Node nn = new Node(key, val);
			buckets.set(bucNum, nn);
			this.size++;
		} else {
			// update existing
			while (node != null) {
				if (node.key == key) {
					// key already exist in the bucket
					// update the value
					node.val = val;
					return;
				}
				node = node.next;
			}

			// the value was not already present in the map
			Node nn = new Node(key, val);
			Node prevHead = buckets.get(bucNum);
			nn.next = prevHead;
			buckets.set(bucNum, nn);
			this.size++;
		}

		double calculatedLoadFactor = (size * 1.0 / buckets.size());
		if (loadFactor < calculatedLoadFactor) {
			// load factor has changed: Double the buckets to improve
			// the avg perfomance
			rehash();
		}
	}

	private void rehash() {
		ArrayList<Node> newBuckets = new ArrayList<>();
		for (int i = 0; i < buckets.size() * 2; i++) {
			newBuckets.add(null);
		}
		ArrayList<Node> old = buckets;
		
		// reinitialise the buckets
		buckets = newBuckets;
		size = 0;

		for (int i = 0; i < old.size(); i++) {
			Node node = old.get(i);
			while (node != null) {
				// this needs to be done as the hashfunc changes 
				// when buckets size changes
				this.put(node.key, node.val); 
				node = node.next;
			}
		}
	}

	public boolean containsKey(int key) {
		int bucNum = hashfun(key);
		Node node = buckets.get(bucNum);
		while (node != null) {
			if (node.key == key) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	// returns the bucketNum for the given key
	private int hashfun(int key) {
		int num = key % buckets.size();
		if (num < 0) {
			num += buckets.size();
		}
		return num;
	}
}
