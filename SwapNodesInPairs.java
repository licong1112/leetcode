/**
 * Practiced on 1/22/2013
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values 
 * in the list, only nodes itself can be changed.
 */

package com.congli.leetcode;

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) 
	{
        if(head == null || head.next == null) return head;
        
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        ListNode first = head;
        ListNode second = head.next;
        
        while(second != null)
        {
            first.next = second.next;
            second.next = first;
            pre.next = second;
            
            if(first.next == null) break;
            pre = first;
            first = first.next;
            second = first.next;
        }
        return fake.next;
    }
}
