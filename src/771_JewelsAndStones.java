// You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

// The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

// Example 1:

// Input: J = "aA", S = "aAAbbbb"
// Output: 3

// Note:

// S and J will consist of letters and have length at most 50.
// The characters in J are distinct.

// HashMap. Time complexity: O(n) Space complexity: O(n)

class Solution {
	public int numJewelsInStones(String J, String S) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			if (!map.containsKey(S.charAt(i))) {
				map.put(S.charAt(i), 1);
			} else {
				map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
			}
		}

		int res = 0;
		for (int j = 0; j < J.length(); j++) {
			if (map.containsKey(J.charAt(j))) 
				res += map.get(J.charAt(j));
		}

		return res;
	}
}