/**
 * Practiced on 12/3/2012
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * ===========================
 * Very difficult to write it correctly.
 */

package com.congli.leetcode;

public class DivideTwoIntegers {

	public int divide(int dividend, int divisor)
	{
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        
        long dividendL = dividend;
        long divisorL = divisor;
        
        boolean neg = false;
        if(dividend < 0) neg = !neg;
        if(divisor < 0) neg = !neg;
        
        dividendL = Math.abs(dividendL);
        divisorL = Math.abs(divisorL);
        
        int index = 0;

        while((divisorL << index) <= dividendL)
        {
            ++index;
        }
        
        int result = 0;
        for(int i = index; i >= 0; --i)
        {
            if((divisorL << i) <= dividendL)
            {
                result |= (1 << i);
                dividendL -= (divisorL << i);
            }
        }
        
        if(neg) result = -result;
        return result;
    }
	
	public static void main(String[] args) {
		DivideTwoIntegers test = new DivideTwoIntegers();
		System.out.println(test.divide(10, 3));
	}

}
