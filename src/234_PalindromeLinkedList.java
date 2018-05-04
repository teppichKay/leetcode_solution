// Given a singly linked list, determine if it is a palindrome.
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
     public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null) return true;
         ListNode fast = head, slow = head;
         ListNode p1 = null;
         while (fast != null && fast.next != null) {
             p1 = slow;
             slow = slow.next;
             fast = fast.next.next;
         }
         // cut
         p1.next = null;
         // reverse the second half
         if (fast != null) {
             slow = slow.next;
         }
         slow = reverse(slow);

         // compare two linkedlists
         ListNode t1 = slow, t2 = head;
         while (t1 != null & t2 != null) {
             if (t1.val != t2.val) return false;
             t1 = t1.next;
             t2 = t2.next;
         }
         return true;
     }
     public ListNode reverse(ListNode head) {
         ListNode pre = null;
         while (head != null) {
             ListNode tmp = head.next;
             head.next = pre;
             pre = head;
             head = tmp;
         }
         return pre;
     }
 }
