/**
 * Practiced on 12/5/2012
 * 
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, 
 * or null if needle is not part of haystack.
 * 
 * ==============================
 * It is said brute force is good enough. 
 * See details: http://www.leetcode.com/2010/10/implement-strstr-to-find-substring-in.html
 */

package com.congli.leetcode;

public class ImplementStrStr {
	
	public String strStr(String haystack, String needle) 
	{
        if(haystack == null || needle == null) return null;
        if(haystack.length() < needle.length()) return null;
        
        for(int i = 0; i < haystack.length()-needle.length()+1; ++i)
        {
            int startI = i;
            int j = 0;
            
            while(j < needle.length())
            {
                if(haystack.charAt(startI) == needle.charAt(j))
                {
                    ++startI;
                    ++j;
                }
                else
                    break;  
            }
            if(j == needle.length())
                return haystack.substring(i);
        }
        return null;
    }

}
