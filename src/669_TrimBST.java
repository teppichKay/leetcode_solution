// Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
// Input: 
//     3
//    / \
//   0   4
//    \
//     2
//    /
//   1

//   L = 1
//   R = 3

// Output: 
//       3
//      / 
//    2   
//   /
//  1

// Recursion
// a. if root > R, trim root.left
// b. if root < L, trim root.right
// c. if L < root < R, trim both left and right subtree of root.
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) return null;
		if (root.val < L) return trimBST(root.right, L, R);
		else if (root.val > R) return trimBST(root.left, L, R);
		else {
			root.left = trimBST(root.left, L, R);
			root.right = trimBST(root.right, L, R);
		}
		return root;
	}
}