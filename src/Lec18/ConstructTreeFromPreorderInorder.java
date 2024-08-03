package Lec18;

public class ConstructTreeFromPreorderInorder {
	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static Node buildTree(int inorder[], int preorder[], int n) {
		return constructTreePreIn(inorder, 0, n - 1, preorder, 0, n - 1);
	}

	private static Node constructTreePreIn(int[] inorder, int ins, int ine, int[] preorder, int prs, int pre) {
		if (prs > pre || ins > ine) {
			// invalid point
			return null;
		}
		
		Node root = new Node(preorder[prs]);
		int LSTCount = 0;
		int i = ins;
		for (; i <= ine; i++) {
			if (inorder[i] == preorder[prs]) {
				// root node
				break;
			} else {
				LSTCount++;
			}
		}

		root.left = constructTreePreIn(inorder, ins, i - 1, preorder, prs + 1, prs + LSTCount);
		root.right = constructTreePreIn(inorder, i + 1, ine, preorder, prs + LSTCount + 1, pre);

		return root;
	}

}
