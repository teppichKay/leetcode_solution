// For example,
// Given "egg", "add", return true.
//
// Given "foo", "bar", return false.
//
// Given "paper", "title", return true.
//
// Time complexity: O(n) Space: O(n)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < t.length(); i++) {
            if(map1.get(t.charAt(i)) == null) map1.put(t.charAt(i), s.charAt(i));
            else if (map1.get(t.charAt(i)) != s.charAt(i)) return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(map2.get(s.charAt(i)) == null) map2.put(s.charAt(i), t.charAt(i));
            else if (map2.get(s.charAt(i)) != t.charAt(i)) return false;
        }
        return true;
    }
}
