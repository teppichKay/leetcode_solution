/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Time complexity: O(nlogk) Space: O(n)

 class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
     if (lists == null || lists.length == 0) return null;
     return sort(lists, 0, lists.length - 1);
   }

   // binary search O(logk)
   private ListNode sort(ListNode[] lists, int low, int high) {
     if (low >= high) return lists[low];
     int mid = (high - low) / 2 + low;
     ListNode l1 = sort(lists, low, mid);
     ListNode l2 = sort(lists, mid+1, high);
     return mergeTwoLists(l1, l2);
   }

   // reuse mergeTwoLists method
   private ListNode mergeTwoLists(ListNode a, ListNode b) {
     ListNode dummy = new ListNode(0);
     ListNode cur = dummy;
     while (a != null && b != null) {
       if (a.val > b.val) {
         cur.next = b;
         b = b.next;
       } else {
         cur.next = a;
         a = a.next;
       }
       cur = cur.next;
     }
     if (a != null) {
       cur.next = a;
     }
     if (b != null) {
       cur.next = b;
     }
     return dummy.next;
   }
 }
