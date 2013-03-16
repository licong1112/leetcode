/**
 * Practiced on 12/30/2012
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * =========================================
 * The logic is simple. Didn't write bug-free code. Need to be careful to write it correctly.
 */

package com.congli.leetcode;

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null || head.next == null) return head;
        ListNode start = head;
        ListNode runner = head.next;
        ListNode previous = head;
        
        while(runner != null)
        {
            if(runner.val != previous.val)
            {
                start.next.val = runner.val;
                start = start.next;
            }

            runner = runner.next;
            previous = previous.next;
        }
        start.next = null;
        return head;
    }
}
