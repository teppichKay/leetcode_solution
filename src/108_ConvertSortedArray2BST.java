// Example:
// Given the sorted array: [-10,-3,0,5,9],
// One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//       0
//      / \
//    -3   9
//    /   /
//  -10  5

// Time complexity: O(n) Space: O(logn)

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
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    return helper(nums, 0, nums.length - 1);
  }

  public TreeNode helper(int[] nums, int start, int end) {
    if (start > end) return null;
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[mid]);

    root.left = helper(nums, start, mid - 1);
    root.right = helper(nums, mid + 1, end);
    return root;
  }
}
