package Lec6;

import java.util.ArrayList;

public class HashSet {
	class Node {
		int key;
		boolean val;
		Node next;

		Node(int key, boolean val) {
			this.key = key;
			this.val = val;
		}
	}

	private int size; // n
	private ArrayList<Node> buckets;
	private double loadFactor = 2.0;

	HashSet() {
		this(4);
	}

	HashSet(int cap) {
		buckets = new ArrayList<>();
		size = 0;
		for (int i = 0; i < cap; i++) {
			buckets.add(null);
		}
	}
	
	public int size() {
		return this.size;
	}

	public void add(int key) {
		int bucNum = hashfun(key);
		Node node = buckets.get(bucNum);
		if (node == null) {
			// the bucket is empty -> Insert the first node
			Node nn = new Node(key, true);
			buckets.set(bucNum, nn);
			this.size++;
		} else {
			// update existing
			while (node != null) {
				if (node.key == key) {
					// key already exist in the bucket
					// update the value
					node.val = true;
					return;
				}
				node = node.next;
			}

			// the value was not already present in the map
			Node nn = new Node(key, true);
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
	
	public void remove(int key) {
		int bucNum = hashfun(key);
		Node node = buckets.get(bucNum);
		Node prev = null;
		while(node != null) {
			if(node.key == key) {
				// remove the node
				// Head node
				if(node == buckets.get(bucNum)) {
					buckets.set(bucNum, node.next);
				} else {
					// prev is present
					prev.next = node.next;
				}
				size--;
				return;
			}
			prev = node;
			node = node.next;
		}
	}

	public boolean contains(int key) {
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
				this.add(node.key); 
				node = node.next;
			}
		}
	}
}
