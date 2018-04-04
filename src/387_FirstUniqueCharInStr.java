// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.

// Time complexity: O(n) 
// Pass the whole string twice.

class Solution {
	public int firstUniqChar(String s) {
		char[] charArr = s.toCharArray();
		int[] freq = new int[26];
		for (int i = 0; i < charArr.length; i++) {
			int index = charArr[i] - 'a';
			freq[index]++;
		}

		for (int i = 0; i < charArr.length; i++) {
			if (freq[charArr[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}