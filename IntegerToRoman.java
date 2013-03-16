/**
 * Practiced on 12/5/2012
 * 
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * ==================================
 * There is a solution that uses less codes: http://www.mitbbs.com/article_t/JobHunting/32273485.html
 * But I don't think it's a good solution. Too many manual works.
 */

package com.congli.leetcode;

public class IntegerToRoman {
	
	private static final char[] romanLetters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	
	public String intToRoman(int num) 
	{
	    String result = "";
	    int index = -1;
	    while(num > 0)
	    {
	        int digit = num % 10;
	        num /= 10;
	        ++index;
	        if(digit == 0) continue;
	        
	        result = processDigit(digit, index) + result;
	    }
	    return result;
	}
	
	private String processDigit(int digit, int index)
	{
	    String digitResult = "";
	    
	    if(digit == 4 || digit == 9)
	    {
	        digitResult += romanLetters[index*2];
	        digitResult += (digit == 4 ? romanLetters[index*2+1] : romanLetters[index*2+2]);
	    }
	    else
	    {
	        int minusFiveOrNot = digit <= 3 ? 0 : 5;
	        digitResult += (digit <= 3 ? "" : romanLetters[index*2+1]);
	        for(int i = 1; i <= digit-minusFiveOrNot; ++i)
	            digitResult += romanLetters[index*2];
	    }
	    return digitResult;
	}
}
