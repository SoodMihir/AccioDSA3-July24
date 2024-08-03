package Lec17;

import java.util.*;

public class VerticalOrderTraversal {
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	class Pair implements Comparable<Pair> {
		TreeNode node;
		int VL;
		int HL;

		Pair(TreeNode node, int vl, int hl) {
			this.node = node;
			this.VL = vl;
			this.HL = hl;
		}

		@Override
		public int compareTo(Pair other) {
			if(this.HL == other.HL) {
				// same row
				// choose one with smaller value
				return this.node.data - other.node.data;
			} else {
				// 2 Nodes on different Nodes
				// choose the one with smaller row first
				// Sort in asc
				return this.HL - other.HL; 
			}
		}
	}

	public List<List<Integer>> VerticalTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0, 0));

		HashMap<Integer, ArrayList<Pair>> map = new HashMap(); // VL -> Values

		int minVL = 0;
		int maxVL = 0;
		while (!queue.isEmpty()) {
			int size = queue.size(); // no of elements in a given level
			while (size-- > 0) {
				Pair pair = queue.remove();

				TreeNode node = pair.node;
				int vl = pair.VL;
				int hl = pair.HL;
				minVL = Math.min(minVL, vl);
				maxVL = Math.max(maxVL, vl);

				if (!map.containsKey(vl)) {
					map.put(vl, new ArrayList<>());
				}

				map.get(vl).add(pair);

				if (node.left != null) {
					queue.add(new Pair(node.left, vl - 1, hl + 1));
				}
				if (node.right != null) {
					queue.add(new Pair(node.right, vl + 1, hl + 1));
				}
			}
		}
		for (int c = minVL; c <= maxVL; c++) {
			ArrayList<Pair> currVLT = map.get(c);
			Collections.sort(currVLT); // sorting logic, present above
			
			for (Pair val : currVLT) {
				System.out.print(val.node.data + " ");
			}
			System.out.println();
		}
		return res;
	}
}
