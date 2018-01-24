/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Time complexity: O(n) Space complexity: O(n)
 class Solution {
   public boolean isSymmetric(TreeNode root) {
     if (root == null) return true;
     return isSym(root.left, root.right);
   }

   public boolean isSym(TreeNode l, TreeNode r) {
     if (l == null && r == null) return true;
     if (l == null || r == null) return false;
     if (l.val == r.val) {
       return isSym(l.left, r.right) && isSym(l.right, r.left);
     } else {
       return false;
     }
   }
 }
