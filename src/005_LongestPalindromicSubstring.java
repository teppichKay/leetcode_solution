// Solution 1 : Time Limit Exceeded
class Solution {
    public String longestPalindrome(String s) {
        int m, n;
        String max = "";
        if (s.length() == 1) return s;
        for (m = 0; m < s.length(); m++) {
            for (n = m; n < s.length(); n++) {
                if (s.charAt(m) == s.charAt(n)) {
                    if (!isPalindrome(s.substring(m, n+1))) continue;
                    if (max.length() < (n-m+1)) {
                       max = s.substring(m, n+1);
                    }
                }
            }
        }
        return max;
    }

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length()-1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}

// Solution 2 : dynamic programming
// Time: O(n^2)  Space: O(n^2)
if (s == null || s.length() == 0) return s;
String res = "";
boolean[][] dp = new boolean[s.length()][s.length()];
int max = 0;
for (int j =0; j < s.length(); j++) {
  for (int i = 0; i <= j; i++) {
    // if j - i <= 2, stop Recursion
    dp[i][j] = s.charAt(i) == s.charAt(j) && ((j-i) <= 2 || dp[i+1][j-1]);
    if (dp[i][j]) {
      if (j-i+1 > max) {
        max = j-i+1;
        res = s.substring(i, j+1);
      }
    }
  }
}
return res;
