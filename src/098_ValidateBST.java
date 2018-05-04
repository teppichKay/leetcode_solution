// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// O(n) O(h)
// use inorder traversal to pass the tree.

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
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrderTraversal(root, list);
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) >= list.get(i+1)) return false;
		}
		return true;
	}

	public void inOrderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) return;
		inOrderTraversal(root.left, list);
		list.add(root.val);
		inOrderTraversal(root.right, list);
	}
}