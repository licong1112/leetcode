/**
 * Practiced on 12/30/2012
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * =================================================
 * Need to be careful with the head. For example: 1->1->2->3 should return 2->3.
 * So after the while loop, the original list becomes 1->2->3, and thus the head should point to "2".
 */

package com.congli.leetcode;

public class RemoveDuplicatesFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) 
	{
        if(head == null || head.next == null) return head;
        ListNode start = head;
        ListNode runner = head.next;
        ListNode previous = head;
        boolean isHeadValid = (head.val != head.next.val);
        
        while(runner != null)
        {
            if(runner.val != previous.val && (runner.next == null || runner.val != runner.next.val))
            {
                start.next.val = runner.val;
                start = start.next;
            }
            runner = runner.next;
            previous = previous.next;
        }
        
        if(!isHeadValid)
        {
            if(start == head) return null; // All elements should be deleted
            head = head.next; // Otherwise, only the head should be deleted
        }
        start.next = null;
        return head;
    }
}
