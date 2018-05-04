// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
// Example:
//
// Given the sorted linked list: [-10,-3,0,5,9],
//
// One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//       0
//      / \
//    -3   9
//    /   /
//  -10  5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
  public TreeNode sortedArrayToBST(ListNode head) {
    if (head == null) return null;
    return helper(head);
  }

  public TreeNode helper(ListNode head) {
    if (head == null) return null;
    // !!!important!!! otherwise stack might be overflow
    if (head.next == null) return new TreeNode(head.val);

    ListNode fast = head, slow = head;
    ListNode cut = head;
    while (fast != null && fast.next != null) {
      cut = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    cut.next = null;
    TreeNode root = new TreeNode(slow.val);
    root.left = helper(head);
    // go to the next node
    root.right = helper(slow.next);
    return root;
  }
}
