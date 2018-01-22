// Time complexity: O(logn) Space complexity: O(1)
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) return false;

    final int m = matrix.length;
    final int n = matrix[0].length;
    int len = m * n;
    int first = 0;
    int last = len - 1;
    // binary search for the matrix
    while (first <= last) {
      int mid = (last - first) / 2 + first;
      int value = matrix[mid / n][mid % n];
      if (value == target) return true;
      else if (value < target) first = mid + 1;
      else last = mid - 1;
    }
    return false;
  }
}
