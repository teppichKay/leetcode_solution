// Given a binary tree, flatten it to a linked list in-place.
// For example,
// Given
//
//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6

// Time complexity: O(n)  Space: O(logn)
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
  public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);

    TreeNode r = root.right;
    TreeNode l = root.left;
    root.left = null;
    root.right = l;

    while (root.right != null) {
      root = root.right;
    }
    root.right = r;
  }
}
