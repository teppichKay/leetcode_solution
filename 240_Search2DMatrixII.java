// Time complexity: O(m+n) Space complexity: O(1)

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0 || matrix[0].length == 0) return false;
    // start from the top-right corner
    int m = 0;
    int n = matrix[0].length - 1;

    while (m < matrix.length && n >= 0) {
      if (matrix[m][n] == target) return true;
      else if (matrix[m][n] < target) ++m;
      else --n;
    }

    return false;
  }
}
