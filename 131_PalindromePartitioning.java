// For example, given s = "aab",
// Return
//
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]
// backtracking + isPalindrome()
// Time complexity: O(2^n) Space: O(n)

class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    helper(res, list, s, 0);
    return res;
  }

  private void helper(List<List<String>> res, List<String> list, String s, int start) {
    if (start == s.length()) {
      res.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i < s.length(); i++ ) {
      if (isPalindrome(s, start, i)) {
        list.add(s.substring(start, i + 1));
        helper(res, list, s, i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String s, int start, int pos) {
    while (start < pos && s.charAt(start) == s.charAt(pos)) {
      start = start + 1;
      pos = pos - 1;
    }
    return start >= pos;
  }
}
