// Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
//
// Example 1:
// Input:
// A: [1,2,3,2,1]
// B: [3,2,1,4,7]
// Output: 3
// Explanation:
// The repeated subarray with maximum length is [3, 2, 1].

// Dynamic programming: O(mn) O(mn)
class Solution {
  public int findLength(int[] A, int[] B) {
    int[][] dp = new int[A.length + 1][B.length + 1];
    int maxLen = 0;
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[1][0] = 0;
    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        if (A[i - 1] != B[j - 1]) dp[i][j] = 0;
        else {
            dp[i][j] = 1 + dp[i - 1][j - 1];
            maxLen = Math.max(maxLen, dp[i][j]);
        }
      }
    }
    return maxLen;
  }
}
