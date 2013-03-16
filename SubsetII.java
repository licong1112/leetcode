/**
 * Practiced on 1/19/2013
 * 
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) 
	{
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return result;
       
        Arrays.sort(num);
       
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add((ArrayList<Integer>)list.clone());
       
        helper(result, new ArrayList<Integer>(), num, 0);
        return result;
    }
   
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] num, int start)
    {       
        for(int i = start; i < num.length; ++i)
        {
            if(i == start || (i != start && num[i] != num[i-1]))
            {
                list.add(num[i]);
                result.add((ArrayList<Integer>)list.clone());
                helper(result, list, num, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
