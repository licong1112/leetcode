/**
 * Practiced on 12/7/2012
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
 * then 3 steps to the last index.)
 * 
 * ==============================
 * A straightforward method is DP. But the worst case is O(n^2).
 * Need to dig into O(n) algorithm.
 */

package com.congli.leetcode;

public class JumpGameII {

	public int jump(int[] a) 
	{
        if(a == null || a.length == 0 || a.length == 1) return 0;
        
        int[] dp = new int[a.length];
        dp[a.length-1] = 0;
        
        for(int i = a.length-2; i >= 0; --i)
        {
            int currPos = i;
            if(currPos + a[currPos] >= a.length-1)
                dp[i] = 1;
            else
            {
                int dpCurr = Integer.MAX_VALUE-1;
                for(int j = 1; j <= a[currPos]; ++j)
                {
                    dpCurr = Math.min(dpCurr, dp[currPos+j]);
                }
                dp[currPos] = dpCurr+1;
            }
        }
        return dp[0];
    }
}
