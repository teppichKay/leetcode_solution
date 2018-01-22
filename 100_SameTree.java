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
   public boolean isSameTree(TreeNode p, TreeNode q) {
     if (p == null && q == null) return true;
     if (p == null || q == null) return false;
     if (p.val == q.val) {
       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
     } else {
       return false;
     }
   }
 }
