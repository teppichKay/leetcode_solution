/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Time complexity: O(n) Space complexity: O(1)
 class Solution {
   public ListNode removeElements(ListNode head, int val) {
     ListNode dummy = new ListNode(0);
     dummy.next = head;
     ListNode prev = dummy;

     while (prev.next != null) {
       if (prev.next.val == val) {
         prev.next = prev.next.next;
       } else {
         prev = prev.next;
       }
     }
     return dummy.next;
   }
 }
