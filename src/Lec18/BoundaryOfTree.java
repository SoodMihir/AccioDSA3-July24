package Lec18;

public class BoundaryOfTree {
	static class Node {
		int data;
		Node left, right;
	}

	public static void printBoundary(Node root) {
		if (root == null) {
			return;
		}
		// root node
		System.out.print(root.data + " ");

		// print left boundary
		printLeftBoundary(root.left);

		// print leaf nodes -> If root is not leaf node
		if (root.left != null || root.right != null) {
			printLeafNode(root);
		}

		// print right boundary
		printRightBoundary(root.right);

	}

	private static void printLeftBoundary(Node node) {
		// return if at invalid node or a leaf node
		if (node == null || (node.left == null && node.right == null)) {
			return;
		}

		System.out.print(node.data + " ");

		if (node.left != null) {
			// left child will be the left boundary
			printLeftBoundary(node.left);
		} else {
			// right child will be the left boundary
			printLeftBoundary(node.right);
		}
	}

	private static void printLeafNode(Node node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
			return;
		}

		printLeafNode(node.left);
		printLeafNode(node.right);
	}

	private static void printRightBoundary(Node node) {
		// return if at invalid node or a leaf node
		if (node == null || (node.left == null && node.right == null)) {
			return;
		}

		if (node.right != null) {
			// right child will be the right boundary
			printRightBoundary(node.right);
		} else {
			// left child will be the right boundary
			printRightBoundary(node.left);
		}

		System.out.print(node.data + " ");
	}
}
