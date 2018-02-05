// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

// Recursion
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
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> res = new ArrayList<>();
     zigzagLevelOrder(root, res, 1);
     return res;
   }

   public void zigzagLevelOrder(TreeNode root, List<List<Integer>> res, int level) {
     if (root == null) return;
     // level is odd: left to right; level is even: right to left
     if (level > res.size()) {
       res.add(new ArrayList<>());
     }
     if (level % 2 == 0) {
       res.get(level-1).add(0, root.val);
     } else {
       res.get(level-1).add(root.val);
     }
     zigzagLevelOrder(root.left, res, level+1);
     zigzagLevelOrder(root.right, res, level+1);
   }
 }
