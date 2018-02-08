/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Time complexity: O(2^n)  space: O(n)

 class Solution {
   public List<Integer> rightSideView(TreeNode root) {
     List<Integer> res = new ArrayList<>();
     helper(root, res, 1);
     return res;
   }

   public void helper(TreeNode root, List<Integer> res, int depth) {
     if (root == null) return;
     if (res.size() < depth) res.add(root.val);

     // right leaf first
     helper(root.right, res, depth+1);
     helper(root.left, res, depth+1);
   }
 }
