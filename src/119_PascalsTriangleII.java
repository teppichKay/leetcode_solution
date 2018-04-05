// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?

// use one list, keep updating this list until reaching the level of k.
// updating elements of one level should be conducted from right to left.

// Time complexity: O(k)

class Solution {
	public List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			list.add(0);
		}
		list.set(0, 1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = rowIndex; j >= 1; j--) {
				list.set(j, list.get(j) + list.get(j-1));
			}
		}
		return list;
	}
}