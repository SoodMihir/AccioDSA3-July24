package Lec16;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	class Node {
		int val;
		Node left, right;

		Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	public static void levelOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size(); // no of elements in a given level
			while (size-- > 0) {
				Node node = queue.remove();
				System.out.print(node.val + " ");
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			System.out.println();
		}

	}
}
