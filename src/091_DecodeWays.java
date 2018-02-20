// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// Dynamic programming, this quiz is similar to climbing stairs, but with more edge cases.
// dp[i] = dp[i-1] + dp[i-2]
// i + 1 stairs for i length string.
// Time complexity: O(n) Space: O(n)

class Solution {
  public int numDecodings(String s) {
    if (s.length() == 0) return 0;
    int[] dp = new int[s.length()+1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i < s.length(); i++) {
      if (s.charAt(i-1) != '0') {
        dp[i] += dp[i-1];
      }
      int two = Integer.valueOf(s.substring(i-2, i));
      if (two >= 10 && two <= 26) {
        // numbers like 05 are already added.
        dp[i] += dp[i-2];
      }
    }
    return dp[s.length()];
  }
}
