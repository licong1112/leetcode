/**
 * Practiced on 2/5/2013
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

package com.congli.leetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s) 
	{
        if(s == null || s.length() == 0) return true;
        s = s.toLowerCase();
       
        int low = 0;
        int high = s.length()-1;
       
        while(low <= high)
        {
            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);
           
            if(!validChar(lowChar)) ++low;
            else if(!validChar(highChar)) --high;
            else if(lowChar != highChar) return false;
            else
            {
                ++low;
                --high;
            }
        }
        return true;
    }
   
    private boolean validChar(char c)
    {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        return false;
    }
}
