/**
 * Practiced on 1/7/2013
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */

package com.congli.leetcode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) 
	{
        if(head == null) return head;
        ListNode tail = head;
        int length = 1;
        while(tail.next != null)
        {
            tail = tail.next;
            ++length;
        }
        tail.next = head;
        n %= length;

        int count = 1;
        while(count < length-n)
        {
            head = head.next;
            ++count;
        }
        ListNode toReturn = head.next;
        head.next = null;
        
        return toReturn;
    }
}
