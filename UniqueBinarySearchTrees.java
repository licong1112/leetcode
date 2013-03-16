/**
 * Practiced on 1/24/2013
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *    
 * ====================================================
 * One key observation is that, the number of BST's only depends on the number of nodes.
 * For example, in array {1, 2, 3, 4, 5, 6}, the number of BST's that is constructed with 
 * nodes 1, 2, 3, is the same as the number of BST's that is constructed with nodes
 * 2, 3, 4, or 3, 4, 5, or 4, 5, 6.
 */

package com.congli.leetcode;

public class UniqueBinarySearchTrees {
	
	public int numTrees(int n) 
	{
        int[] dp = new int[n];
        dp[0] = 1;
       
        for(int i = 1; i < n; ++i)
        {
            int temp = 2*dp[i-1];
            for(int root = 1; root < i; ++root)
                temp += dp[root-1]*dp[i-root-1];
               
            dp[i] = temp;
        }
        return dp[n-1];
    }
}
