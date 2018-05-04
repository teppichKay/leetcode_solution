// Given a binary tree, find its maximum depth.
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its depth = 3.

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
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    // Recursion : O(n), O(logn)
    //return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    // Iteration: Level order traversal
    // O(n), < O(n)
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int height = 0;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      height++;
      for (int i = 0; i < levelSize; i++) {
        TreeNode tmp = queue.poll();
        if (tmp.left != null) queue.offer(tmp.left);
        if (tmp.right != null) queue.offer(tmp.right);
      }
    }
    return height;
  }
}
