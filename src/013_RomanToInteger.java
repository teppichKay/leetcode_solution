// Given a roman numeral, convert it to an integer.
//
// Input is guaranteed to be within the range from 1 to 3999.
//
// Time complexity: O(n) Space: O(1)

// Solution 1: iterate from the beginning of s
class Solution {
  public int romanToInt(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int cur = 0;
    int total = 0;
    for (int i = 0; i < s.length(); i++) {
        int next = cur + 1;
        if (cur == s.length()-1) {
            total += map.get(s.charAt(cur));
            break;
        }
        if (next < s.length()) {
            if (map.get(s.charAt(cur)) >= map.get(s.charAt(next))) {
                total += map.get(s.charAt(cur));
                cur++;
            } else {
                total += map.get(s.charAt(next)) - map.get(s.charAt(cur));
                cur += 2;
            }
        }
    }
    return total;
  }
}

// Solution 2 : iterate in reverse, which is more elegant.
int length = s.length();
for (int i = length-2; i >= 0; i--) {
  if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
      result += m.get(s.charAt(i));
  } else {
      result -= m.get(s.charAt(i));
  }
}
return result;
