/**
 * Practiced on 12/17/2012
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * ==================================
 * The idea is the following:
 * 
 * Maintain the int[] perm array. For eacn position perm[i], it can be any number in num[].
 * However, once perm[i] is arranged with a number, then any other number which is the same
 * as this number can not be put at perm[i] again. Otherwise we are duplicating it.
 * 
 * For example, in the above case, perm[0] can be either 1 or 2. However, once perm[0] = 1 (num[0]),
 * then num[1] cannot be put at perm[0] again. Otherwise we are duplicating the result.
 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return null;
        
        int[] perm = new int[num.length];
        boolean[] used = new boolean[num.length];
        permute(result, num, perm, used, 0);
        
        return result;
    }
    
    private void permute(ArrayList<ArrayList<Integer>> result, int[] num, int[] perm, boolean[] used, int level)
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
                permute(result, num, perm, used, level+1);
                used[i] = false;
                ++i;
                while(i < num.length && num[i] == num[i-1])
                	++i;
            }
            else
            	++i;
        }
    }
}
