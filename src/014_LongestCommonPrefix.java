// Write a function to find the longest common prefix string amongst an array of strings.

// Time complexity : O(m1+m2+m3+...) Space: O(1)

class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String res = strs[0];
    for (int i = 0; i < strs.length; i++) {
      res = twoStringPrefix(res, strs[i]);
    }
    return res;
  }

  public String twoStringPrefix(String l1, String l2) {
    if (l1.length() == 0 || l2.length() == 0) return "";
    int loc = 0;
    for (int i = 0; i < Math.min(l1.length(), l2.length()); i++) {
      if (l1.charAt(i) != l2.charAt(i)) {
        loc = i-1;
        break;
      }
      if (i == Math.min(l1.length(), l2.length())-1) {
        loc = i;
        break;
      }
    }
    return l1.substring(0, loc+1);
}
