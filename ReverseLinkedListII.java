/**
 * Practiced on 1/2/2013
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * ==================================
 * Need to be very careful to write the code.
 * 1. Add a fake node beforehand to deal with the case m = 1.
 * 2. Use tempFirst, tempSecond to mark the next pair of nodes to be reversed.
 */

package com.congli.leetcode;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) 
	{
        if(m == n) return head;
        
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        
        int count = 1;
        ListNode startPrevious = headPre;
        while(count < m)
        {
            startPrevious = startPrevious.next;
            ++count;
        }
        
        ListNode first = startPrevious.next;
        ListNode second = first.next;
        ListNode tempFirst = first;
        ListNode tempSecond = second;
        while(count < n)
        {
            tempFirst = tempSecond;
            tempSecond = second.next;
            second.next = first;
            first = tempFirst;
            second = tempSecond;
            ++count;
        }
        ListNode end = startPrevious.next;
        startPrevious.next = first;
        end.next = second;
        
        return headPre.next;
    }
}
