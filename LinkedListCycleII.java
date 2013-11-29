/**
 * Practiced on 11/29/2013
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * ================================================================
 * 1. Use "slow" and "fast" to find if there is cycle.
 * 2. Assume there is cycle, and "slow" and "fast" meet at a certain node
 *    in the cycle. Call this node "meet".
 * 3. Let "meet.next = null" to cut the cycle. Then the list has two heads,
 *    one is the original head, another one is the original meet.next.
 *    Obviously, the two lists that associate with the two heads meet at
 *    a node, which is the starting point of the cycle.
 * 4. Then only need to fine the node that the two lists meet.
 * 
 * It is worth to notice another method, which gives a more elegant solution:
 * http://www.cnblogs.com/TenosDoIt/p/3416702.html
 */

package com.congli.leetcode;

public class LinkedListCycleII {
	
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
        	if (fast == null || fast.next == null || fast.next.next == null) {
        		return null;
        	}
        	slow = slow.next;
    		fast = fast.next.next;
        }
        // Cut the cycle
        slow = slow.next;
        fast.next = null;
        
        // The two lists meet at a node. Find that node.
        ListNode head_1 = head;
        ListNode head_2 = slow;
        int length_head_1 = length(head_1);
        int length_head_2 = length(head_2);
        int difference = Math.abs(length_head_1 - length_head_2);
    	while (difference > 0) {
    		if (length_head_1 >= length_head_2) {
    			head_1 = head_1.next;
    		} else {
    			head_2 = head_2.next;
    		}
    		--difference;
    	}
        // Find the node that the two lists meet
    	while (head_1 != head_2) {
    		head_1 = head_1.next;
    		head_2 = head_2.next;
    	}
    	// Reconnect the cycle
    	fast.next = slow;
    	return head_1;
    }
	
	public int length(ListNode head) {
		if (head == null) return 0;
		int result = 0;
		while (head != null) {
			++result;
			head = head.next;
		}
		return result;
	}
}
