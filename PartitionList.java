/**
 * Practiced on 12/13/2012
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x 
 * come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * =========================
 * It is easy to write O(n) space complexity method. But it is possible to write O(1) space 
 * complexity method. See the following code.
 * 
 * The basic idea is that, maintain two pointers, one for lower than x, one for higher or equal to x.
 * Every time when current node is less than x, then set it as the next node of the lower runner.
 * Otherwise, set it as the next node of the higher runner.
 * At the end, connect the last lower node to the first node of the higher node.
 */

package com.congli.leetcode;

public class PartitionList {
	
	public ListNode partition(ListNode head, int x) 
	{
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode lowStart;
        ListNode highStart;
        ListNode lowRunner;
        ListNode highRunner;
        ListNode runner = head.next;
        
        if(head.val < x)
        {
            lowStart = head;
            lowRunner = head;
            while(runner != null && runner.val < x)
            {
                lowRunner = lowRunner.next;
                runner = runner.next;
            } 
            if(runner == null) return head;
            highStart = runner;
            highRunner = runner;
            runner = highStart.next;
        }
        else
        {
            highStart = head;
            highRunner = head;
            while(runner != null && runner.val >= x)
            {
                highRunner = highRunner.next;
                runner = runner.next;
            }
            if(runner == null) return head;
            lowStart = runner;
            lowRunner = runner;
            runner = lowStart.next;
        }
        
        while(runner != null)
        {
            if(runner.val < x)
            {
                lowRunner.next = runner;
                lowRunner = lowRunner.next;
            }
            else
            {
                highRunner.next = runner;
                highRunner = highRunner.next;
            }
            runner = runner.next;
        }
        lowRunner.next = highStart;
        highRunner.next = null;
        
        return (head.val < x) ? head : lowStart;
    }
}
