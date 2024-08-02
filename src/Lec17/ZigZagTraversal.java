package Lec17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
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

	public static void binaryTreeZigZagTraversal(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		boolean isLevelEven = true;

		while (!queue.isEmpty()) {
			int size = queue.size(); // no of elements in a given level
			ArrayList<Integer> elementsInLevel = new ArrayList<>();
			while (size-- > 0) {
				Node node = queue.remove();
				elementsInLevel.add(node.data);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			if (isLevelEven) {
				// print from left to right
				for (int i = 0; i < elementsInLevel.size(); i++) {
					System.out.print(elementsInLevel.get(i) + " ");
				}
			} else {
				// print from right to left for odd levels
				for (int i = elementsInLevel.size() - 1; i >= 0; i--) {
					System.out.print(elementsInLevel.get(i) + " ");
				}
			}

			isLevelEven = !isLevelEven;
		}
	}
}
