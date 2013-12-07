/**
 * Practiced on 12/6/2013
 * 
 * Sort a linked list using insertion sort.
 */

package com.congli.leetcode;

public class InsertionSortList {	
	public ListNode insertionSortList(ListNode head) {
		ListNode fake_head = new ListNode(0);
		fake_head.next = head;
		sort(fake_head, head);
		return fake_head.next;
    }
	
	public void sort(ListNode pre_head, ListNode head) {
		if (head == null) return;
		int min = head.val;
		ListNode min_node = head;
		ListNode min_pre = pre_head;
		ListNode pre = head;
		ListNode curr = head.next;
		
		while (curr != null) {
			if (min > curr.val) {
				min = curr.val;
				min_node = curr;
				min_pre = pre;
			}
			curr = curr.next;
			pre = pre.next;
		}
		if (min_node != head) {
			pre_head.next = min_node;
			min_pre.next = min_node.next;
			min_node.next = head;
			head = pre_head.next;
		}
		sort(head, head.next);
	}
}
