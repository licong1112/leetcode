/**
 * Practiced on 12/10/2012
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * =============================
 * The idea is the same as the merge phase in merge sort.
 * Every iteration, we need to do k comparisons. Therefore the complexity is O(n*k);
 * There is a O(n*lgk) algorithm. See the next file.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) 
	{
        if(lists == null || lists.size() == 0) return null;
        
        boolean returnNull = true;
        for(ListNode node : lists)
        	if(node != null) returnNull = false;
        
        if(returnNull) return null;
        
        ListNode result = new ListNode(0);
        ListNode runner = result;
        
        while(!isStop(lists))
        {
            int smallest = findSmallest(lists);
            runner.next = new ListNode(lists.get(smallest).val);
            runner = runner.next;
            lists.set(smallest, lists.get(smallest).next);
        }
        
        return result.next;
    }
    
    private int findSmallest(ArrayList<ListNode> lists)
    {
        int smallestInd = 0;
        
        for(int i = 1; i < lists.size(); ++i)
        {
            if(lists.get(smallestInd) == null) 
            	smallestInd = i;
            
            if(lists.get(i) != null && lists.get(i).val <= lists.get(smallestInd).val)
            	smallestInd = i;
        }
        return smallestInd;
    }
    
    private boolean isStop(ArrayList<ListNode> lists)
    {
        boolean result = true;
        for(ListNode node : lists)
        	if(node != null) result = false;
        
        return result;
    }
}
