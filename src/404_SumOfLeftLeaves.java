// Find the sum of all left leaves in a given binary tree.
//
// Example:
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

///Solution : Iteration with Queue

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    int sum = 0;
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur.left != null) {
        if (cur.left.left == null && cur.left.right == null) {
          sum += cur.left.val;
        }
        queue.offer(cur.left);
      }
      if (cur.right != null) queue.offer(cur.right);
    }
    return sum;
  }
}

// Solution: Recursion

class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int sum = 0;
    if (root.left != null && root.left.left == null && root.left.right == null) {
      sum = root.left.val;
    }
    return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
  }
}








