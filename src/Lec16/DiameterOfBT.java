package Lec16;

public class DiameterOfBT {
	class Node {

		int data;
		Node left, right;
	}

	static class Pair {
		int ht;
		int maximumDiameter;

		Pair(int h, int d) {
			this.ht = h;
			this.maximumDiameter = d;
		}
	}

	public static int diameter2(Node root) {
		return optimisedDiameter(root).maximumDiameter;
	}

	private static Pair optimisedDiameter(Node root) {
		if (root == null) {
			// diameter is 0 for a tree which does not exist
			return new Pair(0, 0);
		}

		// diameter present in LST
		Pair LST = optimisedDiameter(root.left);

		// diameter present in RST
		Pair RST = optimisedDiameter(root.right);

		// diameter is passing through root
		int diameterWithRoot = LST.ht + RST.ht + 1;

		// overall diameter of the tree is Max of above 3 values
		int bestDiameter = Math.max(diameterWithRoot, Math.max(LST.maximumDiameter, RST.maximumDiameter));
		
		int ht = Math.max(LST.ht, RST.ht)+1;
		return new Pair(ht, bestDiameter);
	}

	// TC -> O(N^2)
	public static int diameter(Node root) {
		if (root == null) {
			// diameter is 0 for a tree which does not exist
			return 0;
		}

		// diameter is passing through root
		int lht = heightOfTree(root.left); // O(N)
		int rht = heightOfTree(root.right);// O(N)

		int diameterWithRoot = lht + rht + 1;

		// diameter present in LST
		int diameterLST = diameter(root.left);

		// diameter present in RST
		int diameterRST = diameter(root.right);

		// overall diameter of the tree is Max of above 3 values
		return Math.max(diameterWithRoot, Math.max(diameterLST, diameterRST));
	}

	// TC -> O(N)
	public static int heightOfTree(Node root) { // -> On the basis of nodes b/w root and the deepest level
		if (root == null) {
			return 0;
		}
		int lht = heightOfTree(root.left);
		int rht = heightOfTree(root.right);
		return Math.max(lht, rht) + 1;
	}
}
