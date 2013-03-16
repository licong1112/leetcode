/**
 * Practiced on 12/2/2012
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * =============================
 * Fibonacci number.
 */

package com.congli.leetcode;

public class ClimbingStairs {

	public int climbStairs(int n) 
	{
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        
        int[] result = new int[2]; 
        result[0] = 1;
        result[1] = 1;
        
        for(int i = 2; i <= n; ++i)
        {
            int temp = result[0] + result[1];
            result[0] = result[1];
            result[1] = temp;
        }
        return result[1];
    }
}
