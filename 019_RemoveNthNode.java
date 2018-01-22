/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // Time complexity: O(n) space complexity: O(1)
 class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
     ListNode dummy = new ListNode(-1);
     dummy.next = head;
     ListNode fast = dummy, slow = dummy;

     for (int i = 0; i < n; i++) {
       fast = fast.next;
     }
     while (fast.next != null) {
       fast = fast.next;
       slow = slow.next;
     }
     // remove the nth node
     slow.next = slow.next.next;
     return dummy.next;
   }
 }
