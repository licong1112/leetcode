/**
 * Practiced on 12/1/2012
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class Combinations {

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(n == 0 || k == 0) return result;
        
        helper(result, new ArrayList<Integer>(), 1, n, k);
        
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int start, int n, int numLeft)
    {
        if(numLeft == 0)
        {
            result.add((ArrayList<Integer>)list.clone());
            return;
        }
        for(int i = start; i <= n; ++i)
        {
            list.add(i);
            helper(result, list, i+1, n, numLeft-1);
            list.remove(list.size()-1);
        }
    }
}
