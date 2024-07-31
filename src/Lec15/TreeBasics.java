package Lec15;

import Lec15.TreeTraversals.Node;

public class TreeBasics {
	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	// Post Order
	public int sizeOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		int LST = sizeOfTree(root.left);
		int RST = sizeOfTree(root.right);
		return LST + RST + 1;
	}

	public int sumOfTree(Node root) {
	}

	// Post Order -> L and R ans are needed to calculate the ans for curr node
	public int maxOfTree(Node root) {
		if (root == null) {
			// return the smallest possible value
			return Integer.MIN_VALUE;
		}

		int lMax = maxOfTree(root.left);
		int rMax = maxOfTree(root.right);

		// Processing the curr
		int curr = root.data;
		return Math.max(curr, Math.max(lMax, rMax));
	}

	public int heightOfTree(Node root) {
	}
}
