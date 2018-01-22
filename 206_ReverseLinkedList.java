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
   public ListNode reverseList(ListNode head) {
     ListNode prev = null;
     ListNode cur = head;

     while (cur != null) {
       ListNode tmp = cur.next;
       cur.next = prev;

       prev = cur;
       cur = tmp;
     }
     return prev;
   }
 }
