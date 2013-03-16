/**
 * Practiced on 12/2/2012
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at 
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line 
 * i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a 
 * container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * ===================================
 * It is not easy to understand the O(n) algorithm:
 * 
 * 1. Start from left = 0, right = height.length-1, calculate the volume of water.
 * 2. Always remove the shorter bar towards the middle. Why? 
 *    (1) If [left, right] is the solution, then it doesn't matter if we move the
 *        shorter bar or higher bar;
 *    (2) If [left, right] is not the solution, but somewhere in between, say
 *        [leftResult, rightResult], it must because 
 *        				
 *        			min{left, right} < min{leftResult, rightResult}
 *        
 *        Therefore it always make sense to move the shorter bar towards the center.
 * 
 */

package com.congli.leetcode;

public class ContainerWithMostWater {

	public int maxArea(int[] height) 
	{
        int left = 0;
        int right = height.length-1;
        int max = Integer.MIN_VALUE;
        
        while(left < right)
        {
        	int temp = Math.min(height[left], height[right]) * (right-left);
        	max = Math.max(max, temp);
        	if(height[left] <= height[right])
        	{
        		++left;
        	}
        	else
        		--right;
        }
        return max;
	}
}
