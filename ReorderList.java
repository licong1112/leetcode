/**
 * Practiced on 11/29/2013
 * 
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln, 
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * =============================================
 * 1. Find the middle point of the list, cut it.
 * 2. Reverse the second half of the list.
 */

package com.congli.leetcode;

public class ReorderList {
	
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // Find the middle point of the list
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode reverse_tail = slow.next;
        // Cut the list
        slow.next = null;
        ListNode head_1 = head;
        // Reverse the second half of the list.
        ListNode head_2 = reverse(reverse_tail);
        
        ListNode head_1_next = null;
        ListNode head_2_next = null;
        while (head_1 != null && head_2 != null) {
        	head_1_next = head_1.next;
			head_2_next = head_2.next;
        	head_1.next = head_2;
        	head_2.next = head_1_next;
        	head_1 = head_1_next;
        	head_2 = head_2_next;
        }
    }
	
	public ListNode reverse(ListNode head) {
		if (head.next == null) return head;
		ListNode pre = head;
		ListNode curr = head.next;
		ListNode next = curr.next;
		head.next = null;
		
		while (next != null) {
			curr.next = pre;
			pre = curr;
			curr = next;
			next = next.next;
		}
		curr.next = pre;
		return curr;
	}
}
