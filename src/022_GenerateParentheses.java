// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
// For example, given n = 3, a solution set is:
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

// Backtracking

class Solution {
  public List<String> generateParenthesis(int n) {
    if (n == 0) return null;
    List<String> res = new ArrayList<>();
    helper(res, "", 0, 0, n);
    return res;
  }

  public void helper(List<String> res, String str, int left, int right, int n) {
    if (str.length() == n * 2) {
      res.add(str);
    }

    if (left < n) helper(res, str + "(", left + 1, right, n);
    if (left > right) helper(res, str + ")", left, right + 1, n);
  }
}
