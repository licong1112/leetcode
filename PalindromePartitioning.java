/**
 * Practiced on 3/2/2013
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 *   
 *   ==================================================
 *   Note how the dp[][] is built concisely.
 */

package com.congli.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) 
	{
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(s.length() == 0) return result;
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); ++i)
        	dp[i][i] = true;
        
        for(int i = 1; i < s.length(); ++i)
        	for(int j = 0; j <= i; ++j)
        		dp[j][i] = s.charAt(j) == s.charAt(i) && ((j+1 <= i-1) ? dp[j+1][i-1] : true); 
        
        build_result(result, new ArrayList<String>(), s, 0, 0, dp);
        return result;
    }
    
    private void build_result(ArrayList<ArrayList<String>> result, ArrayList<String> list, String s, int x, int y, boolean[][] dp)
    {
        if(x == s.length())
        {
            result.add((ArrayList<String>)list.clone());
            return;
        }
        for(int j = y; j < s.length(); ++j)
        {
            if(dp[x][j])
            {
                list.add(s.substring(x, j+1));
                build_result(result, list, s, j+1, j+1, dp);
                list.remove(list.size()-1);
            }
        }
    }
}
