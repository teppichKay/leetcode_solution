// Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

// The root is the maximum number in the array.
// The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
// The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.


public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) {
		val = x;
	}
}

class Solution {
	public TreeNode constructeMaximumBinaryTree(int[] nums) {
		if (nums.length == 0 || nums == null) return null;
		int cur = findMax(nums);
		TreeNode root = new TreeNode(nums[cur]);
		int[] left = Arrays.copyOfRange(nums, 0, cur);
		int[] right = Arrays.copyOfRange(nums, cur + 1, nums.length);
		root.left = constructeMaximumBinaryTree(left);
		root.right = constructeMaximumBinaryTree(right);
		return root;
	}

	private int findMax(int[] nums) {
		int maxId = 0;
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
				maxId = i;
			}
		}
		return maxId;
	}
}