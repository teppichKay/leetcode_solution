// Given a binary tree, determine if it is height-balanced.
// For this problem, a height-balanced binary tree is defined as:
// a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
// Time complexity : O(n)  Space : O(logn)

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
  public boolean isBalanced(TreeNode root) {
    return findHeight(root) >= 0;
  }

  // similar to Maximum height of binary Tree
  public int findHeight(TreeNode root) {
    if (root == null) return 0;
    int left = findHeight(root.left);
    int right = findHeight(root.right);

    // pruning branches
    if (Math.abs(left - right) > 1 || left < 0 || right < 0) return -1;
    return 1 + Math.max(left, right);
  }
}
