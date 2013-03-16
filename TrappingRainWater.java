/**
 * Practiced on 1/22/2013
 * 
 * Given n non-negative integers representing an elevation map where 
 * the width of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * ================================================
 * It's tricky to come up with the O(n) method.
 * 
 * For each position, we need to look toward left and right, and see how high it is
 * to left and right. Then how much water it can contain at this specific position
 * depends on how low current position is, compare to the lower side.
 * 
 * For example, at position 4, the height is 1. Its left has largest height 2, and
 * its right has largest height 3. So the lower side has height 2. It's 1 unit larger
 * than current position's height. So position 4 can contain 2-1=1 unit water.
 */

package com.congli.leetcode;

public class TrappingRainWater {
	
	public int trap(int[] A) 
	{
        if(A.length <= 2) return 0;
        
        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        maxLeft[0] = A[0];
        maxRight[A.length-1] = A[A.length-1];
        
        for(int i = 1; i < A.length; ++i)
            maxLeft[i] = Math.max(maxLeft[i-1], A[i]);
        
        for(int i = A.length-2; i >= 0; --i)
            maxRight[i] = Math.max(maxRight[i+1], A[i]);
        
        int result = 0;
        for(int i = 0; i < A.length; ++i)
        {
        	int minSide = Math.min(maxLeft[i], maxRight[i]);
            if(A[i] < minSide)
                result += (minSide - A[i]);
        }
        return result;
    }
}
