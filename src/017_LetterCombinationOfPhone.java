// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


class Solution {
  final String[] letters = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits.length() == 0) return res;
    helper(digits, res, "", 0);
    return res;
  }

  public void helper(String digits, List<String> res, String cur, int index) {
    if (cur.length() == digits.length()) {
      res.add(cur);
      return;
    }

    String str = letters[digits.charAt(index) - '0'];
    for (char c : str.toCharArray()) {
      helper(digits, res, cur + c, index + 1);
    }
  }
}
