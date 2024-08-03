package Lec18;

public class FlattenBinaryTree {
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

	static Node lastVisited;

	public static void flatten(Node root) {
		lastVisited = null;
		flattenTree(root);
	}

	private static void flattenTree(Node root) {
		if (root == null) {
			return;
		}
		flattenTree(root.right);
		flattenTree(root.left);

		// flatten the current node
		root.left = null;
		root.right = lastVisited;

		lastVisited = root;
	}

}
