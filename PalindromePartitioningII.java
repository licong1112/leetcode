/**
 * Practiced on 3/2/2013
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * =================================================
 * O(n^2) algorithm is needed. The following code is concise, and it can be seen that
 * two DPs are performed simultaneously. 
 * 
 * Obviously that we can firstly calculate dp[][], and then calculate result[], but
 * then the code will be much longer.
 */

package com.congli.leetcode;

public class PalindromePartitioningII {
	public int minCut(String s) {
        if(s.length() <= 1) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] result = new int[s.length()];
        
        for(int i = 1; i < s.length(); ++i)
        {
            int count = i;
            for(int j = 0; j <= i; ++j)
            {
                dp[j][i] = (s.charAt(j) == s.charAt(i)) && ((j+1 < i-1) ? dp[j+1][i-1] : true);
                if(j > 0 && dp[j][i])
                    count = Math.min(count, result[j-1]+1);
            }
            result[i] = dp[0][i] ? 0 : count;
        }
        return result[s.length()-1];
    }
}
