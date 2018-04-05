// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// 11110
// 11010
// 11000
// 00000
// Answer: 1

// Solution: find a '1', set all the adjancent '1' to '0' as visited.
// accumulate the total count, then keep traverse.

// Time complexity: O(m * n)

class Solution {
	private int m;
	private int n;

	public int numIslands(char[][] grid) {
		m = grid.length;
		if (grid == null || m == 0) return 0;
		n = grid[0].length;
		if (grid[0].length == 0) return 0;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					helper(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public void helper(char[][] grid, int i, int j) {
		if (i < 0 || i >= m || j < 0 || j >= n 
			|| grid[i][j] == '0') 
			return;
		grid[i][j] = '0';
		helper(grid, i-1, j);
		helper(grid, i+1, j);
		helper(grid, i, j-1);
		helper(grid, i, j+1);
	}
}