// In this problem, a tree is an undirected graph that is connected and has no cycles.
// Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

// Input: [[1,2], [1,3], [2,3]]
// Output: [2,3]
// Explanation: The given undirected graph will be like this:
//   1
//  / \
// 2 - 3

// Union Find

class Solution {
	private int[] parents;
	private int[] ranks;

	public int[] findRedundantConnection(int[][] edges) {
		parents = new int[edges.length + 1];
		ranks = new int[edges.length + 1];
		for (int i = 1; i < parents.length; ++i) {
			parents[i] = i;
		};
		for (int[] edge: edges) {
			if (!union(edge[0], edge[1])) return edge;
		}
		return null;
	}

	private int find(int x) {
		// Compress the path during traversal
		if (x != parents[x]) 
			parents[x] = find(parents[x]);
		return parents[x];
	}

	// Merge sets that contains u and v
	private boolean union(int u, int v) {
		int ru = find(u);
		int rv = find(v);
		// two nodes already have the same root, the edge could be the redundant edge
		if (ru == rv) return false;
		// merge tree with low rank into tree with high rank
		if (ranks[rv] > ranks[ru]) 
			parents[ru] = rv;
		else if (ranks[rv] < ranks[ru])
			parents[rv] = ru;
		else {
			parents[rv] = ru;
			ranks[ru] += 1;
		}
		return true;
	}
}