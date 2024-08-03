package Lec18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BurningBT {
	class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static int timeToBurnTree(Node root, int start) {
		if (root == null) {
			return 0;
		}
		Node src = findNode(root, start);
		HashMap<Node, Node> parentMap = new HashMap<>();
		updateParent(root, parentMap);

		HashSet<Node> visited = new HashSet<>(); // will store which nodes have been processed

		Queue<Node> queue = new LinkedList<>();
		queue.add(src);
		visited.add(src);

		int time = 0;

		while (queue.size() > 0) {
			int size = queue.size();
			while (size-- > 0) {
				Node node = queue.remove();

				// Add the adjacents
				Node left = node.left;
				if (left != null && !visited.contains(left)) {
					queue.add(left);
					visited.add(left);
				}

				Node right = node.right;
				if (right != null && !visited.contains(right)) {
					queue.add(right);
					visited.add(right);
				}

				Node parent = parentMap.get(node);
				if (parent != null && !visited.contains(parent)) {
					queue.add(parent);
					visited.add(parent);
				}
			}
			time++;
		}

		return time - 1;
	}

	private static void updateParent(Node root, HashMap<Node, Node> parentMap) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			parentMap.put(root.left, root);
		}
		if (root.right != null) {
			parentMap.put(root.right, root);
		}
		updateParent(root.left, parentMap);
		updateParent(root.right, parentMap);
	}

	private static Node findNode(Node root, int b) {
		if (root == null) {
			return null;
		}

		if (root.data == b) {
			return root;
		}

		Node LST = findNode(root.left, b);
		if (LST != null) {
			return LST;
		}

		Node RST = findNode(root.right, b);
		if (RST != null) {
			return RST;
		}

		return null;
	}
}
