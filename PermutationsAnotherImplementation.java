/**
 * Practiced on 12/17/2012
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * =====================================
 * This is another implementation, which is much simpler. 
 * Not like the first implementation, it does not keep building and deleting arraylists.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class PermutationsAnotherImplementation {
	public ArrayList<ArrayList<Integer>> permute(int[] num) 
	{
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return null;
        
        int[] perm = new int[num.length];
        boolean[] used = new boolean[num.length];
        permuteHelper(result, perm, num, used, 0);
        return result;
    }
    
    private void permuteHelper(ArrayList<ArrayList<Integer>> result, int[] perm, int[] num, boolean[] used, int level)
    {
        if(level == num.length)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < perm.length; ++i)
                list.add(perm[i]);
            result.add(list);
            return;
        }
        
        int i = 0;
        while(i < num.length)
        {
            if(!used[i])
            {
                perm[level] = num[i];
                used[i] = true;
                permuteHelper(result, perm, num, used, level+1);
                used[i] = false;
            }
            ++i;
        }
    }
}
