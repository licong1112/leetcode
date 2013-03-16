/**
 * Practiced on 12/10/2012
 * 
 * ===========================
 * This algorithm runs O(n*lgk) time complexity.
 * 
 * 1. Merge k/2 groups of two lists, each list has n/k elements, thus cost O(k/2 * 2n/k) = O(n) time.
 * 2. Then we have k/2 groups of sorted lists. Now we can merge k/4 groups of two lists, each list has
 * 	  2n/k elements, thus cost O(k/4 * 4n/k) = O(n) time.
 * 3. This analysis can keep going.
 * 4. There are lgk divisions in total. Therefore the complexity is O(n*lgk).
 * 
 * In judge large, this algorithm usually costs 580ms, while the previous one costs 720ms or time limit
 * exceed.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class MergeKSortedListsAnotherSolution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) 
	{
        if(lists == null || lists.size() == 0) return null;
        
        boolean returnNull = true;
        for(ListNode node : lists)
            if(node != null) returnNull = false;
        
        if(returnNull) return null;
        
        return merge(lists, 0, lists.size()-1);
    }
    
    private ListNode merge(ArrayList<ListNode> lists, int start, int end)
    {
        if(start == end)
            return lists.get(start);
        
        int mid = start + (end - start)/2;
        
        ListNode firstHalf = merge(lists, start, mid);
        ListNode secondHalf = merge(lists, mid+1, end);
        
        return mergePhase(firstHalf, secondHalf);
    }
    
    private ListNode mergePhase(ListNode firstHalf, ListNode secondHalf)
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
