// Given a binary tree, return all root-to-leaf paths.
// ["1->2->5", "1->3"]
//
// Time complexity: O(n)  Space: O(n)

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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null) return res;

    String path = "";
    helper(res, root, path);
    return res;
  }

  public void helper (List<String> res, TreeNode root, String path) {
    if (root.left == null && root.right == null) {
      path += root.val;
      res.add(path);
    }

    if (root.left != null) helper(res, root.left, path + root.val + "->");
    if (root.right != null) helper(res, root.right, path + root.val + "->");
  }
}
