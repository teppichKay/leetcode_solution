// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".

// Two pointers. Time complexity: O(n)

class Solution {
	public String reverseString(String s) {
		char[] charArr = s.toCharArray();
		int len = charArr.length;
		for (int i = 0; i < len; i++) {
			if (i < len - i - 1) {
				char temp = charArr[i];
				charArr[i] = charArr[len-i-1];
				charArr[len-i-1] = temp;
			}
		}
		return new String(charArr);
	}
}