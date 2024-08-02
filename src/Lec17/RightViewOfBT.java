package Lec17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBT {
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

	ArrayList<Integer> rightView(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}
		ArrayList<Integer> res = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size(); // no of elements in a given level
			int lastValueOfLevel = -1;
			while (size-- > 0) {
				Node node = queue.remove();
				lastValueOfLevel = node.data;

				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}

			// processed the entire level
			res.add(lastValueOfLevel);
		}
		return res;
	}
}
