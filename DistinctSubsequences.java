/**
 * Practiced on 12/3/2012
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * ==============================
 * It takes a little while to think of the DP formula.
 */

package com.congli.leetcode;

public class DistinctSubsequences {

	 public int numDistinct(String S, String T) 
	 {  
        if(S == null || T == null || S.length() == 0 || T.length() == 0) return 0;
        if(S.length() < T.length()) return 0;
        
        int[][] matrix = new int[S.length()][T.length()];
        
        matrix[0][0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
        
        for(int t = 1; t < T.length(); ++t)
        {
            matrix[0][t] = 0;
        }
        
        for(int s = 1; s < S.length(); ++s)
        {
            matrix[s][0] = matrix[s-1][0];
            if(S.charAt(s) == T.charAt(0))
                matrix[s][0] += 1;
        }
        
        for(int s = 1; s < S.length(); ++s)
        {
            for(int t = 1; t < T.length(); ++t)
            {
                matrix[s][t] = matrix[s-1][t];
                if(S.charAt(s) == T.charAt(t))
                    matrix[s][t] += matrix[s-1][t-1];
            }
        }
        return matrix[S.length()-1][T.length()-1]; 
    }
}
