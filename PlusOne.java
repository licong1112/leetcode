/**
 * Practiced on 12/18/2012
 * 
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * ===============================
 * It needs some observations to write simple codes.
 */

package com.congli.leetcode;

public class PlusOne {

	public int[] plusOne(int[] digits) 
	{
        if(digits.length == 0) return digits;
        
        int carrier = 1;
        for(int i = digits.length-1; i >= 0; --i)
        {
            int num = (digits[i]+carrier) % 10;
            carrier = (digits[i]+carrier) / 10;
            digits[i] = num;
        }
        
        if(carrier == 0)
            return digits;
        
        // If carrier == 1, it means digit[0] = 0 already.
        int[] result = new int[digits.length+1];
        result[0] = 1;
        for(int j = 0; j < digits.length; ++j)
            result[j+1] = digits[j];
    
        return result;
    }
}
