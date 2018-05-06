// Print a binary tree in an m*n 2D string array following these rules:

// Input:
//      1
//     / \
//    2   3
//     \
//      4
// Output:
// [["", "", "", "1", "", "", ""],
//  ["", "2", "", "", "", "3", ""],
//  ["", "", "4", "", "", "", ""]]

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	public List<List<String>> printTree(TreeNode root) {
		// create result structure
		int h = getHeight(root);
		int w = (int) Math.pow(2, h) - 1;
		List<List<String>> res = new ArrayList<>();
		List<String> row = new ArrayList<>();
		for (int i = 0; i < w; i++) {
			row.add("");
		}
		for (int i = 0; i < h; i++) {
			res.add(new ArrayList<>(row));
		}

		fill(root, res, 0, w - 1, 0, w);
		return res;
	}

	// calculate the height of the tree
	private int getHeight(TreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	
	private void fill(TreeNode root, List<List<String>> res, int left, int right, int maxHeight) {
		if (root == null || height >= maxHeight || left > right) 
			return null;
		int mid = (left + right) / 2;
		res.get(height).set(mid, Integer.toString(root.val));
		fill(root.left, res, left, mid - 1, height + 1, maxHeight);
        fill(root.right, res, mid + 1, right, height + 1, maxHeight);

	}
}




