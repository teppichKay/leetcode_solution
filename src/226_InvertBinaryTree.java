// Invert a binary tree.
//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// to
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1: Recursion
class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;

    TreeNode l = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(l);

    return root;
  }
}

// Solution 2: Iteration with queue
class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      TreeNode l = cur.left;
      cur.left = cur.right;
      cur.right = l;

      if (cur.left != null) queue.offer(cur.left);
      if (cur.right != null) queue.offer(cur.right);
    }
    return root;
  }
}
