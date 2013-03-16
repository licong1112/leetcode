/**
 * Practiced on 1/15/2013
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * ==========================================
 * Binary search is the method.
 * 
 * Need to be careful when x is very large. We should avoid the case of considering candidate
 * r, which r*r > Integer.MAX_VALUE.
 */

package com.congli.leetcode;

public class SqrtX {
	public int sqrt(int x) 
	{
        if(x <= 0) return 0;
        int start = 1;
        int end = x;  
           
        while(start <= end)
        {           
            int mid = start + (end-start)/2;
            if(Integer.MAX_VALUE / mid < mid) // This imples mid*mid must be larger than MAX_VALUE!
                end = mid-1;
            else
            {
                if(mid*mid == x) return mid;
                if(mid*mid < x)
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return start-1;
    }
}
