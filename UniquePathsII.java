/**
 * Practiced on 1/29/2013
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 */

package com.congli.leetcode;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) 
	{
        if(obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0 || n == 0 || obstacleGrid[m-1][n-1] == 1) return 0;
        
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        
        for(int i = m-2; i >= 0; --i)
            dp[i][n-1] = obstacleGrid[i][n-1] == 1 ? 0 : dp[i+1][n-1];
        
        for(int i = n-2; i >= 0; --i)
            dp[m-1][i] = obstacleGrid[m-1][i] == 1 ? 0 : dp[m-1][i+1];
        
        for(int i = m-2; i >= 0; --i)
            for(int j = n-2; j >= 0; --j)
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i+1][j] + dp[i][j+1]);
            
        return dp[0][0];
    }
}
