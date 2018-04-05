// Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
// You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

// Example 1:
// Input: 
// 	Tree 1                     Tree 2                  
//           1                         2                             
//          / \                       / \                            
//         3   2                     1   3                        
//        /                           \   \                      
//       5                             4   7                  
// Output: 
// Merged tree:
// 	     3
// 	    / \
// 	   4   5
// 	  / \   \ 
// 	 5   4   7

// Time complexity: O(n)   Space complexity: O(h)

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
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode res = new TreeNode(0);
		if (t1 == null && t2 == null) return null;

		if (t1 == null) {
			res.val = t2.val;
			res.left = mergeTrees(null, t2.left);
			res.right = mergeTrees(null, t2.right);
		} else (t2 == null) {
			res.val = t1.val;
			res.left = mergeTrees(t1.left, null);
			res.right = mergeTrees(t1.right, null);
		} else if (t1 != null && t2 != null) {
			res.val = t1.val + t2.val;
			res.left = t1.left + t2.left;
			res.right = t1.right + t2.right;
		}
		return res;
	}
}