/**
 * Practiced on 12/6/2012
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

package com.congli.leetcode;

public class JumpGame {
	public boolean canJump(int[] a) 
	{
        if(a == null || a.length == 0) return false;
        if(a.length == 1) return true;
        
        boolean[] visited = new boolean[a.length]; // initialized as false
        
        for(int i = 0; i < a.length; ++i)
        {
            int currPosition = i;
            while(currPosition < a.length-1 && !visited[currPosition])
            {
                if(a[currPosition] == 0) return false;
                visited[currPosition] = true;
                currPosition += a[currPosition];
            }
            if(currPosition >= a.length-1) return true;
        }
        return false;
    }
}
