/**
 * Practiced on 1/2/2013.
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you 
 * have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit 
 * integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option? You would 
 * then have to re-design the function (ie, add an extra parameter).
 */

package com.congli.leetcode;

public class ReverseInteger {

	public int reverse(int x) 
	{
        if(x == 0) return x;
        
        boolean isNeg = x < 0;
        x = Math.abs(x);
        String num = "";
        
        while(x != 0)
        {
            int digit = x % 10;
            x /= 10;
            num += Integer.toString(digit); // Digits are reversed here.
        }
        
        long resultLong = Long.parseLong(num); // In case it overflows.
        if(isNeg)
        {
            resultLong = -resultLong;
            return resultLong < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)resultLong;
        }
        return resultLong > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)resultLong;
    }

}
