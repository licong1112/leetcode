/**
 * Practiced on 11/19/2012
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

package com.congli.leetcode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode result = new ListNode(0);
        ListNode runner = result;
        int[] carry = {0};
        while(l1 != null || l2 != null)
        {
            if(l1 != null && l2 != null)
            {
                runner.val = addHelper(l1.val, l2.val, carry);
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 != null)
            {
                runner.val = addHelper(l1.val, 0, carry);
                l1 = l1.next;
            }
            else
            {
                runner.val = addHelper(l2.val, 0, carry);
                l2 = l2.next;
            }
            if(l1 != null || l2 != null)
            {
            	runner.next = new ListNode(0);
                runner = runner.next;
            }
        }
        if(carry[0] == 1) runner.next = new ListNode(1);
        
        return result;
    }
    
    private int addHelper(int a, int b, int[] carry)
    {
        int result = a + b + carry[0];
        carry[0] = result / 10;
        return result % 10;
    }
}


