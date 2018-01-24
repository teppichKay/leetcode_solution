class Solution {
  // Method 1: 2D array
  // Time: O(m*n), space: O(m*n)
  public int uniquePaths(int m, int n) {
    if (n < 1 || m < 1) return -1;
    int[][] board = new int[m][n];
    board[0] = 1;
    // set 1 to the first row and the first column
    for (int i = 0; i < m; i++) {
      board[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
      board[0][j] = 1;
    }
    for (int i = 1; i < m; i++ ) {
      for (int j = 1; j < n; j++) {
        board[i][j] = board[i-1][j] + board[i][j-1];
      }
    }
    return board[m-1][n-1];
  }
  
  // Method 2: 1D array
  // Time: O(m*n), space: O(n)
  public int uniquePaths2(int m, int n) {
    if (n < 1 || m < 1) return -1;
    int[] board = new int[n];
    // init first item of the row
    board[0] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 1; j < n; j++) {
        board[j] = board[j] + board[j-1];
      }
    }
    return board[n-1];
  }
}