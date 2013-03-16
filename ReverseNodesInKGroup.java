/**
 * Practiced on 1/3/2013
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * ===========================================
 * Here is the idea:
 * 
 * 1. For a given list, first identify the start and end of each group.
 * 2. Say the group looks like:
 * 		...startPrevious->start->...->end->endNext...
 * 3. Reverse the range between start and end:
 * 		...startPrevious->start<-...<-end  endNext...
 * 4. Reconnect the list:
 * 		...startPrevious->end->...->start->endNext
 * 5. Continue 2-4 with the next group.
 */

package com.congli.leetcode;

public class ReverseNodesInKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) 
	{
        if(head == null || head.next == null || k <= 1) return head;
        
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        
        ListNode pre = headPre;
        ListNode start = pre;
        ListNode end = pre;
        
        while(end != null)
        {
            start = pre.next;
            end = start;
            int n = 1;
            while(n != k && end != null)
            {
                end = end.next;
                ++n;
            }
            if(end != null)
            {
                ListNode endNext = reverse(start, end);
                pre.next = end;
                start.next = endNext;
                pre = start;
            }
        }
        return headPre.next;
    }
    
    public ListNode reverse(ListNode start, ListNode end)
    {
        ListNode toReturn = end.next;
        ListNode one = start;
        ListNode two = start.next;
        ListNode temp = null;
        start.next = null;
        
        while(two != end)
        {
            temp = two.next;
            two.next = one;
            one = two;
            two = temp;
        }
        two.next = one;
        return toReturn;
    }
}
