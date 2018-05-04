// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

// Binary Tree Recursion
// Time complexity: O(n) Space: O(logn)

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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      if (root == null) return res;
      list.add(root.val);
      helper(root, sum, res, list);
      return res;
  }

  public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
     if (root.left == null && root.right == null && sum - root.val == 0) {
         res.add(new ArrayList<>(list));
         //return;
     }

     if (root.left != null) {
         list.add(root.left.val);
         helper(root.left, sum - root.val, res, list);
     }
     if (root.right != null) {
         list.add(root.right.val);
         helper(root.right, sum - root.val, res, list);
     }
     list.remove(list.size() - 1);
 }
}
