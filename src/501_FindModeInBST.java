// Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.For example:
// Given BST [1,null,2,2],
//    1
//     \
//      2
//     /
//    2
// return [2].

// Note: If a tree has more than one mode, you can return them in any order.

// Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

// Solution 1: use extra space for HashMap, an intuitive way.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public int[] findMode(TreeNode root) {
		HashMap<Integer, Integer> map = new HashMap<>();
		traverse(root, map);
		// find the max value in the map
		int max_value = 0;
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if (entry.getValue() > max_value) 
				max_value = entry.getValue();
		}
		List<Integer> res = new ArrayList<>();
		// append all the modes in arraylist
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if (entry.getValue() == max_value)
				res.add(entry.getKey());
		}
		int[] ans = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
		}
		return ans;
	}
	private void traverse(TreeNode node, HashMap<Integer, Integer> map) {
		if (node == null) return;
		if (!map.containsKey(node.val)) 
			map.put(node.val, 1);
		else 
			map.put(node.val, map.get(node.val) + 1);
		traverse(node.left, map);
		traverse(node.right, map);
	}
}

// Solution 2: add consecutive values in the list while traversing the tree in order
class Solution {
	public int max = 0;
	public int local_max = 0;
	public Integer pre_node;
	List<Integer> list = new ArrayList<>();

	public int[] findMode(TreeNode root) {
		if (root == null) 
			return new int[0];
		traverse(root);
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private void traverse(TreeNode node) {
		if (node == null) 
			return;
		traverse(node.left);

		if (pre_node != null && node.val == pre_node) {
			local_max++;
		} else {
			local_max = 1;
		}

		if (local_max == max) {
			list.add(node.val);
		} else if (local_max > max) {
			list = new ArrayList<>();
			list.add(node.val);
			max = local_max;
		}
		pre_node = node.val;

		traverse(node.right);
	}
}







