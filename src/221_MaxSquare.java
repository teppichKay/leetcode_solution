// dynamic programming
// dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1, if matrix[i][j] != 0
//
// Time complexity: O(m*n) Space: O(m*n)

class Solution {
  public int maximumSquare(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int max = 0;

    for (int i = 0; i < m; i++) {
      dp[i][0] = matrix[i][0] - '0';
      max = Math.max(dp[i][0], max);
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = matrix[0][i] - '0';
      max = Math.max(dp[0][i], max);
    }

    // iterate nums in the matrix except the 1st row and column.
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // if matrix[i][j] == 0, dp[i][j] = 0
        // else, check previous three locations, and set a value to the current location.
        dp[i][j] = matrix[i][j] == '1' ? Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1 : 0;
        max = Math.max(dp[i][j], max);
      }
    }
    return max * max;
  }
}
