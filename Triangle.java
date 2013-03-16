/**
 * Practiced on 1/24/2013
 * 
 * Given a triangle, find the minimum path sum from top to bottom. Each step you 
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is 
 * the total number of rows in the triangle.
 * 
 * ==========================================================
 * Let f(r, c) contains the minimum sum from the root to the r-th row, c-th column node. Then:
 * f(r, c) = node(r, c) + min{f(r-1, c-1), f(r-1,c)}.
 * Dynamic programming can achieve O(n) space complexity.

 */

package com.congli.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) 
	{
        if(triangle == null || triangle.size() == 0) return 0;
       
        int n = triangle.size();
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = triangle.get(0).get(0);
       
        for(int i = 1; i < triangle.size(); ++i)
            for(int j = triangle.get(i).size()-1; j >= 0; --j)
                dp[j+1] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
       
        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= n; ++i)
            result = Math.min(result, dp[i]);
       
        return result;
    }
}
