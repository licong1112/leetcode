/**
 * Practiced on 12/3/2012
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */
package com.congli.leetcode;

public class CountAndSay {

	public String countAndSay(int n) 
	{
        String string = "1";
        
        while(n > 1)
        {
            String newString = genStr(string);
            --n;
            string = newString;
        }
        
        return string;
    }
    
    private String genStr(String string)
    {
        string += "0";
        String result = "";
        int count = 0;
        
        for(int i = 0; i < string.length()-1; ++i)
        {
            ++count;
            if(string.charAt(i+1) != string.charAt(i))
            {
                Integer countInt = new Integer(count);
                result += countInt.toString() + string.charAt(i);
                count = 0;
            }
        }
        return result;
    }
}
