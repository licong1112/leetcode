/**
 * Practiced on 12/31/2012
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * =======================================
 * The following function considers also invalid n.
 */

package com.congli.leetcode;

public class RemoveNthNodeFromList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) 
	{
        if(n <= 0) return head;
        
        int i = 1;
        ListNode runner = head;
        while(runner != null && i < n)
        {
            runner = runner.next;
            ++i;
        }
        if(runner == null) return head; // n is larger than the length of the list
        if(runner.next == null) // n equals the length of the list
        {
            head = head.next;
            return head;
        }
        
        ListNode first = head;
        while(runner.next.next != null)
        {
            first = first.next;
            runner = runner.next;
        }
        first.next = first.next.next;
        return head;
    }
}
