package Lec15;

public class TreeTraversals {
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

	public static void preorderTraversal(Node root) {
		if (root == null) { // Base case
			return;
		}

		System.out.print(root.data + " "); // N is complete

		preorderTraversal(root.left); // LST Answer is provided by recursion

		preorderTraversal(root.right); // RST Answer is provided by recursion

	}

	public static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);

		System.out.print(root.data + " ");

		inorderTraversal(root.right);
	}

	public static void postorderTraversal(Node root) {
		if (root == null) {
			return;
		}

		postorderTraversal(root.left);

		postorderTraversal(root.right);

		System.out.print(root.data + " ");

	}
}
