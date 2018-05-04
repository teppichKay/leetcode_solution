// Each letter in the magazine string can only be used once in your ransom note.
// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true

// Time complexity: O(n) Space: O(1)

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    // create a magazine array
    int[] arr = new int[26];
    for (int i = 0; i < magazine.length(); i++) {
      arr[magazine.charAt(i) - 'a']++;
    }

    for (int i =0; i < ransomNote.length(); i++) {
      --arr[ransomNote.charAt(i) - 'a'];
      if (arr[ransomNote.charAt(i) - 'a'] < 0) return false;
    }

    return true;
  }
}
