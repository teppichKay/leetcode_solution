// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

// Time Complexity: < O(row * col * 4 ^ word.length)

class Solution {
	public boolean exist(char[][] board, String word) {
		int r = board.length;
		int c = board[0].length;
		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (dfs(board, word, 0, i, j, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, String word, int start, int i, int j, boolean[][] visited) {
		// conditions
		if ( start == word.length()) return true;
		if ( i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		if ( visited[i][j]) return false;
		if (word.charAt(start) != board[i][j]) return false;
		visited[i][j] = true;

		boolean cur = dfs(board, word, start+1, i+1, j, visited) || dfs(board, word, start+1, i, j+1, visited) 
            || dfs(board, word, start+1, i-1, j, visited) || dfs(board, word, start+1, i, j-1, visited);
        // important! set visited back to false
        visited[i][j] = false;
        return cur;    
	}
}
