/**
 * Practiced on 12/10/2012
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */

package com.congli.leetcode;

public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode firstHalf, ListNode secondHalf) 
	{
        if(firstHalf == null) return secondHalf;
        if(secondHalf == null) return firstHalf;
        
        ListNode result = new ListNode(0);
        
        ListNode runner = result;
        while(firstHalf != null || secondHalf != null)
        {
            if(firstHalf != null && secondHalf != null)
            {
                if(firstHalf.val < secondHalf.val)
                {
                    runner.next = new ListNode(firstHalf.val);
                    firstHalf = firstHalf.next;
                }
                else
                {
                    runner.next = new ListNode(secondHalf.val);
                    secondHalf = secondHalf.next;
                }
            }
            else if(firstHalf != null)
            {
                runner.next = new ListNode(firstHalf.val);
                firstHalf = firstHalf.next;
            }
            else
            {
                runner.next = new ListNode(secondHalf.val);
                secondHalf = secondHalf.next;
            }
            runner = runner.next;
        }
        return result.next;
    }
}
