// Given a binary tree, return the bottom-up level order traversal of its nodes' values.
// (ie, from left to right, level by level from leaf to root).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]
//
// Recursive solution:
// Time complexity: O(n) Space: O(n)

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
   public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
       traverse(root, 1, result);
       Collections.reverse(result);
       return result;
   }

   private void traverse(TreeNode root, int level, List<List<Integer>> result) {
       if (root == null) return;

       if (level > result.size()) {
           result.add(new ArrayList<>());
       }

       result.get(level - 1).add(root.val);
       traverse(root.left, level + 1, result);
       traverse(root.right, level + 1, result);
    }
}
