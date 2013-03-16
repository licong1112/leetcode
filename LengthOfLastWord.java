/**
 * Practiced on 12/8/2012
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */

package com.congli.leetcode;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) 
	{    
        int length = 0;
        
        for(int i = s.length()-1; i >= 0; --i)
        {
            if(s.charAt(i) != ' ')
                ++length;
            else if(s.charAt(i) == ' ' && length > 0)
                return length;
        }
        return length;
    }
}
