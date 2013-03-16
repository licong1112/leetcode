/**
 * Practiced on 12/11/2012
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top 
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * ======================================
 * DP is the solution. Suppose the DP matrix is called "matrix", then for any
 * matrix[i][j], we know that matrix[i][j] = min{matrix[i-1][j], matrix[i][j-1]}+grid[i][j].
 * The first term in "min{}" means we go down from (i-1, j) to (i, j).
 * The second term in "min{}" means we go right from (i, j-1) to (i, j).
 * 
 * The space complexity could be O(max{m, n}), since every time we traverse row i,
 * we only need to store the information of the i-1_th row of matrix[][].
 */

package com.congli.leetcode;

public class MinimumPathSum {
	
	public int minPathSum(int[][] grid) 
    {
        if(grid == null || grid.length == 0) return 0;
        
        int[] sum1 = new int[grid[0].length];
        int sumFirstRow = 0;
        for(int i = 0; i < sum1.length; ++i)
        {
            sumFirstRow += grid[0][i];
            sum1[i] = sumFirstRow;
        }
        
        int sumFirstCol = grid[0][0];
        for(int i = 1; i < grid.length; ++i)
        {
            int[] sum2 = new int[grid[0].length];
            sumFirstCol += grid[i][0];
            sum2[0] = sumFirstCol;
            for(int j = 1; j < sum2.length; ++j)
            {
                sum2[j] = Math.min(sum1[j], sum2[j-1])+grid[i][j];
            }
            sum1 = sum2;
        }
        
        return sum1[sum1.length-1];
    }
}
