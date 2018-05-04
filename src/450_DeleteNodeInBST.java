// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// Basically, the deletion can be divided into two stages:

// Search for a node to remove.
// If the node is found, delete the node.
// Note: Time complexity should be O(height of tree).

// public class TreeNode {
// 	int val;
// 	TreeNode left;
// 	TreeNode right;
// 	TreeNode(int x) { val = x; }
// }

// a. if root < key, search node in root right.
// b. if root > key, search node in root left.
// c. if root = key, 
// 	c.1 root has no children, then delete it.
// 	c.2 root has only left child, delete it and connect left child to the tree.
// 	c.3 root has only right child, delete it and conncet right child to the tree.
// 	c.4 root has both left and right children, set the min value from the right subtree to root.val,
// 	and recursively delete node with this value from right subtree.

class Solution {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null && root.right == null) return null;
			else if (root.left != null && root.right == null) return root.left;
			else if (root.left == null && root.right != null) return root.right;
			else {
				TreeNode m = findMinNode(root.right);
				root.val = m.val;
				root.right = deleteNode(root.right, root.val);
			}
		}
		return root;
	}
	private TreeNode findMinNode(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}