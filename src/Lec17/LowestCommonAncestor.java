package Lec17;

import java.util.ArrayList;
import java.util.Collections;

public class LowestCommonAncestor {

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

	public static Node findLCA(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		if (node.data == n1 || node.data == n2) {
			return node; // Current element is LCA
		}
		Node LST = findLCA(node.left, n1, n2);
		Node RST = findLCA(node.right, n1, n2);
		if (LST != null && RST != null) {
			// element was found in the LST and RST
			// current node is the LCA
			return node;
		} else if (LST != null) {
			// LCA might be in LST
			return LST;
		} else if (RST != null) {
			// LCA might be in RST
			return RST;
		} else {
			return null;
		}
	}

	public static Node findLCA2(Node node, int n1, int n2) {
		ArrayList<Node> rootToN1Path = solve(node, n1);
		ArrayList<Node> rootToN2Path = solve(node, n2);

		Node common = null;
		for (int i = 0; i < Math.min(rootToN1Path.size(), rootToN2Path.size()); i++) {
			if (rootToN1Path.get(i) == rootToN2Path.get(i)) {
				common = rootToN1Path.get(i);
			} else {
				break;
			}
		}
		return common;
	}

	public static ArrayList<Node> solve(Node root, int b) {
		ArrayList<Node> path = pathToNode(root, b);
		Collections.reverse(path);
		return path;
	}

	public static ArrayList<Node> pathToNode(Node root, int b) {
		if (root == null) {
			return null;
		}

		if (root.data == b) {
			ArrayList<Node> ans = new ArrayList<>();
			ans.add(root);
			return ans;
		}

		ArrayList<Node> LST = pathToNode(root.left, b);
		if (LST != null) {
			// Node found in LST
			LST.add(root);
			return LST;
		}

		ArrayList<Node> RST = pathToNode(root.right, b);
		if (RST != null) {
			// Node found in RST
			RST.add(root);
			return RST;
		}

		return null;
	}
}
