// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// Time complexity: O(n)  Space: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class Solution {
   public void reorderList(ListNode head) {
     if (head == null || head.next == null) return;
     // find the mid
     ListNode slow = head, fast = head;
     ListNode tmp = null;
     while (fast != null && fast.next != null) {
       tmp = slow;
       slow = slow.next;
       fast = fast.next.next;
     }
     // cut at the mid
     tmp.next = null;
     //reverse the second part
     slow = reverseList(slow);
     //merge two parts
     mergeList(head, slow);
   }

   public ListNode reverseList(ListNode head) {
     ListNode pre = null;
     while (head != null) {
       ListNode tmp = head.next;
       head.next = pre;
       pre = head;
       head = tmp;
     }
     return pre;
   }

   public void mergeList(ListNode p, ListNode q) {
     while (p != null && q != null) {
       ListNode p1 = p.next;
       ListNode q1 = q.next;
       p.next = q;
       if (p1 == null) break;
       q.next = p1;
       p = p1;
       q = q1;
     }
   }
 }
