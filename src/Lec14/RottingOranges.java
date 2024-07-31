package Lec14;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int orangesRotting(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int time = 0;
		int countFresh = 0;
		Queue<Pair> queue = new LinkedList<>();
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 1) {
					countFresh++;
				} else if (grid[r][c] == 2) {
					// rotten orange
					queue.add(new Pair(r, c));
				}
			}
		}
		if (countFresh == 0) {
			return 0;
		}
		while (queue.size() != 0) {
			int rottenOrangesInCurrentLevel = queue.size();
			while (rottenOrangesInCurrentLevel-- > 0) {
				Pair rp = queue.remove();
				int r = rp.x;
				int c = rp.y;

				// up
				if (r - 1 >= 0 && grid[r - 1][c] == 1) {
					grid[r - 1][c] = 2;
					queue.add(new Pair(r - 1, c));
					countFresh--;
				}

				// down
				if (r + 1 < m && grid[r + 1][c] == 1) {
					grid[r + 1][c] = 2;
					queue.add(new Pair(r + 1, c));
					countFresh--;
				}

				// left
				if (c - 1 >= 0 && grid[r][c - 1] == 1) {
					grid[r][c - 1] = 2;
					queue.add(new Pair(r, c - 1));
					countFresh--;
				}

				// right
				if (c + 1 < n && grid[r][c + 1] == 1) {
					grid[r][c + 1] = 2;
					queue.add(new Pair(r, c + 1));
					countFresh--;
				}
			}
			time++;
		}
		if (countFresh != 0) {
			// some fresh orange remains
			return -1;
		}
		return time - 1;
	}
}
