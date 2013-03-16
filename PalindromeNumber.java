/**
 * Practiced on 12/13/2012
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * ================================
 * Directly come up with the correct solution without help. Yeah!
 * isPalindrome() function is written by myself. 
 * A better one is isPalindromeBetter().
 */

package com.congli.leetcode;

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) 
	{
		if(x < 0) return false;
        int temp = x;
        int numDigits = 0;
        while(temp > 0)
        {
            temp /= 10;
            ++numDigits;
        }
        
        int highNum = x;
        int lowNum = x;
        for(int i = 0; i < numDigits/2; ++i)
        {
            int highDigit = (int) (highNum / (Math.pow(10, numDigits-i-1)));
            highNum = (int) (highNum % (Math.pow(10, numDigits-i-1)));
            int lowDigit = (lowNum % 10);
            lowNum /= 10;
            if(Math.abs(highDigit) != lowDigit) return false;
        }
        return true;
    }
	
	public boolean isPalindromeBetter(int x)
	{
		if(x < 0) return false;
		
		int div = 1;
		
		// This while loop is very smart. It can avoid overflow of div!
		while(x / div >= 10)
			div *= 10;
		
		while(x > 0)
		{
			int l = x / div;
			int r = x % 10;
			if(l != r) return false;
			x = (x%div)/10;
			div /= 100;
		}
		return true;
	}
}
