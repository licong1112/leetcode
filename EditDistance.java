/**
 * Practiced on 12/4/2012
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *  
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * ===============================
 * Dynamic programming gives O(mn) time complexity. Two different methods can be implemented
 * with O(k^2) space complexity and O(k) space complexity. Here k = max{m, n}.
 */

package com.congli.leetcode;

public class EditDistance {

	public int minDistanceSquareSpace(String word1, String word2) 
	{
        int[] dp = new int[word2.length()+1];
        int[] dpNext = new int[word2.length()+1];
        
        for(int i = 0; i < word2.length()+1; ++i)
            dp[i] = i;
        
        for(int i = 1; i < word1.length()+1; ++i)
        {
            dpNext[0] = i;
            
            for(int j = 1; j < word2.length()+1; ++j)
            {
                int temp = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
                dpNext[j] = Math.min(Math.min(dp[j]+1, dpNext[j-1]+1), dp[j-1]+temp);
            }
            
            int[] tempArray = new int[1];
            tempArray = dp;
            dp = dpNext;
            dpNext = tempArray;
        }
        return dp[word2.length()];
    }
	
	
	public int minDistanceLinearSpace(String word1, String word2) 
	{
        int[][] matrix = new int[word1.length()+1][word2.length()+1];
        
        for(int i = 0; i <= word1.length(); ++i)
            matrix[i][0] = i;
        
        for(int i = 0; i <= word2.length(); ++i)
            matrix[0][i] = i;
        
        for(int i = 1; i <= word1.length(); ++i)
        {
            for(int j = 1; j <= word2.length(); ++j)
            {
                int temp = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
                matrix[i][j] = Math.min(Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1), matrix[i-1][j-1]+temp);
            }
        }
        return matrix[word1.length()][word2.length()];
    }
}
