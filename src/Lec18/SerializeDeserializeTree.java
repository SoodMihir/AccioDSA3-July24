package Lec18;

import java.util.Scanner;
import java.util.Stack;

public class SerializeDeserializeTree {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		preOrderTraversal(root, sb);
		return sb.toString();
	}

	private static void preOrderTraversal(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#").append(" ");
		} else {
			sb.append(root.val).append(" ");
			preOrderTraversal(root.left, sb);
			preOrderTraversal(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String str) {
		String[] values = str.split(" ");
		int[] index = { 0 };
		return buildTree(values, index);
	}

	private static TreeNode buildTree(String[] values, int[] index) {
		if (index[0] >= values.length || values[index[0]].equals("#")) {
			index[0]++;
			return null;
		}

		TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
		index[0]++;
		node.left = buildTree(values, index);
		node.right = buildTree(values, index);

		return node;
	}

	// input_section=================================================

	public static void display(TreeNode node) {
		if (node == null)
			return;

		StringBuilder sb = new StringBuilder();
		sb.append((node.left != null ? node.left.val : "."));
		sb.append(" -> " + node.val + " <- ");
		sb.append((node.right != null ? node.right.val : "."));

		System.out.println(sb.toString());

		display(node.left);
		display(node.right);

	}

	public static TreeNode createTree(int[] arr, int[] IDX) {
		if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
			IDX[0]++;
			return null;
		}
		TreeNode node = new TreeNode(arr[IDX[0]++]);
		node.left = createTree(arr, IDX);
		node.right = createTree(arr, IDX);

		return node;
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int[] IDX = new int[1];
		TreeNode root = createTree(arr, IDX);

		String s = serialize(root);
		display(deserialize(s));
	}

	public static void main(String[] args) {
		solve();
	}
}
