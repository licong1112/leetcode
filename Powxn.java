/**
 * Practiced on 12/18/2012
 * 
 * Implement pow(x, n).
 * 
 * =============================
 * The following code is fantastic. The idea is to think of n as its binary representation.
 * For example: n = 5 (101)
 * 
 * 1. The first binary digit is 1. So result *= temp = x; temp *= temp = x^2;
 * 2. The second binary digit is 0. So don't touch result, temp *= temp = x^4;
 * 3. The third binary digit is 1. So result *= temp = x^5.
 * 
 * It is equivalent to think of 5 = 1+4. So first multiply result with x once, and then four times.
 */

package com.congli.leetcode;

public class Powxn {
	
	public double pow(double x, int n) 
    {
        if(n == 0) return 1.0;
        boolean isNeg = false;
        if(n < 0)
        {
            isNeg = true;
            n = -n;
        }
        
        double temp = x;
        double result = 1;
        while(n > 0)
        {
            if((n&1) == 1)
                result *= temp;
            temp *= temp;
            n >>= 1;
        }
        
        if(isNeg) return 1/result;
        return result;
    }
}
