/**
 * Practiced on 1/7/2013
 * 
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty 
 * substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled 
 * string "rgeat".
 * 
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled 
 * string "rgtae".
 * 
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * =========================================
 * This problem is difficult. Here is the idea:
 * 
 * For a substring of s1, s1_s to be scrambled of a substring of s2, s2_s, there must be a separate 
 * of s1_s, ie s11_s & s12_s, which are both scrambled of s2_s, such that either s11_s + s12_s or
 * s12_s + s11_s is equal to (thus contained in) s2_s.
 * 
 * Therefore, we can use DP to solve this problem. For each substring s1[i, j], assume there is a 
 * k such that s1[i, k] and s1[k, j] are scrambled of a substring of s2, then both s1[i, k] and
 * s1[k, j] must be contained in s2. Then, since we already known s1[i, k] and s1[k, j], we just 
 * need to test if s1[i, k] + s1[k, j] or s1[k, j] + s1[i, k] is equal to a substring of s2, which 
 * is to test if it is contained in s2. 
 */

package com.congli.leetcode;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) 
    {
        int length = s1.length();
        if(length == 1) return s1.equals(s2);
        
        String[][] matrix = new String[length][length];
        
        for(int i = 0; i < length; ++i)
            matrix[i][i] = s1.substring(i, i+1);
        
        for(int offset = 1; offset < length; ++offset)
        {
            for(int start = 0; start < length-offset; ++start)
            {
                for(int separate = start; separate < start+offset; ++separate)
                {
                    if(matrix[start][separate]==null || matrix[separate+1][start+offset]==null)
                        continue;
                    String temp1 = matrix[start][separate] + matrix[separate+1][start+offset];
                    if(s2.contains(temp1))
                    {
                        matrix[start][start+offset] = temp1;
                        break;
                    }
                    temp1 = matrix[separate+1][start+offset] + matrix[start][separate];
                    if(s2.contains(temp1))
                    {
                        matrix[start][start+offset] = temp1;
                        break;
                    }
                }
            }
        }
        
        return matrix[0][length-1]!=null;
    }
}
