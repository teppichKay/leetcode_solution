// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

// Time complexity: O(N) Space Complexity: O(1)

class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] freq = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
			freq[t.charAt(i) - 'a']--;
		}

		for (int count : freq) {
			if (count != 0) return false;
		}
		return true;
	}
}

// Solution 2: use Arrays.sort(arr1), Arrays.sort(arr2). This will cause
// O(NlogN) time complexity.

// Follow up: 
// What if the inputs contain unicode characters? How would you adapt your solution to such case?
// => Use a hash table instead of a fixed size counter. 
