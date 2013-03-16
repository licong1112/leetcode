/**
 * Practiced on 1/16/2013
 * 
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * ================================
 * It is not difficult to write recursive solution. To write iterative solution, we
 * need some smart operations. See the last function I wrote.
 * 
 * We can use variable "marker" as the marker of "1"'s. When marker goes from 0 to
 * 2^(s.length)-1, the "1"s' positions of each marker value is the index of the s's
 * element that we need to add into the list.
 * 
 * For example: when marker = 0, its binary representation is 0000. Since all bits are 0,
 * we don't add any element into list, thus then we add this empty list to the result list.
 * 
 * When marker = 1, its binary representation is 0001. Since the last bit is 1, we add s[4]
 * into the list.
 * 
 * When marker = 7, its binary representation is 0111, thus we add s[1]-s[3] into the list.
 * 
 * So when marker traverse 0 to 2^(s.length)-1, we get all possible 2^(s.length) subsets of 
 * array s.
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {

	public ArrayList<ArrayList<Integer>> subsets(int[] s) 
	{
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(s == null || s.length == 0) return result;
        
        Arrays.sort(s);
        ArrayList<Integer> list = new ArrayList<Integer>();
        result.add((ArrayList<Integer>)list.clone()); // add the empty set
        
        helper(result, s, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, int[] s, ArrayList<Integer> list, int start)
    {
        if(start == s.length) return;

        for(int i = start; i < s.length; ++i)
        {
            list.add(s[i]);
            result.add((ArrayList<Integer>)list.clone());
            helper(result, s, list, i+1);
            list.remove(list.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsetsIterative(int[] s) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(s == null || s.length == 0) return result;
        
        Arrays.sort(s);
        
        for(int marker = 0; marker <= ((1<<s.length)-1); ++marker)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int temp = marker;
            for(int i = 0; i < s.length; ++i)
            {
                if((temp & 1) == 1)
                    list.add(s[i]);
                temp = (temp >> 1);
            }
            result.add(list);
        }
        return result;
    }   
}
