class Solution {
	int[] parents;
	int[] ranks;

	public int[] findRedundantConnection(int[][] edges) {
		parents = new int[edges.length + 1];
		ranks = new int[egdes.length + 1];
		// default parent setting
		for (int i = 1; i < parents.length; ++i) {
			parents[i] = i;
		}

		for (int[] edge: edges) {
			if (!union(edge[0], edge[1])) return edge;
		}
		return null;
	}

	private boolean union(int x, int y) {
		int root_x = find(x);
		int root_y = find(y);
		// two nodes already have the same root, the edge could be the redundant edge
		if (root_x == root_y) return false;

		if (ranks[root_x] > ranks[root_y]) {
			// merge y to x
			parents[root_y] = root_x;
 		} else if (ranks[root_y] > ranks[root_x]) {
 			parents[root_x] = root_y;
 		} else {
 			parents[root_x] = root_y;
 			ranks[root_y] += 1;
 		}
 		return true;
	}

	private int find(int x) {
		// Compress the path during traversal
		if (x != parents[x]) 
			parents[x] = find(parents[x]);
		return parents[x];
	}

}