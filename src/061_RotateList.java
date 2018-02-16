// Given a list, rotate the list to the right by k places, where k is non-negative.
//
// Example:
//
// Given 1->2->3->4->5->NULL and k = 2,
//
// return 4->5->1->2->3->NULL.

// Time complexity: O(n) Space: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class Solution {
     public ListNode rotateRight(ListNode head, int k) {
         if (head == null || k <= 0) return head;
         ListNode tmp = head;
         int len = 1;

         while (tmp.next != null) {
             tmp = tmp.next;
             len++;
         }
         // k might be larger than len
         // a new k
         k = len - k % len;
         // form a circle
         tmp.next = head;
         for(int step = 0; step < k; step++) {
             tmp = tmp.next;
         }
         head = tmp.next;
         tmp.next = null;
         return head;

     }
 }
