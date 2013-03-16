/**
 * Practiced on 12/9/2012
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [-2, 1, 3, 4, -1, 2, 1, -5, 4], 
 * the contiguous subarray [4, -1, 2, 1] has the largest sum = 6.
 */

package com.congli.leetcode;

public class MaximumSubarray {
	public int maxSubArray(int[] array) 
	{
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < array.length; ++i)
        {
            sum = Math.max(array[i], sum+array[i]);
            maxSum = Math.max(sum, maxSum);
        }
        
        return maxSum;
    }
}
