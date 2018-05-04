// Given a string, find the length of the longest substring without repeating characters.

// Examples:

// Given "abcabcbb", the answer is "abc", which the length is 3.
// Given "bbbbb", the answer is "b", with the length of 1.
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Use array of length 256 to store ASCII chars. A more generic way is to use HashSet.

// Time complexity: O(N) Space complexity: O(1)

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int[] arr = new int[256];
		int res = 0;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			while (j < s.length() && arr[s.charAt(j)] ==0) {
				arr[s.charAt(j)] = 1;
				res = Math.max(res, j - i + 1);
				j++;
			}
			arr[s.charAt(i)] = 0;
		}
	}
}