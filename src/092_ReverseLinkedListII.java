// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
// return 1->4->3->2->5->NULL.
// Time: O(n)  Space: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;

    for (int i = 0; i < m-1; i++) {
      pre = pre.next;
    }
    ListNode newHead = pre;
    pre = pre.next;
    ListNode cur = pre.next;
    for (int i = m; i < n; i++) {
      prev.next = cur.next;
      cur.next = newHead.next;
      newHead.next = cur;
      cur = pre.next;
    }

    return dummy.next;
   }
 }
