// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]

// HashMap + Arrays.sort()
// Time complexity: N * K * logK

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			char[] charArr = s.toCharArray();
			Arrays.sort(charArr);
			String cur = new String(charArr);
			if (!map.containsKey(cur)) {
				map.put(cur, new ArrayList<String>());
			}
			map.get(cur).add(s);
		}

		for (Map.Entry<String, List<String>> entry: map.entrySet()) {
			res.add(entry.getValue());
		}

		return res;
	}
}