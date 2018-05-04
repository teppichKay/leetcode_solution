// Given a binary tree
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
// Note:
//
// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// Recursion: O(n) O(logn)
public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) return;
    if (root.left != null) root.left.next = root.right;
    if (root.right != null) {
      if (root.next != null) {
        root.right.next = root.next.left;
      } else {
        root.right.next = null;
      }
    }
    connect(root.left);
    connect(root.right);
  }
}

// Iteration: Using two pointers.
// O(n) O(1)
public void connect2(TreeLinkNode root) {
  if (root == null) return;
  TreeLinkNode start = root;
  TreeLinkNode tmp = null;

  while (start.left != null) {
    tmp = start;
    while (tmp != null) {
      tmp.left.next = tmp.right;
      if (tmp.next != null) {
        tmp.right.next = tmp.next.left;
      }
      tmp = tmp.next;
    }
    start = start.left;
  }
}
