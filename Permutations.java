/**
 * Practiced on 12/17/2012
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * =============================
 * The following implementation does not use recursion, but it keeps building
 * and deleting arraylists. Thus I believe it's slower.
 * 
 * For another implementation that does not have this problem, but use recursion,
 * check "PermutationsAnotherImplementation.java".
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class Permutations {
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) 
	{
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return null;
        
        ArrayList<Integer> listInitial = new ArrayList<Integer>();
        listInitial.add(num[0]);
        result.add(listInitial);
        
        for(int i = 1; i < num.length; ++i)
        {
            ArrayList<ArrayList<Integer>> newResult = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> list : result)
            {
                for(int j = 0; j <= list.size(); ++j)
                {
                    ArrayList<Integer> newList = new ArrayList<Integer>();
                    getNewList(list, num[i], j, newList);
                    newResult.add(newList);
                }
            }
            result = newResult;
        }
        return result;
    }
    
    private void getNewList(ArrayList<Integer> list, int num, int j, ArrayList<Integer> newList)
    {
        for(int i = 0; i < j; ++i)
        {
            newList.add(list.get(i));
        }
        newList.add(num);
        for(int i = j; i < list.size(); ++i)
        {
            newList.add(list.get(i));
        }
    }
}
