/**
 * Practiced on 12/3/2012
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * ==============================
 * Dynamic programming is used. It is very tricky to determine the first two elements.
 * You need to be very careful with '0'.
 */

package com.congli.leetcode;

public class DecodeWays {

	public int numDecodings(String s) 
	{
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        
        int[] resultArray = new int[s.length()];
        resultArray[0] = 1;
        
        if(s.length() == 1) return resultArray[0];
        
        if(validTwoDigits(s.substring(0, 2)))
        {
            resultArray[1] = s.charAt(1) == '0' ? 1 : 2;
        }
        else
        {
            resultArray[1] = s.charAt(1) == '0' ? 0 : 1;
        }

        for(int i = 2; i < s.length(); ++i)
        {
            if(s.charAt(i) != '0')
            {
                resultArray[i] += resultArray[i-1];
            }
            if(validTwoDigits(s.substring(i-1, i+1)))
            {
                resultArray[i] += resultArray[i-2];
            }
            if(resultArray[i] == 0)
                return 0;
        }
        return resultArray[resultArray.length-1];
    }
    
    private boolean validTwoDigits(String str)
    {
        int num = Integer.parseInt(str);
        if(num <= 26 && num >= 10)
            return true;
        else 
            return false;
    }
}
