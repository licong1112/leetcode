/**
 * Practiced on 12/1/2012
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class CombinationSum {
	
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates.length == 0 || candidates == null) return result;
        
        sort(candidates, 0, candidates.length-1);
        
        helper(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
	private void helper(int[] candidates, int target, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result)
    {
		if(target == 0)
        {
        	result.add((ArrayList<Integer>)list.clone());
        	return;
        }
    	for(int i = start; i < candidates.length; ++i)
        {
            if(candidates[i] > target)
                break;
            
            else
            {
                list.add(candidates[i]);
                helper(candidates, target - candidates[i], i, list, result);
                list.remove(list.size()-1);
            }
        }
    }
	
    
    // The following is the merge sort algorithm. 
    private void sort(int[] array, int start, int end)
    {
        if(start >= end) return;
        
        int mid = start + (end - start)/2;
        sort(array, start, mid);
        sort(array, mid+1, end);
        merge(array, start, mid, end);
    }
    
    private void merge(int[] array, int start, int mid, int end)
    {
        int[] temp = new int[end-start+1];
        int aInd = start;
        int bInd = mid+1;
        
        for(int i = 0; i < temp.length; ++i)
        {
            if(aInd <= mid && bInd <= end)
            {
                if(array[aInd] < array[bInd])
                {
                    temp[i] = array[aInd++];
                }
                else
                {
                    temp[i] = array[bInd++];
                }
            }
            else if(aInd <= mid)
            {
                temp[i] = array[aInd++];
            }
            else
            {
                temp[i] = array[bInd++];
            }
        }
        
        for(int i = 0; i < temp.length; ++i)
        {
            array[start++] = temp[i];
        }
    }
}
