/**
 * Practiced on 12/6/2013
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * =========================================
 * 1. Find the mid-point, and sort the two sides
 * 2. Cut the sorted two sides into two lists, i.e. 
 *    3->1->4->7->6->5->2->9->8 is sorted to
 *    1->3->4->6->7->2->5->8->9. Then, cut to two lists:
 *    1->3->4->6->7
 *    2->5->8->9
 * 3. Merge is different to array-based merge:
 *    1->2->5->8->9
 *    3->4->6->7
 *    
 *    5->8->9
 *    1->2->3->4->6->7
 *    
 *    1->2->3->4->5->8->9
 *    6->7
 *    
 *    8->9
 *    1->2->3->4->5->6->7
 *    
 *    1->2->3->4->5->6->7->8->9
 */

package com.congli.leetcode;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null) return null;
		ListNode end = head;
		while (end.next != null) {
			end = end.next;
		}
		return sort(head, end);
	}
	
	public ListNode sort(ListNode start, ListNode end) {
		if (start == end) return start;
		ListNode slow = start;
		ListNode fast = start;
		while (fast != end && fast.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode start_1 = start;
		ListNode end_1 = slow;
		ListNode start_2 = slow.next;
		ListNode end_2 = fast == end ? fast : fast.next;
		slow.next = null; // Break the two lists
		ListNode head_1 = sort(start_1, end_1);
		ListNode head_2 = sort(start_2, end_2);
		// Always keep head_2 pointing to the head with larger value
		if (head_1.val > head_2.val) {
			ListNode temp = head_1;
			head_1 = head_2;
			head_2 = temp;
		}
		ListNode head = head_1;
		
		// Always keep head_2 pointing to the head with larger value
		while (head_1 != null && head_2 != null) {
			while (head_1.next != null && head_1.next.val <= head_2.val) {
				head_1 = head_1.next;
			}
			ListNode temp = head_1.next;
			head_1.next = head_2;
			head_1 = head_2;
			head_2 = temp;
		}
		return head;
	}
}
