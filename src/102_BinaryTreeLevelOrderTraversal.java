// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// DFS
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    traverse(root, 1, result);
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


// BFS 
class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> l = new ArrayList<>();
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        TreeNode cur = queue.poll();
        l.add(cur.val);
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
      res.add(l);
    }
    return res;
  }
}



















