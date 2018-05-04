/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // Time: O(min(a,b))  Space: O(1)
 
 class Solution {
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     ListNode dummy = new ListNode(0);
     ListNode p = dummy;

     while (l1 != null && l2 != null) {
       if (l1.val > l2.val) {
         p.next = l2;
         l2 = l2.next;
       } else {
         p.next = l1;
         l1 = l1.next;
       }
       p = p.next;
     }
     if (l1 != null) {
       p.next = l1;
     } else {
       p.next = l2;
     }
     return dummy.next;
   }
}
