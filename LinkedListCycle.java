/**
 * Practiced on 10/29/2013
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */

package com.congli.leetcode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
		ListNode one = head.next;
        ListNode two = head.next.next;
        
        while (one != two) {
        	if (two == null || two.next == null || two.next.next == null) {
        		return false;
        	}
        	one = one.next;
    		two = two.next.next;
        }
        return true;
    }
}

