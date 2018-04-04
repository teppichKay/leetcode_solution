// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;

		while (l1 != null || l2 != null || carry != 0) {
			ListNode cur = new ListNode(-1);
			int v = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			carry = v / 10;
			cur.val = v % 10;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
			prev.next = cur;
			prev = cur;
		}
		return dummy.next;
	}
}