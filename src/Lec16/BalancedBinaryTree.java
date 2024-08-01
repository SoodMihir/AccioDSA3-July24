package Lec16;

public class BalancedBinaryTree {
	class Node {

		int data;
		Node left, right;
	}

	public static boolean isBalanced(Node root) {
		return checkBalanced(root).isBalanced;
	}

	// Object for storing 2 responses
	static class Pair {
		boolean isBalanced;
		int ht;

		Pair(boolean isBalanced, int ht) {
			this.isBalanced = isBalanced;
			this.ht = ht;
		}
	}

	// faith-> func will return a pair stating the ht of a tree along with checking
	// if the tree with the current node is balanced
	// TC -> O(n)
	private static Pair checkBalanced(Node root) {
		// base case:
		if (root == null) {
			return new Pair(true, 0);
		}

		Pair LST = checkBalanced(root.left);
		Pair RST = checkBalanced(root.right);

		int lht = LST.ht;
		int rht = RST.ht;

		// checks if current node is balanced or not
		boolean isBalanced = (Math.abs(rht - lht) <= 1) && LST.isBalanced && RST.isBalanced;
		int ht = Math.max(lht, rht) + 1;

		return new Pair(isBalanced, ht);
	}
}
