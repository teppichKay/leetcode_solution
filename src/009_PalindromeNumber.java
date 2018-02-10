// Ps: negative nums are all non-palindrome?
// Time complexity : O(n)  Space: O(1)

class Solution {
  public boolean isPalindrome(int x) {
    String str = Integer.toString(x);
    int start = 0, end = str.length()-1;
    while (start < end) {
      if (str.charAt(start) == str.charAt(end)) {
        start++;
        end--;
      } else {
        return false;
      }
    }
    return true;
  }
}
