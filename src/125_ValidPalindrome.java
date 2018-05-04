// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Time complexity: O(n) Space: O(1)

// regex

class Solution {
  public boolean isPalindrome(String s) {
    if (s.length() == 0) return true;
    s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len-1-i)) return false;
    }
    return true;
  }
}


// Method 2:
//boolean Character.isLetterOrDigit(s.charAt(i))
