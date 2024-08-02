package Lec17;

import java.util.ArrayList;
import java.util.Collections;

public class PathtoGivenNode {
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

	public ArrayList<Integer> solve(Node root, int b) {
		ArrayList<Integer> path = pathToNode(root, b);
		Collections.reverse(path);
		return path;
	}

	public ArrayList<Integer> pathToNode(Node root, int b) {
		if (root == null) {
			return null;
		}

		if (root.data == b) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(root.data);
			return ans;
		}

		ArrayList<Integer> LST = pathToNode(root.left, b);
		if (LST != null) {
			// Node found in LST
			LST.add(root.data);
			return LST;
		}

		ArrayList<Integer> RST = pathToNode(root.right, b);
		if (RST != null) {
			// Node found in RST
			RST.add(root.data);
			return RST;
		}

		return null;
	}
}
