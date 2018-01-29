// can also use char list: !charList.contains(t.charAt(i)) ...
// or hashmap: map.get(t.charAt(i))

// bit manipulation is used here, time complexity: O(n), space: O(1)

class Solution {
  public char findTheDifference(String s, String t) {
    // t is longer
    char res = t.charAt(t.length() - 1);
    for (int i = 0; i < s.length(); i++) {
      res ^= s.charAt(i);
      res ^= t.charAt(i);
    }
    return res;
  }
}
