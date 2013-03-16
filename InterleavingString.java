/**
 * Practiced on 12/6/2012
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */

package com.congli.leetcode;

public class InterleavingString {
	
	public boolean isInterleave(String s1, String s2, String s3) 
	{
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1 == null && s2 == null) return false;
        if(s3 == null) return false;
        if(s1 == null) return s2.equals(s3) ? true : false;
        if(s2 == null) return s1.equals(s3) ? true : false;
        
        boolean[][] matrix = new boolean[s1.length()+1][s2.length()+1];
        matrix[0][0] = true;
        
        for(int i = 1; i < s1.length()+1; ++i)
        {
            matrix[i][0] = s1.charAt(i-1) == s3.charAt(i-1) ? true : false;
        }
        
        for(int i = 1; i < s2.length()+1; ++i)
        {
            matrix[0][i] = s2.charAt(i-1) == s3.charAt(i-1) ? true : false;
        }
        
        for(int i = 1; i < s1.length()+1; ++i)
        {
            for(int j = 1; j < s2.length()+1; ++j)
            {
                 if(matrix[i-1][j] == true && s1.charAt(i-1) == s3.charAt(i+j-1))
                	 matrix[i][j] = true;
                 else if(matrix[i][j-1] == true && s2.charAt(j-1) == s3.charAt(i+j-1))
                	 matrix[i][j] = true;
                 else
                	 matrix[i][j] = false;       
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}
